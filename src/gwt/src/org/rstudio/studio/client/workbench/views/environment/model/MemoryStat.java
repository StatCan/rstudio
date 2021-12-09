/*
 * MemoryStat.java
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
package org.rstudio.studio.client.workbench.views.environment.model;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import org.rstudio.studio.client.workbench.views.environment.ViewEnvironmentConstants;

public class MemoryStat extends JavaScriptObject
{
   protected MemoryStat() {}

   public final native int getKb() /*-{
      return this.kb;
   }-*/;

   public final native int getProvider() /*-{
      return this.provider;
   }-*/;

   public final String getProviderName()
   {
      switch(getProvider())
      {
         // i18n: These reach users in the environment pane through the memory usage tool tip.  The first three need
         //       translation.  Does it make sense to also put cgroup, ulimit, in the "translations" even if they don't
         //       get translated, just to keep it consistent?
         default:
         case MEMORY_PROVIDER_UNKNOWN:
            return constants_.unknownCapitalized();
         case MEMORY_PROVIDER_MACOS:
            return constants_.macOsSystem();
         case MEMORY_PROVIDER_WINDOWS:
            return constants_.windowsSystem();
         case MEMORY_PROVIDER_LINUX_CGROUPS:
            return "cgroup"; //$NON-NLS-1$
         case MEMORY_PROVIDER_LINUX_ULIMIT:
            return "ulimit"; //$NON-NLS-1$
         case MEMORY_PROVIDER_LINUX_PROCFS:
            return "/proc filesystem"; //$NON-NLS-1$
         case MEMORY_PROVIDER_LINUX_PROCMEMINFO:
            return "/proc/meminfo"; //$NON-NLS-1$
      }
   }

   public final static int MEMORY_PROVIDER_UNKNOWN           = 0;
   public final static int MEMORY_PROVIDER_MACOS             = 1;
   public final static int MEMORY_PROVIDER_WINDOWS           = 2;
   public final static int MEMORY_PROVIDER_LINUX_CGROUPS     = 3;
   public final static int MEMORY_PROVIDER_LINUX_ULIMIT      = 4;
   public final static int MEMORY_PROVIDER_LINUX_PROCFS      = 5;
   public final static int MEMORY_PROVIDER_LINUX_PROCMEMINFO = 6;
   private static final ViewEnvironmentConstants constants_ = GWT.create(ViewEnvironmentConstants.class);
}
