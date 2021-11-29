/*
 * DataFrameType.java
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
package org.rstudio.studio.client.common.filetypes;

import com.google.gwt.core.client.GWT;
import org.rstudio.core.client.files.FileSystemItem;
import org.rstudio.core.client.resources.ImageResource2x;
import org.rstudio.studio.client.application.events.EventBus;
import org.rstudio.studio.client.common.StudioClientCommonConstants;

public class DataFrameType extends EditableFileType
{
   public DataFrameType()
   {
      super("r_dataframe", constants_.rDataFrameLabel(),
            new ImageResource2x(FileIconResources.INSTANCE.iconRdata2x()));
   }

   @Override
   public void openFile(FileSystemItem file, EventBus eventBus)
   {
      assert false : constants_.openFileMessage();
   }
   private static final StudioClientCommonConstants constants_ = GWT.create(StudioClientCommonConstants.class);
}
