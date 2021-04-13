/* UserPrefsAccessor.java
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
 
/* DO NOT HAND-EDIT! This file is automatically generated from the formal user preference schema
 * JSON. To add a preference, add it to "user-prefs-schema.json", then run "generate-prefs.R" to
 * rebuild this file.
 */

package org.rstudio.studio.client.workbench.prefs.model;

import org.rstudio.core.client.js.JsObject;
import org.rstudio.studio.client.workbench.model.SessionInfo;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsArray;
import org.rstudio.core.client.JsArrayUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import org.rstudio.studio.client.workbench.prefs.model.UserPrefsAccessorConstants;


/**
 * Accessor class for user preferences.
 */ 
public class UserPrefsAccessor extends Prefs
{
   public UserPrefsAccessor(SessionInfo sessionInfo, 
                            JsArray<PrefLayer> prefLayers)
   {
      super(prefLayers);
   }
   
%PREFS%   

   public int userLayer()
   {
      return LAYER_USER;
   }

   public int projectLayer()
   {
      return LAYER_PROJECT;
   }

   public static final int LAYER_DEFAULT  = 0;
   public static final int LAYER_COMPUTED = 1;
   public static final int LAYER_SYSTEM   = 2;
   public static final int LAYER_USER     = 3;
   public static final int LAYER_PROJECT  = 4;

   private UserPrefsAccessorConstants _constants = GWT.create(UserPrefsAccessorConstants.class);
}
