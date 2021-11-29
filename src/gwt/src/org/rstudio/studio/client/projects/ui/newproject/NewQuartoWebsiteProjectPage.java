/*
 * NewQuartoWebsiteProjectPage.java
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
package org.rstudio.studio.client.projects.ui.newproject;

import com.google.gwt.core.client.GWT;
import org.rstudio.core.client.resources.ImageResource2x;
import org.rstudio.studio.client.projects.StudioClientProjectConstants;
import org.rstudio.studio.client.quarto.model.QuartoConstants;

public class NewQuartoWebsiteProjectPage extends NewQuartoProjectPage
{
   public NewQuartoWebsiteProjectPage()
   {
      super(QuartoConstants.PROJECT_WEBSITE,
           constants_.quartoWebsiteTitle(),
           constants_.quartoWebsiteSubTitle(),
           constants_.quartoWebsitePageCaption(),
            new ImageResource2x(NewProjectResources.INSTANCE.quartoWebsiteIcon2x()),
            new ImageResource2x(NewProjectResources.INSTANCE.quartoWebsiteIconLarge2x()));
   }
   private static final StudioClientProjectConstants constants_ = GWT.create(StudioClientProjectConstants.class);

}
