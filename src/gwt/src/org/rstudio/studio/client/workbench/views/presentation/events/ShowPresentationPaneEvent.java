/*
 * ShowPresentationPaneEvent.java
 *
 * Copyright (C) 2020 by RStudio, PBC
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
package org.rstudio.studio.client.workbench.views.presentation.events;

import org.rstudio.studio.client.workbench.views.presentation.model.PresentationState;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ShowPresentationPaneEvent extends GwtEvent<ShowPresentationPaneEvent.Handler>
{
   public interface Handler extends EventHandler
   {
      void onShowPresentationPane(ShowPresentationPaneEvent event);
   }

   public ShowPresentationPaneEvent(PresentationState presentationState)
   {
      presentationState_ = presentationState;
   }

   public PresentationState getPresentationState()
   {
      return presentationState_;
   }

   @Override
   public Type<Handler> getAssociatedType()
   {
      return TYPE;
   }

   @Override
   protected void dispatch(Handler handler)
   {
      handler.onShowPresentationPane(this);
   }

   private final PresentationState presentationState_;

   public static final Type<Handler> TYPE = new Type<>();
}
