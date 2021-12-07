/*
 * NewQuartoProjectPage.java
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
import org.rstudio.core.client.ElementIds;
import org.rstudio.core.client.StringUtil;
import org.rstudio.core.client.dom.DomUtils;
import org.rstudio.core.client.js.JsObject;
import org.rstudio.core.client.resources.ImageResource2x;
import org.rstudio.core.client.widget.FontSizer;
import org.rstudio.core.client.widget.SelectWidget;
import org.rstudio.studio.client.RStudioGinjector;
import org.rstudio.studio.client.projects.StudioClientProjectConstants;
import org.rstudio.studio.client.projects.model.NewProjectInput;
import org.rstudio.studio.client.quarto.model.QuartoCapabilities;
import org.rstudio.studio.client.quarto.model.QuartoConstants;
import org.rstudio.studio.client.quarto.model.QuartoJupyterKernel;
import org.rstudio.studio.client.quarto.model.QuartoNewProjectOptions;
import org.rstudio.studio.client.quarto.ui.QuartoVisualEditorCheckBox;
import org.rstudio.studio.client.workbench.model.ClientState;
import org.rstudio.studio.client.workbench.model.Session;
import org.rstudio.studio.client.workbench.model.helper.JSObjectStateValue;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

public class NewQuartoProjectPage extends NewDirectoryPage
{
   public NewQuartoProjectPage(String projectType,
                               String title, 
                               String subTitle, 
                               String pageCaption, 
                               ImageResource image,
                               ImageResource largeImage)
   {
      super(title, 
            subTitle,
            pageCaption,
            image,
            largeImage);
      
      RStudioGinjector.INSTANCE.injectMembers(this);
      
      loadAndPersistClientState();
      
      // fixed projectType if requested
      fixedProjectType_ = projectType;
   }
   
   public NewQuartoProjectPage()
   {
      this(null,
           constants_.quartoProjectTitle(),
           constants_.quartoProjectSubTitle(),
           constants_.quartoProjectPageCaption(),
            new ImageResource2x(NewProjectResources.INSTANCE.quartoIcon2x()),
            new ImageResource2x(NewProjectResources.INSTANCE.quartoIconLarge2x()));
   }
   
   @Inject
   private void initialize(Session session)
   {
      session_ = session;
   }
      
   
   @Override
   protected void onAddTopPanelWidgets(HorizontalPanel panel)
   {
      projectTypeSelect_ = new SelectWidget(constants_.typeText(),
            new String[] {constants_.projectTypeDefault(), constants_.projectTypeWebsite(), constants_.projectTypeBook() },
            new String[] {
                  QuartoConstants.PROJECT_DEFAULT,
                  QuartoConstants.PROJECT_WEBSITE,
                  QuartoConstants.PROJECT_BOOK
            },
            false);  
      projectTypeSelect_.getListBox().getElement().addClassName(
         NewProjectResources.INSTANCE.styles().quartoProjectTypeSelect());
      
      panel.add(projectTypeSelect_);
   }
    
 
   @Override
   protected void onAddMiddleWidgets()
   {
      addSpacer();
      addSpacer();
      
      HorizontalPanel panel = new HorizontalPanel();     
      
      engineSelect_ = new SelectWidget(constants_.engineLabel(),
            new String[] {constants_.engineSelectNone(), "Knitr", "Jupyter"},
            new String[] {
              QuartoConstants.ENGINE_MARKDOWN, 
              QuartoConstants.ENGINE_KNITR, 
              QuartoConstants.ENGINE_JUPYTER
            }, false, true, false);
      engineSelect_.getElement().addClassName(
         NewProjectResources.INSTANCE.styles().quartoEngineSelect());
      panel.add(engineSelect_);
      
      
      kernelSelect_ = new SelectWidget(constants_.kernelLabel());
      kernelSelect_.getElement().addClassName(
            NewProjectResources.INSTANCE.styles().quartoEngineSelect());
      panel.add(kernelSelect_);
      
      addWidget(panel);
   
   }
   
   @Override
   protected void onAddBottomWidgets()
   {
      // venv
      venvPanel_ = new HorizontalPanel();
      chkUseVenv_ = new CheckBox(constants_.chkUseVenvLabel());
      ElementIds.assignElementId(chkUseVenv_,
         ElementIds.idWithPrefix(getTitle(), ElementIds.NEW_PROJECT_VENV));
      venvPanel_.add(chkUseVenv_);
      txtVenvPackages_ = new TextBox();
      txtVenvPackages_.getElement().setAttribute(constants_.placeholderLabel(), constants_.txtVenvPackagesNone());
      txtVenvPackages_.addStyleName(NewProjectResources.INSTANCE.styles().quartoVenvPackages());
      DomUtils.disableSpellcheck(txtVenvPackages_);
      FontSizer.applyNormalFontSize(txtVenvPackages_.getElement());
      ElementIds.assignElementId(txtVenvPackages_,
         ElementIds.idWithPrefix(getTitle(), ElementIds.NEW_PROJECT_VENV_PACKAGES));
      venvPanel_.add(txtVenvPackages_);
      addWidget(venvPanel_);
      
      // visual editor
      chkVisualEditor_ = new QuartoVisualEditorCheckBox();
      addSpacer();
      addWidget(chkVisualEditor_);
      
   }
   
   @Override 
   protected void initialize(NewProjectInput input)
   {
      super.initialize(input);
      
      // set type
      if (fixedProjectType_ != null)
      {
         projectTypeSelect_.setValue(fixedProjectType_);
         projectTypeSelect_.setVisible(false);
      }
      else
      {
         projectTypeSelect_.setValue(lastOptions_.getType());
      }
      
      // set engine
      engineSelect_.setValue(lastOptions_.getEngine());
      engineSelect_.addChangeHandler((event) -> {
         manageControls();
      });
      
      // popuplate kernel list from caps
      quartoCaps_ = input.getContext().getQuartoCapabilities();
      JsArray<QuartoJupyterKernel> kernels = quartoCaps_.jupyterKernels();
      
      String[] kernelNames = new String[kernels.length()];
      String[] kernelDisplayNames = new String[kernels.length()];
      for (int i=0; i<kernels.length(); i++)
      {
         QuartoJupyterKernel kernel = kernels.get(i);
         kernelNames[i] = kernel.getName();
         kernelDisplayNames[i] = kernel.getDisplayName();
      }
      kernelSelect_.setChoices(kernelDisplayNames, kernelNames);
      kernelSelect_.setValue(lastOptions_.getKernel());
   
      chkUseVenv_.setValue(canUseVenv() && !StringUtil.isNullOrEmpty(lastOptions_.getVenv()));
      txtVenvPackages_.setValue(lastOptions_.getPackages());
      
      chkVisualEditor_.setValue(lastOptions_.getEditor().equals(QuartoConstants.EDITOR_VISUAL));
      
      manageControls();
      
   }
   
   private void manageControls()
   {
      boolean isKnitr =  engineSelect_.getValue().equals(QuartoConstants.ENGINE_KNITR);
      boolean isJupyter = engineSelect_.getValue().equals(QuartoConstants.ENGINE_JUPYTER);
      kernelSelect_.setVisible(isJupyter);
      venvPanel_.setVisible(isJupyter && canUseVenv());
      setUseRenvVisible(isKnitr);
   }
   
   private boolean canUseVenv()
   {
      return quartoCaps_ != null &&
             quartoCaps_.getPythonCapabilities() != null &&
             quartoCaps_.getPythonCapabilities().getVenv();
   }
   
   
 
   @Override
   protected QuartoNewProjectOptions getNewQuartoProjectOptions()
   {
      lastOptions_ = QuartoNewProjectOptions.create(
            projectTypeSelect_.getValue(), 
            engineSelect_.getValue(), 
            kernelSelect_.getValue(), 
            chkUseVenv_.getValue() ? "venv" : "",
            txtVenvPackages_.getText().trim(),
            chkVisualEditor_.getValue() ? QuartoConstants.EDITOR_VISUAL : ""
      );
      
      return lastOptions_;
   }

   @Override
   protected void onUnload()
   {
      super.onUnload();
      session_.persistClientState();
   }
   
   private String fixedProjectType_;
   private SelectWidget projectTypeSelect_;
   private SelectWidget engineSelect_;
   private SelectWidget kernelSelect_;
   private CheckBox chkUseVenv_;
   private TextBox txtVenvPackages_;
   private HorizontalPanel venvPanel_;
   private QuartoVisualEditorCheckBox chkVisualEditor_;
   private Session session_;
   private QuartoCapabilities quartoCaps_ = null;

   
   private class ClientStateValue extends JSObjectStateValue
   {
      public ClientStateValue()
      {
         super("quarto",
               "quarto-new-proj",
               ClientState.PERSISTENT,
               session_.getSessionInfo().getClientState(),
               false);
      }

      @Override
      protected void onInit(JsObject value)
      {
         lastOptions_ = (value == null) ?
            QuartoNewProjectOptions.createDefault() :
               QuartoNewProjectOptions.create(
                        value.getString(constants_.quartoProjectTypeOption()),
                        value.getString(constants_.quartoProjectEngineOption()),
                        value.getString(constants_.quartoProjectKernelOption()),
                        value.getString("venv"),
                        value.getString("packages"),
                        value.getString("editor")
                  );
      }
 
      @Override
      protected JsObject getValue()
      {
         return lastOptions_.cast();
      }
   }

   private final void loadAndPersistClientState()
   {
      if (clientStateValue_ == null)
         clientStateValue_ = new ClientStateValue();
   }
   private static ClientStateValue clientStateValue_;
   private static QuartoNewProjectOptions lastOptions_ = QuartoNewProjectOptions.createDefault();
   private static final StudioClientProjectConstants constants_ = GWT.create(StudioClientProjectConstants.class);

}
