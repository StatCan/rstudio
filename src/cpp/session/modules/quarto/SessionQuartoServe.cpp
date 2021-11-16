/*
 * SessionQuartoServe.cpp
 *
 * Copyright (C) 2021 by RStudio, PBC
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */

#include "SessionQuartoServe.hpp"

#include <string>

#include <shared_core/Error.hpp>
#include <core/Exec.hpp>
#include <core/RegexUtils.hpp>
#include <core/json/JsonRpc.hpp>
#include <core/WaitUtils.hpp>

#include <r/RExec.hpp>

#include <session/SessionModuleContext.hpp>
#include <session/SessionQuarto.hpp>

#include "SessionQuartoJob.hpp"

using namespace rstudio::core;
using namespace rstudio::session::module_context;

namespace rstudio {
namespace session {

using namespace quarto;
using namespace modules::quarto;

namespace  {

const char * const kFormatDefault = "default";

FilePath quartoProjectDir()
{
   return module_context::resolveAliasedPath(
      quartoConfig().project_dir
   );
}

std::string pathForOutputFile(const core::FilePath& outputFile)
{
   if (!outputFile.isEmpty())
   {
      FilePath quartoProjectOutputDir = quartoProjectDir().completeChildPath(
         quartoConfig().project_output_dir
      );
      std::string path = outputFile.isWithin(quartoProjectOutputDir)
                            ? outputFile.getRelativePath(quartoProjectOutputDir)
                            :  std::string();
      return path;
   }
   else
   {
      return "";
   }
}

std::string serverUrl(long port, const std::string& path = "")
{
   // url w. port
   std::string url = "http://localhost:" + safe_convert::numberToString(port) + "/";
   return url + path;
}

class QuartoServe : public QuartoJob
{
public:
   static Error create(const std::string& format,
                       bool render,
                       const std::string& path,
                       boost::shared_ptr<QuartoServe>* pServe)
   {
      pServe->reset(new QuartoServe(format, render, path));
      return (*pServe)->start();
   }

   virtual ~QuartoServe()
   {
   }

   std::string format()
   {
      return format_;
   }

   int port()
   {
      return port_;
   }

   std::string jobId()
   {
      return pJob_->id();
   }


protected:
   explicit QuartoServe(const std::string& format, bool render, const std::string& path)
      : QuartoJob(), port_(0), format_(format), render_(render), path_(path)
   {
   }

   virtual std::string name()
   {
      const std::string type =
         quartoConfig().project_type == kQuartoProjectBook
            ? "Book"
            : "Website";
      const std::string name = (render_ ? "Render and " : "")  + std::string("Serve ") + type;
      return name;
   }

   virtual std::vector<std::string> args()
   {
      std::vector<std::string> args({"preview", "--no-browse"});
      if (render_)
      {
         args.push_back("--render");
         args.push_back(format_);
      }
      else if (format_ != kFormatDefault)
      {
         args.push_back("--to");
         args.push_back(format_);
      }
      args.push_back("--no-watch-inputs");
      return args;
   }

   virtual core::FilePath workingDir()
   {
      return quartoProjectDir();
   }

   virtual void onStdErr(const std::string& error)
   {
      // detect browse directive
      if (port_ == 0)
      {
         auto location = quartoServerLocationFromOutput(error);
         if (location.port > 0)
         {
            // set port
            port_ = location.port;

            // set path if we got one
            if (!location.path.empty())
               path_ = location.path;

            // launch viewer
            module_context::viewer(serverUrl(port_, path_),
                                   -1,
                                   module_context::QuartoNavigate::navWebsite(pJob_->id()));

            // now that the dev server is running restore the console tab
            ClientEvent activateConsoleEvent(client_events::kConsoleActivate, false);
            module_context::enqueClientEvent(activateConsoleEvent);

            // emit filtered output if we are on rstudio server
            if (session::options().programMode() == kSessionProgramModeServer)
            {
               QuartoJob::onStdErr(location.filteredOutput);
               return;
            }
         }
      }

      // standard output forwarding
      QuartoJob::onStdErr(error);
   }

private:
   int port_;
   std::string format_;
   bool render_;
   std::string path_;
};

// serve singleton
boost::shared_ptr<QuartoServe> s_pServe;

// stop any running server and remove the job
void stopServer()
{
   if (s_pServe)
   {
      // stop the job if it's running
      if (s_pServe->isRunning())
         s_pServe->stop();

      // remove the job (will be replaced by a new quarto serve)
      s_pServe->remove();
   }
}

Error quartoServe(const std::string& format,
                  bool render,
                  const std::string& path = "")
{
   // stop any running server
   stopServer();

   // start a new server
   return QuartoServe::create(format, render, path, &s_pServe);
}

Error quartoServeRpc(const json::JsonRpcRequest& request,
                     json::JsonRpcResponse*)
{
   // read params
   std::string format;
   bool render;
   Error error = json::readParams(request.params, &format, &render);
   if (error)
      return error;

   return quartoServe(format, render);
}

bool isJobServeRunning()
{
   return s_pServe && s_pServe->isRunning();
}


void navigateToViewer(long port, const std::string& path, const std::string& jobId)
{
   // if the viewer is already on the site just activate it
   if (boost::algorithm::starts_with(
          module_context::viewerCurrentUrl(false), serverUrl(port)))
   {
      module_context::activatePane("viewer");
   }
   else
   {
      module_context::viewer(
          serverUrl(port, path),
          -1,
          module_context::QuartoNavigate::navWebsite(jobId)
      );
   }
}

bool isNewQuartoBuild(const std::string& renderOutput)
{
   static const boost::regex quartoBuildRe("file:\\/.*?\\/src\\/quarto.ts\\s");
   return regex_utils::textMatches(renderOutput, quartoBuildRe, false, true);
}



} // anonymous namespace


namespace quarto {

std::string quartoDefaultFormat(const core::FilePath& outputFile)
{
    // if we have a running book preview then use that as the default format
   if (isFileInSessionQuartoProject(outputFile) &&
       isJobServeRunning() &&
       quartoConfig().project_type == kQuartoProjectBook)
   {
     std::string format = s_pServe->format();
     if (format != kFormatDefault)
        return format;
     else
        return "default";
   }
   else
   {
      return "default";
   }
}

} // namespace quarto

namespace modules {
namespace quarto {
namespace serve {


void previewDoc(const std::string& renderOutput, const std::string& path, const std::string& format)
{
   if (isJobServeRunning() &&
       (s_pServe->format() == format) &&
       !isNewQuartoBuild(renderOutput))
   {
      navigateToViewer(s_pServe->port(), path, s_pServe->jobId());
   }
   else
   {
      Error error = quartoServe(format, false, path);
      if (error)
         LOG_ERROR(error);
   }
}

void previewDocPath(const std::string& renderOutput, const core::FilePath& outputPath)
{
   std::string path;
   std::string format;

   if (outputPath.getExtensionLowerCase() == ".pdf")
   {
      path = "web/viewer.html";
      format = "pdf";
   }
   else
   {
      path = pathForOutputFile(outputPath);
      format = kFormatDefault;
   }

   previewDoc(renderOutput, path, format);
}

Error initialize()
{
   // register rpc functions
  ExecBlock initBlock;
   initBlock.addFunctions()
     (boost::bind(module_context::registerRpcMethod, "quarto_serve", quartoServeRpc))
   ;
   return initBlock.execute();
}

} // namespace serve
} // namespace quarto
} // namespace modules
} // namespace session
} // namespace rstudio
