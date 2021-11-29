/*
 * PanmirrorInsertTabsetDialog.java
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


package org.rstudio.studio.client.panmirror.dialogs;


import com.google.gwt.aria.client.Roles;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.gwt.core.client.GWT;
import org.rstudio.core.client.ElementIds;
import org.rstudio.core.client.dom.DomUtils;
import org.rstudio.core.client.theme.DialogTabLayoutPanel;
import org.rstudio.core.client.theme.VerticalTabPanel;
import org.rstudio.core.client.widget.FormLabel;
import org.rstudio.core.client.widget.ModalDialog;
import org.rstudio.core.client.widget.OperationWithInput;
import org.rstudio.studio.client.RStudioGinjector;
import org.rstudio.studio.client.panmirror.PanmirrorConstants;
import org.rstudio.studio.client.panmirror.dialogs.model.PanmirrorAttrProps;
import org.rstudio.studio.client.panmirror.dialogs.model.PanmirrorInsertTabsetResult;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


public class PanmirrorInsertTabsetDialog extends ModalDialog<PanmirrorInsertTabsetResult>
{
   public PanmirrorInsertTabsetDialog(OperationWithInput<PanmirrorInsertTabsetResult> operation)
   {
      super(_constants.insertTabsetCaption(), Roles.getDialogRole(), operation, () -> {
         // cancel returns null
         operation.execute(null);
      });
      
      // tabs tab
      VerticalTabPanel tabsTab = new VerticalTabPanel(ElementIds.VISUAL_MD_INSERT_TABSET_TABS);
      tabsTab.addStyleName(RES.styles().dialog());
      tabsTab.add(new FormLabel(_constants.tabNamesFormLabel()));
      tabs_.add(addTabCaptionInput(tabsTab, 1, true, false));
      tabs_.add(addTabCaptionInput(tabsTab, 2, true, false));
      tabs_.add(addTabCaptionInput(tabsTab, 3, false));
      tabs_.add(addTabCaptionInput(tabsTab, 4, false));
      tabs_.add(addTabCaptionInput(tabsTab, 5, false));
      tabs_.add(addTabCaptionInput(tabsTab, 6, false));

      // attributes tab
      PanmirrorAttrProps attr = new PanmirrorAttrProps();
      attr.id = "";
      attr.classes = new String[] { "panel-tabset" }; //NON-NLS
      attr.keyvalue = new String[][] {};
      editAttr_ =  new PanmirrorEditAttrWidget();
      editAttr_.setAttr(attr, null);
      VerticalTabPanel attributesTab = new VerticalTabPanel(ElementIds.VISUAL_MD_INSERT_TABSET_ATTRIBUTES);
      attributesTab.addStyleName(RES.styles().dialog());
      attributesTab.add(editAttr_);

      // create tab panel and set as main widget
      DialogTabLayoutPanel tabPanel = new DialogTabLayoutPanel(_constants.imageTabListLabel());
      tabPanel.addStyleName(RES.styles().insertTabsetDialogTabs());
      tabPanel.add(tabsTab, _constants.tabsText(), tabsTab.getBasePanelId());
      tabPanel.add(attributesTab, _constants.attributesText(), attributesTab.getBasePanelId());
      tabPanel.selectTab(0);
      mainWidget_ = tabPanel;
   }

   @Override
   protected Widget createMainWidget()
   {
      return mainWidget_;
   }

   @Override
   public void focusInitialControl()
   {
      tabs_.get(0).setFocus(true);
   }

   @Override
   protected PanmirrorInsertTabsetResult collectInput()
   {  
      PanmirrorInsertTabsetResult result = new PanmirrorInsertTabsetResult();
      result.attr = editAttr_.getAttr();
      result.tabs = tabs_.stream()
       .map((textBox) -> textBox.getText())
       .filter((tab) -> !tab.isEmpty())
       .collect(Collectors.toList()).toArray(new String[] {});
      return result;
   }
   
   @Override
   protected boolean validate(PanmirrorInsertTabsetResult input)
   {
      if (input.tabs.length < 2)
      {
         RStudioGinjector.INSTANCE.getGlobalDisplay().showErrorMessage(
               _constants.insertTabsetCaption(), _constants.tabSetErrorMessage(), tabs_.get(0));
         return false;
      } 
      else
      {
         return true;   
      }
   }
   

   private TextBox addTabCaptionInput(VerticalTabPanel tabsTab, int index, boolean required)
   {
      return addTabCaptionInput(tabsTab, index, required, true);
   }
   
   private TextBox addTabCaptionInput(VerticalTabPanel tabsTab, int index, boolean required, boolean placeholder)
   {
      TextBox textBox = PanmirrorDialogsUtil.addTextBox(tabsTab, ElementIds.VISUAL_MD_INSERT_TABSET_TAB + "_" + index, "");
      if (placeholder)
         DomUtils.setPlaceholder(textBox,_constants.addTabCaptionInput(index, (!required ? " " + _constants.optionalText() : "")));
      return textBox;
   }

   private static PanmirrorDialogsResources RES = PanmirrorDialogsResources.INSTANCE;
   private static final PanmirrorConstants _constants = GWT.create(PanmirrorConstants.class);
   
   private final Widget mainWidget_; 
   private final PanmirrorEditAttrWidget editAttr_;
   private final ArrayList<TextBox> tabs_ = new ArrayList<TextBox>();
}

