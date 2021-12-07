/*
 * TerminalShellInfo.java
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
package org.rstudio.studio.client.workbench.views.terminal;

import org.rstudio.studio.client.workbench.prefs.model.UserPrefs;

import com.google.gwt.core.client.JavaScriptObject;

public class TerminalShellInfo extends JavaScriptObject
{
   protected TerminalShellInfo() {}

   public final native String getShellType() /*-{
      return this.type;
   }-*/;

   public final native String getShellName() /*-{
      return this.name;
   }-*/;

   public static String getShellName(String shell)
   {
      switch (shell)
      {
      case UserPrefs.WINDOWS_TERMINAL_SHELL_DEFAULT:
         return "Default"; //NON-NLS
      case UserPrefs.WINDOWS_TERMINAL_SHELL_WIN_GIT_BASH:
         return "Git Bash"; //NON-NLS
      case UserPrefs.WINDOWS_TERMINAL_SHELL_WIN_WSL_BASH:
         return "WSL";
      case UserPrefs.WINDOWS_TERMINAL_SHELL_WIN_CMD:
         return "Command Prompt"; //NON-NLS
      case UserPrefs.WINDOWS_TERMINAL_SHELL_WIN_PS:
         return "PowerShell";
      case UserPrefs.WINDOWS_TERMINAL_SHELL_PS_CORE:
         return "PowerShell Core"; //NON-NLS
      case UserPrefs.POSIX_TERMINAL_SHELL_BASH:
         return "Bash"; //NON-NLS
      case UserPrefs.POSIX_TERMINAL_SHELL_CUSTOM:
         return "Custom"; //NON-NLS
      case UserPrefs.POSIX_TERMINAL_SHELL_NONE: //NON-NLS
         return "User command";
      case UserPrefs.POSIX_TERMINAL_SHELL_ZSH: //NON-NLS
         return "Zsh"; //NON-NLS
      default:
         return "Unknown";
      }
   }
}
