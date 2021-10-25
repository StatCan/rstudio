/*
 * ServerLogVars.cpp
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

#include "ServerLogVars.hpp"

#include <core/LogOptions.hpp>

#include <server/ServerSessionManager.hpp>

using namespace rstudio::core;

namespace rstudio {
namespace server {
namespace log_vars {

namespace {

void sessionProfileFilter(core::r_util::SessionLaunchProfile* pProfile)
{
   core::log::forwardLogOptionsEnvVars(&(pProfile->config.environment));
}

} // anonymous namespace

Error initialize()
{
   sessionManager().addSessionLaunchProfileFilter(sessionProfileFilter);
   return Success();
}

} // namespace log_vars
} // namespace server
} // namespace rstudio
