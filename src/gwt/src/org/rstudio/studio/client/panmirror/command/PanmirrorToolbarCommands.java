/*
 * PanmirrorToolbarCommands.java
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

package org.rstudio.studio.client.panmirror.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.GWT;
import org.rstudio.core.client.Debug;
import org.rstudio.core.client.StringUtil;
import org.rstudio.studio.client.palette.model.CommandPaletteEntryProvider;
import org.rstudio.studio.client.palette.model.CommandPaletteItem;

import com.google.gwt.aria.client.MenuitemRole;
import com.google.gwt.aria.client.Roles;
import org.rstudio.studio.client.palette.ui.CommandPalette;
import org.rstudio.studio.client.panmirror.PanmirrorConstants;

public class PanmirrorToolbarCommands implements CommandPaletteEntryProvider
{ 
   public PanmirrorToolbarCommands(PanmirrorCommand[] commands)
   {
      PanmirrorCommandIcons icons = PanmirrorCommandIcons.INSTANCE;

      // init commands
      commands_ = commands;
      
      // text editing
      add(PanmirrorCommands.Undo, _constants.undoMenuText());
      add(PanmirrorCommands.Redo, _constants.redoMenuText());
      add(PanmirrorCommands.SelectAll, _constants.selectAllMenuText());
      
      // formatting
      add(PanmirrorCommands.Strong, _constants.boldMenuText(), icons.BOLD);
      add(PanmirrorCommands.Em, _constants.italicMenuText(), icons.ITALIC);
      add(PanmirrorCommands.Code, _constants.codeMenuText(), icons.CODE);
      add(PanmirrorCommands.Strikeout, _constants.strikeoutMenuText());
      add(PanmirrorCommands.Superscript, _constants.superscriptMenuText());
      add(PanmirrorCommands.Subscript, _constants.subscriptMenuText());
      add(PanmirrorCommands.Smallcaps, _constants.smallCapsMenuText());
      add(PanmirrorCommands.Underline, _constants.underlineMenuText(), icons.UNDERLINE);
      add(PanmirrorCommands.Span, _constants.spanMenuText());
      add(PanmirrorCommands.Paragraph, _constants.normalMenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.Heading1, _constants.heading1MenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.Heading2, _constants.heading2MenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.Heading3, _constants.heading3MenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.Heading4, _constants.heading4MenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.Heading5, _constants.heading5MenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.Heading6, _constants.heading6MenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.CodeBlock, _constants.codeBlockMenuText(), Roles.getMenuitemradioRole());
      add(PanmirrorCommands.CodeBlockFormat, _constants.codeBlockFormatMenuText());
      
      add(PanmirrorCommands.Blockquote, _constants.blockquoteMenuText(), Roles.getMenuitemcheckboxRole(), icons.BLOCKQUOTE);
      add(PanmirrorCommands.LineBlock, _constants.linkBlockMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.Div, _constants.divMenuText());
      add(PanmirrorCommands.AttrEdit, _constants.editAttributesMenuText());
      add(PanmirrorCommands.ClearFormatting, _constants.clearFormattingMenuText(), icons.CLEAR_FORMATTING);
      
      // raw
      add(PanmirrorCommands.TexInline, _constants.texInlineMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.TexBlock, _constants.texBlockMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.HTMLInline, _constants.htmlInlineMenuText());
      add(PanmirrorCommands.HTMLBlock, _constants.htmlBlockMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.RawInline, _constants.rawInlineMenuText());
      add(PanmirrorCommands.RawBlock, _constants.rawBlockMenuText());
      
      // chunk
      add(PanmirrorCommands.RCodeChunk, "R");
      add(PanmirrorCommands.BashCodeChunk, "Bash");
      add(PanmirrorCommands.D3CodeChunk, "D3");
      add(PanmirrorCommands.PythonCodeChunk, "Python");
      add(PanmirrorCommands.RcppCodeChunk, "Rcpp");
      add(PanmirrorCommands.SQLCodeChunk, "SQL");
      add(PanmirrorCommands.StanCodeChunk, "Stan");
      add(PanmirrorCommands.ExpandChunk, _constants.expandChunkMenuText(), false);
      add(PanmirrorCommands.CollapseChunk, _constants.collapseChunkMenuText(), false);
      add(PanmirrorCommands.ExpandAllChunks, _constants.expandAllChunksMenuText(), false);
      add(PanmirrorCommands.CollapseAllChunks, _constants.collapseAllChunksMenuText(), false);

      // lists
      add(PanmirrorCommands.BulletList, _constants.bulletedListMenuText(), Roles.getMenuitemcheckboxRole(), icons.BULLET_LIST);
      add(PanmirrorCommands.OrderedList, _constants.numberedListMenuText(), Roles.getMenuitemcheckboxRole(), icons.NUMBERED_LIST);
      add(PanmirrorCommands.TightList, _constants.tightListMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.ListItemSink, _constants.sinkItemMenuText());
      add(PanmirrorCommands.ListItemLift, _constants.liftItemMenuText());
      add(PanmirrorCommands.ListItemCheck, _constants.itemCheckboxMenuText());
      add(PanmirrorCommands.ListItemCheckToggle, _constants.itemCheckedMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.EditListProperties, _constants.listAttributesMenuText());
      
      // tables
      add(PanmirrorCommands.TableInsertTable, _constants.insertTableMenuText(), icons.TABLE);
      add(PanmirrorCommands.TableToggleHeader, _constants.tableHeaderMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.TableToggleCaption, _constants.tableCaptionMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.TableAddColumnAfter, _constants.tableInsertColumnRightMenuText(), _constants.tableInsertColumnRightPluralMenuText(), null);
      add(PanmirrorCommands.TableAddColumnBefore, _constants.tableInsertColumnLeftMenuText(), _constants.tableInsertColumnLeftPluralMenuText(), null);
      add(PanmirrorCommands.TableDeleteColumn, _constants.tableDeleteColumnMenuText(), _constants.tableDeleteColumnPluralMenuText(), null);
      add(PanmirrorCommands.TableAddRowAfter, _constants.tableInsertRowBelowMenuText(), _constants.tableInsertRowBelowPluralMenuText(), null);
      add(PanmirrorCommands.TableAddRowBefore, _constants.tableInsertRowAboveMenuText(), _constants.tableInsertRowAbovePluralMenuText(), null);
      add(PanmirrorCommands.TableDeleteRow, _constants.tableDeleteRowMenuText(), _constants.tableDeleteRowPluralMenuText(), null);
      add(PanmirrorCommands.TableDeleteTable, _constants.deleteTableMenuText());
      add(PanmirrorCommands.TableNextCell, _constants.tableNextCellMenuText());
      add(PanmirrorCommands.TablePreviousCell, _constants.tablePreviousCellMenuText());
      add(PanmirrorCommands.TableAlignColumnLeft, _constants.tableAlignColumnLeftMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.TableAlignColumnRight, _constants.tableAlignColumnRightMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.TableAlignColumnCenter, _constants.tableAlignColumnCenterMenuText(), Roles.getMenuitemcheckboxRole());
      add(PanmirrorCommands.TableAlignColumnDefault, _constants.tableAlignColumnDefaultMenuText(), Roles.getMenuitemcheckboxRole());
     
      // insert
      add(PanmirrorCommands.OmniInsert, _constants.anyMenuText(), icons.OMNI);
      add(PanmirrorCommands.Table, _constants.tableMenuText(), icons.TABLE);
      add(PanmirrorCommands.Link, _constants.linkMenuText(), icons.LINK);
      add(PanmirrorCommands.RemoveLink, _constants.removeLinkMenuText());
      add(PanmirrorCommands.Image, _constants.figureImageMenuText(), icons.IMAGE);
      add(PanmirrorCommands.Footnote, _constants.footnoteMenuText());
      add(PanmirrorCommands.HorizontalRule, _constants.horizontalRuleMenuText());
      add(PanmirrorCommands.ParagraphInsert, _constants.paragraphMenuText());
      add(PanmirrorCommands.HTMLComment, _constants.paragraphMenuText(), icons.COMMENT);
      add(PanmirrorCommands.YamlMetadata, _constants.yamlBlockMenuText());
      add(PanmirrorCommands.Shortcode, _constants.shortcodeMenuText());
      add(PanmirrorCommands.InsertDiv, _constants.divMenuText());
      add(PanmirrorCommands.InlineMath, _constants.inlineMathMenuText());
      add(PanmirrorCommands.DisplayMath, _constants.displayMathMenuText());
      add(PanmirrorCommands.DefinitionList, _constants.definitionListMenuText());
      add(PanmirrorCommands.DefinitionTerm, _constants.termMenuText());
      add(PanmirrorCommands.DefinitionDescription, _constants.descriptionMenuText());
      add(PanmirrorCommands.Citation, _constants.citationMenuText(), icons.CITATION);
      add(PanmirrorCommands.CrossReference, _constants.crossReferenceMenuText());
      add(PanmirrorCommands.InsertEmoji, _constants.insertEmojiMenuText());
      add(PanmirrorCommands.InsertSymbol, _constants.insertUnicodeMenuText());
      add(PanmirrorCommands.EmDash, _constants.insertEmDashMenuText());
      add(PanmirrorCommands.EnDash, _constants.insertEnDashMenuText());
      add(PanmirrorCommands.NonBreakingSpace, _constants.insertNonBreakingSpaceMenuText());
      add(PanmirrorCommands.HardLineBreak, _constants.insertHardLinkBreakMenuText());
      add(PanmirrorCommands.Tabset, _constants.insertTabsetMenuText());
      add(PanmirrorCommands.Callout, _constants.insertCalloutMenuText());
      
      // outline
      add(PanmirrorCommands.GoToNextSection, _constants.goToNextSectionMenuText());
      add(PanmirrorCommands.GoToPreviousSection, _constants.goToPreviousSectionMenuText());
      add(PanmirrorCommands.GoToNextChunk, _constants.goToNextChunkMenuText());
      add(PanmirrorCommands.GoToPreviousChunk, _constants.goToPreviousSectionMenuText());
      
      // slides
      add(PanmirrorCommands.InsertSlidePause, _constants.insertSlidePauseMenuText());
      add(PanmirrorCommands.InsertSlideNotes, _constants.insertSlideNotesMenuText());
      add(PanmirrorCommands.InsertSlideColumns, _constants.insertSlideColumnsMenuText());
   }
   
   public PanmirrorCommandUI get(String id)
   {
      return commandsUI_.get(id);
   }
   
   public boolean exec(String id)
   {
      PanmirrorCommandUI command = get(id);
      if (command != null)
      {
         if (command.isEnabled())
         {
            command.execute();
         }
         return true;
      }
      else
      {
         return false;
      }
   }
   
   @Override
   public List<CommandPaletteItem> getCommandPaletteItems()
   {
      List<CommandPaletteItem> items = new ArrayList<>();
      for (PanmirrorCommandUI cmd: commandsUI_.values())
      {
         if (cmd != null && cmd.isVisible() && cmd.getCommandPallette())
         {
            items.add(new PanmirrorCommandPaletteItem(cmd));
         }
      }
      return items;
   }

   @Override
   public CommandPaletteItem getCommandPaletteItem(String id)
   {
      if (StringUtil.isNullOrEmpty(id))
      {
         return null;
      }

      PanmirrorCommandUI cmd = commandsUI_.get(id);
      if (cmd == null)
      {
         Debug.logWarning("Command palette requested unknown command from visual editor: '" + id + "'");
      }

      return new PanmirrorCommandPaletteItem(cmd);
   }

   @Override
   public String getProviderScope()
   {
      return CommandPalette.SCOPE_VISUAL_EDITOR;
   }

   private void add(String id, String menuText)
   {
      add(id, menuText, Roles.getMenuitemRole());
   }
   
   private void add(String id, String menuText, boolean commandPallette)
   {
      add(id, menuText, null, Roles.getMenuitemRole(), null, commandPallette);
   }
   
   private void add(String id, String menuText, String pluralMenuText, String image)
   {
      add(id, menuText, pluralMenuText, Roles.getMenuitemRole(), image, true);
   }
   
   private void add(String id, String menuText, String image)
   {
      add(id, menuText, Roles.getMenuitemRole(), image);
   }
   
   
   private void add(String id, String menuText, MenuitemRole role)
   {
      add(id, menuText, role, null);
   }
   
   private void add(String id, String menuText, MenuitemRole role, String image)
   {
      add(id, menuText, null, role, image, true);
   }
   
   private void add(String id, String menuText, String pluralMenuText, MenuitemRole role, String image, boolean commandPallette)
   {
      // lookup the underlying command
      PanmirrorCommand command = null;
      for (PanmirrorCommand cmd : commands_) {
         if (cmd.id == id) {
            command = cmd;
            break;
         }
      }
      // add it
      commandsUI_.put(id, new PanmirrorCommandUI(command, menuText, pluralMenuText, role, image, commandPallette));
   }
   
   private PanmirrorCommand[] commands_ = null;
   private final HashMap<String,PanmirrorCommandUI> commandsUI_ = new HashMap<>();
   private static final PanmirrorConstants _constants = GWT.create(PanmirrorConstants.class);
}
