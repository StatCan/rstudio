/*
 * LineEndingsSelectWidget.java
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

package org.rstudio.studio.client.workbench.prefs.views;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import org.rstudio.core.client.widget.SelectWidget;
import org.rstudio.studio.client.workbench.prefs.PrefsConstants;
import org.rstudio.studio.client.workbench.prefs.model.UserPrefs;
import com.google.gwt.core.client.GWT;

public class LineEndingsSelectWidget extends SelectWidget
{
   // i18n: It implements the enumerator and human readable values directly, plus logic for whether to show all values
   //       or a subset. This class is also used by ProjectEditingPreferencesPane.java, which does not have the same
   //       access to preferences as EditingPreferencesPane.java. Need to investigate. Porting logic will be easy, but
   //       getting the translated values from the lineEndingConversion() PrefValue might be harder.
   public LineEndingsSelectWidget()
   {
      this(false);
   }

   public LineEndingsSelectWidget(boolean includeDefault)
   {
      super(constants_.lineEndingConversion(),
            getLineEndingsCaptions(includeDefault),
            getLineEndingsValues(includeDefault),
            false, 
            true, 
            false);
   }

   private static String[] getLineEndingsCaptions(boolean includeDefault)
   {
      ArrayList<String> captions = new ArrayList<>();
      if (includeDefault)
         captions.add(constants_.useDefaultParentheses());
      captions.add(constants_.none());
      captions.add(constants_.platformNative());
      captions.add(constants_.posixLF());
      captions.add(constants_.windowsCRLF());
      
      return captions.toArray(new String[0]);
   }
   
   private static String[] getLineEndingsValues(boolean includeDefault)
   {
      ArrayList<String> values = new ArrayList<>();
      if (includeDefault)
         values.add(UserPrefs.LINE_ENDING_CONVERSION_DEFAULT);
      values.add(UserPrefs.LINE_ENDING_CONVERSION_PASSTHROUGH);
      values.add(UserPrefs.LINE_ENDING_CONVERSION_NATIVE);
      values.add(UserPrefs.LINE_ENDING_CONVERSION_POSIX);
      values.add(UserPrefs.LINE_ENDING_CONVERSION_WINDOWS);
      
      return values.toArray(new String[0]);
   }
   private static final PrefsConstants constants_ = GWT.create(PrefsConstants.class);
}
