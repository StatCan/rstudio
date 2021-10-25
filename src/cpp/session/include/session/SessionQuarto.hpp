/*
 * SessionQuarto.hpp
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

#ifndef SESSION_QUARTO_HPP
#define SESSION_QUARTO_HPP

#include <string>
#include <vector>

#include <shared_core/json/Json.hpp>

namespace rstudio {
namespace core {
class Error;
class FilePath;
} // namespace core
} // namespace rstudio

namespace rstudio {
namespace session {
namespace quarto {

extern const char* const kQuartoCrossrefScope;
extern const char* const kQuartoProjectDefault;
extern const char* const kQuartoProjectSite;
extern const char* const kQuartoProjectBook;

struct QuartoConfig
{
   QuartoConfig() : installed(false), is_project(false) {}
   bool installed;
   std::string version;
   std::string bin_path;
   std::string resources_path;
   bool is_project;
   std::string project_type;
   std::string project_dir;
   std::string project_output_dir;
   std::vector<std::string> project_formats;
   std::vector<std::string> project_bibliographies;
   std::string project_editor;
};

QuartoConfig quartoConfig(bool refresh = false);

core::Error quartoInspect(const std::string& path,
                          core::json::Object *pResultObject);

core::json::Object quartoConfigJSON(bool refresh = false);

core::json::Value quartoCapabilities();

// see if quarto wants to handle the preview
bool handleQuartoPreview(const core::FilePath& sourceFile,
                         const core::FilePath& outputFile,
                         const std::string& renderOutput,
                         bool validateExtendedType);

bool isFileInSessionQuartoProject(const core::FilePath& file);

core::FilePath quartoBinary();

bool projectIsQuarto();

core::FilePath quartoProjectConfigFile(const core::FilePath& filePath);

void readQuartoProjectConfig(const core::FilePath& configFile,
                             std::string* pType,
                             std::string* pOutputDir = nullptr,
                             std::vector<std::string>* pFormats = nullptr,
                             std::vector<std::string>* pBibliographies = nullptr,
                             std::string* pEditor = nullptr);

core::json::Value quartoXRefIndex();

} // namespace quarto
} // namespace session
} // namespace rstudio

#endif /* SESSION_QUARTO_HPP */
