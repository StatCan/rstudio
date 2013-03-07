/*
 * PresentationServerOperations.java
 *
 * Copyright (C) 2009-12 by RStudio, Inc.
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
package org.rstudio.studio.client.workbench.views.presentation.model;

import org.rstudio.studio.client.common.rpubs.model.RPubsServerOperations;
import org.rstudio.studio.client.server.*;
import org.rstudio.studio.client.server.Void;

public interface PresentationServerOperations extends RPubsServerOperations
{
   String getApplicationURL(String url);
   
   void showHelpTopic(String topic, String pkgName) ;
   
   void createStandalonePresentation(
                           String targetFile,
                           ServerRequestCallback<String> requestCallback);
   
   void setPresentationSlideIndex(int index, 
                              ServerRequestCallback<Void> requestCallback);
   
   void presentationExecuteCode(String code,
                                ServerRequestCallback<Void> requestCallback);
   
   void closePresentationPane(ServerRequestCallback<Void> requestCallaback); 
}
