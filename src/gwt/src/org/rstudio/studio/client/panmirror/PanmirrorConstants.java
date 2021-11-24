/*
 * PanmirrorConstants.java
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
package org.rstudio.studio.client.panmirror;

public interface PanmirrorConstants extends com.google.gwt.i18n.client.Messages {

    /**
     * Translated "Visual Editor".
     *
     * @return translated "Visual Editor"
     */
    @DefaultMessage("Visual Editor") //NON-NLS
    @Key("visualEditorText")
    String visualEditorText();

    /**
     * Translated "visual editor ".
     *
     * @return translated "visual editor {0}"
     */
    @DefaultMessage("visual editor {0} ") //NON-NLS
    @Key("visualEditorLabel")
    String visualEditorLabel(String menuText);

    /**
     * Translated "Panmirror Editor Toolbar".
     *
     * @return translated "Panmirror Editor Toolbar"
     */
    @DefaultMessage("Panmirror Editor Toolbar") //NON-NLS
    @Key("panMirrorToolbarLabel")
    String panMirrorToolbarLabel();

    /**
     * Translated "Format".
     *
     * @return translated "Format"
     */
    @DefaultMessage("Format") //NON-NLS
    @Key("formatTitle")
    String formatTitle();

    /**
     * Translated "Insert".
     *
     * @return translated "Insert"
     */
    @DefaultMessage("Insert") //NON-NLS
    @Key("insertTitle")
    String insertTitle();

    /**
     * Translated "Reference".
     *
     * @return translated "Reference"
     */
    @DefaultMessage("Reference") //NON-NLS
    @Key("referenceTitle")
    String referenceTitle();

    /**
     * Translated "Table".
     *
     * @return translated "Table"
     */ //NON-NLS
    @DefaultMessage("Table")
    @Key("tableTitle")
    String tableTitle();

    /**
     * Translated "Find/Replace".
     *
     * @return translated "Find/Replace" //NON-NLS
     */
    @DefaultMessage("Find/Replace")
    @Key("findReplaceTitle")
    String findReplaceTitle();

    /**
     * Translated "Format".
     *
     * @return translated "Format" //NON-NLS
     */
    @DefaultMessage("Format")
    @Key("formatText")
    String formatText();

    /**
     * Translated "Reference".
     *
     * @return translated "Reference" //NON-NLS
     */
    @DefaultMessage("Reference")
    @Key("referenceText")
    String referenceText();

    /**
     * Translated "Insert".
     *
     * @return translated "Insert"
     */
    @DefaultMessage("Insert") //NON-NLS
    @Key("insertText")
    String insertText();

    /**
     * Translated "Table". //NON-NLS
     *
     * @return translated "Table"
     */
    @DefaultMessage("Table")
    @Key("tableText")
    String tableText();


    /**
     * Translated "Normal".
     *
     * @return translated "Normal" //NON-NLS
     */
    @DefaultMessage("Normal")
    @Key("panmirrorBlockMenuDefaultText")
    String panmirrorBlockMenuDefaultText();

    /**
     * Translated "Block Format".
     *
     * @return translated "Block Format"
     */
    @DefaultMessage("Block Format") //NON-NLS
    @Key("panMirrorBlockMenuTitle")
    String panMirrorBlockMenuTitle();

    /**
     * Translated "Undo".
     *
     * @return translated "Undo" //NON-NLS
     */
    @DefaultMessage("Undo")
    @Key("undoMenuText")
    String undoMenuText();

    /**
     * Translated "Redo".
     *
     * @return translated "Redo" //NON-NLS
     */
    @DefaultMessage("Redo")
    @Key("redoMenuText")
    String redoMenuText(); //NON-NLS

    /**
     * Translated "Select All".
     *
     * @return translated "Select All"
     */
    @DefaultMessage("Select All")
    @Key("selectAllMenuText")
    String selectAllMenuText();

    /**
     * Translated "Bold". //NON-NLS
     *
     * @return translated "Bold"
     */
    @DefaultMessage("Bold")
    @Key("boldMenuText")
    String boldMenuText(); //NON-NLS

    /**
     * Translated "Italic".
     *
     * @return translated "Italic"
     */
    @DefaultMessage("Italic") //NON-NLS
    @Key("italicMenuText")
    String italicMenuText();

    /**
     * Translated "Code".
     *
     * @return translated "Code"
     */
    @DefaultMessage("Code")
    @Key("codeMenuText")
    String codeMenuText();

    /**
     * Translated "Strikeout".
     *
     * @return translated "Strikeout"
     */
    @DefaultMessage("Strikeout") //NON-NLS
    @Key("strikeoutMenuText") //NON-NLS
    String strikeoutMenuText();

    /**
     * Translated "Superscript".
     *
     * @return translated "Superscript"
     */
    @DefaultMessage("Superscript")
    @Key("superscriptMenuText")
    String superscriptMenuText();

    /**
     * Translated "Subscript". //NON-NLS
     *
     * @return translated "Subscript"
     */
    @DefaultMessage("Subscript")
    @Key("subscriptMenuText")
    String subscriptMenuText();

    /** //NON-NLS
     * Translated "Small Caps".
     *
     * @return translated "Small Caps"
     */
    @DefaultMessage("Small Caps")
    @Key("smallCapsMenuText")
    String smallCapsMenuText(); //NON-NLS

    /**
     * Translated "Underline".
     *
     * @return translated "Underline"
     */
    @DefaultMessage("Underline")
    @Key("underlineMenuText")
    String underlineMenuText();

    /**
     * Translated "Span...".
     *
     * @return translated "Span..." //NON-NLS
     */
    @DefaultMessage("Span...")
    @Key("spanMenuText")
    String spanMenuText(); //NON-NLS

    /**
     * Translated "Normal".
     *
     * @return translated "Normal"
     */
    @DefaultMessage("Normal")
    @Key("normalMenuText")
    String normalMenuText();

    /**
     * Translated "Heading 1".
     *
     * @return translated "Heading 1" //NON-NLS
     */
    @DefaultMessage("Heading 1") //NON-NLS
    @Key("heading1MenuText")
    String heading1MenuText();

    /**
     * Translated "Heading 2".
     *
     * @return translated "Heading 2"
     */
    @DefaultMessage("Heading 2")
    @Key("heading2MenuText")
    String heading2MenuText(); //NON-NLS

    /**
     * Translated "Heading 3".
     *
     * @return translated "Heading 3"
     */
    @DefaultMessage("Heading 3")
    @Key("heading3MenuText")
    String heading3MenuText(); //NON-NLS

    /**
     * Translated "Heading 4".
     *
     * @return translated "Heading 4"
     */
    @DefaultMessage("Heading 4")
    @Key("heading4MenuText")
    String heading4MenuText(); //NON-NLS

    /**
     * Translated "Heading 5".
     *
     * @return translated "Heading 5"
     */
    @DefaultMessage("Heading 5")
    @Key("heading5MenuText")
    String heading5MenuText();

    /**
     * Translated "Heading 6".
     *
     * @return translated "Heading 6" //NON-NLS
     */
    @DefaultMessage("Heading 6")
    @Key("heading6MenuText")
    String heading6MenuText();

    /**
     * Translated "Code Block".
     *
     * @return translated "Code Block"
     */
    @DefaultMessage("Code Block") //NON-NLS
    @Key("codeBlockMenuText")
    String codeBlockMenuText();

    /**
     * Translated "Code Block...".
     *
     * @return translated "Code Block..."
     */
    @DefaultMessage("Code Block...") //NON-NLS
    @Key("codeBlockFormatMenuText") //NON-NLS
    String codeBlockFormatMenuText();

    /**
     * Translated "Blockquote".
     *
     * @return translated "Blockquote"
     */
    @DefaultMessage("Blockquote")
    @Key("blockquoteMenuText")
    String blockquoteMenuText();

    /**
     * Translated "Line Block".
     *
     * @return translated "Line Block"
     */
    @DefaultMessage("Line Block") //NON-NLS
    @Key("linkBlockMenuText")
    String linkBlockMenuText();

    /**
     * Translated "Line Block".
     *
     * @return translated "Line Block" //NON-NLS
     */
    @DefaultMessage("Div...")
    @Key("divMenuText")
    String divMenuText();

    /**
     * Translated "Edit Attributes...".
     *
     * @return translated "Edit Attributes..."
     */
    @DefaultMessage("Edit Attributes...")
    @Key("editAttributesMenuText") //NON-NLS
    String editAttributesMenuText();

    /**
     * Translated "Clear Formatting".
     *
     * @return translated "Clear Formatting"
     */
    @DefaultMessage("Clear Formatting")
    @Key("clearFormattingMenuText")
    String clearFormattingMenuText();


    /**
     * Translated "TeX Inline". //NON-NLS
     *
     * @return translated "TeX Inline"
     */
    @DefaultMessage("TeX Inline") //NON-NLS
    @Key("texInlineMenuText")
    String texInlineMenuText();


    /** //NON-NLS
     * Translated "TeX Block".
     *
     * @return translated "TeX Block"
     */
    @DefaultMessage("TeX Block")
    @Key("texBlockMenuText")
    String texBlockMenuText(); //NON-NLS

    /**
     * Translated "HTML Inline...".
     *
     * @return translated "HTML Inline..."
     */
    @DefaultMessage("HTML Inline...")
    @Key("htmlInlineMenuText")
    String htmlInlineMenuText(); //NON-NLS

    /**
     * Translated "HTML Block".
     *
     * @return translated "HTML Block"
     */
    @DefaultMessage("HTML Block")
    @Key("htmlBlockMenuText")
    String htmlBlockMenuText();

    /**
     * Translated "Raw Inline...".
     *
     * @return translated "Raw Inline..." //NON-NLS
     */
    @DefaultMessage("Raw Inline...")
    @Key("rawInlineMenuText")
    String rawInlineMenuText();

    /**
     * Translated "Raw Block...". //NON-NLS
     *
     * @return translated "Raw Block..."
     */
    @DefaultMessage("Raw Block...")
    @Key("rawBlockMenuText")
    String rawBlockMenuText();

    /**
     * Translated "Expand Chunk".
     *
     * @return translated "Expand Chunk"
     */
    @DefaultMessage("Expand Chunk")
    @Key("expandChunkMenuText")
    String expandChunkMenuText();

    /**
     * Translated "Collapse Chunk".
     *
     * @return translated "Collapse Chunk" //NON-NLS
     */
    @DefaultMessage("Collapse Chunk") //NON-NLS
    @Key("collapseChunkMenuText")
    String collapseChunkMenuText(); //NON-NLS

    /**
     * Translated "Expand All Chunks".
     *
     * @return translated "Expand All Chunks"
     */
    @DefaultMessage("Expand All Chunks")
    @Key("expandAllChunksMenuText")
    String expandAllChunksMenuText();
 //NON-NLS
    /**
     * Translated "Collapse All Chunks".
     *
     * @return translated "Collapse All Chunks"
     */
    @DefaultMessage("Collapse All Chunks")
    @Key("collapseAllChunksMenuText")
    String collapseAllChunksMenuText();

    /**
     * Translated "Bulleted List".
     *
     * @return translated "Bulleted List"
     */
    @DefaultMessage("Bulleted List") //NON-NLS
    @Key("bulletedListMenuText")
    String bulletedListMenuText();

    /**
     * Translated "Numbered List". //NON-NLS
     *
     * @return translated "Numbered List"
     */
    @DefaultMessage("Numbered List")
    @Key("numberedListMenuText")
    String numberedListMenuText();

    /** //NON-NLS
     * Translated "Tight List".
     *
     * @return translated "Tight List"
     */ //NON-NLS
    @DefaultMessage("Tight List")
    @Key("tightListMenuText")
    String tightListMenuText();

    /**
     * Translated "Sink Item".
     *
     * @return translated "Sink Item"
     */
    @DefaultMessage("Sink Item")
    @Key("sinkItemMenuText")
    String sinkItemMenuText();

    /**
     * Translated "Lift Item". //NON-NLS
     *
     * @return translated "Lift Item"
     */
    @DefaultMessage("Lift Item")
    @Key("liftItemMenuText")
    String liftItemMenuText();

    /**
     * Translated "Item Checkbox".
     *
     * @return translated "Item Checkbox" //NON-NLS
     */
    @DefaultMessage("Item Checkbox")
    @Key("itemCheckboxMenuText") //NON-NLS
    String itemCheckboxMenuText();

    /**
     * Translated "Item Checked".
     *
     * @return translated "Item Checked"
     */
    @DefaultMessage("Item Checked")
    @Key("itemCheckedMenuText")
    String itemCheckedMenuText();

    /**
     * Translated "List Attributes...".
     *
     * @return translated "List Attributes..."
     */
    @DefaultMessage("List Attributes...")
    @Key("listAttributesMenuText")
    String listAttributesMenuText();

    /**
     * Translated "Insert Table...". //NON-NLS
     *
     * @return translated "Insert Table..."
     */
    @DefaultMessage("Insert Table...") //NON-NLS
    @Key("insertTableMenuText")
    String insertTableMenuText(); //NON-NLS

    /**
     * Translated "Table Header".
     *
     * @return translated "Table Header"
     */
    @DefaultMessage("Table Header")
    @Key("tableHeaderMenuText")
    String tableHeaderMenuText();

    /**
     * Translated "Table Caption".
     *
     * @return translated "Table Caption"
     */
    @DefaultMessage("Table Caption")
    @Key("tableCaptionMenuText")
    String tableCaptionMenuText();


    /**
     * Translated "Table:::Insert Column Right". //NON-NLS
     *
     * @return translated "Table:::Insert Column Right"
     */
    @DefaultMessage("Table:::Insert Column Right")
    @Key("tableInsertColumnRightMenuText")
    String tableInsertColumnRightMenuText();

    /**
     * Translated "Insert %d Columns Right".
     *
     * @return translated "Insert %d Columns Right"
     */
    @DefaultMessage("Insert %d Columns Right") //NON-NLS
    @Key("tableInsertColumnRightPluralMenuText")
    String tableInsertColumnRightPluralMenuText();

    /**
     * Translated "Table:::Insert Column Left".
     *
     * @return translated "Table:::Insert Column Left" //NON-NLS
     */
    @DefaultMessage("Table:::Insert Column Left") //NON-NLS
    @Key("tableInsertColumnLeftMenuText")
    String tableInsertColumnLeftMenuText();

    /**
     * Translated "Insert %d Columns Left".
     *
     * @return translated "Insert %d Columns Left"
     */
    @DefaultMessage("Insert %d Columns Left") //NON-NLS
    @Key("tableInsertColumnLeftPluralMenuText")
    String tableInsertColumnLeftPluralMenuText();

    /**
     * Translated "Table:::Delete Column".
     *
     * @return translated "Table:::Delete Column"
     */
    @DefaultMessage("Table:::Delete Column")
    @Key("tableDeleteColumnMenuText")
    String tableDeleteColumnMenuText(); //NON-NLS

    /**
     * Translated "Table:::Delete %d Columns".
     *
     * @return translated "Table:::Delete %d Columns" //NON-NLS
     */
    @DefaultMessage("Table:::Delete %d Columns")
    @Key("tableDeleteColumnPluralMenuText")
    String tableDeleteColumnPluralMenuText(); //NON-NLS

    /**
     * Translated "Table:::Insert Row Below".
     *
     * @return translated "Table:::Insert Row Below"
     */ //NON-NLS
    @DefaultMessage("Table:::Insert Row Below")
    @Key("tableInsertRowBelowMenuText")
    String tableInsertRowBelowMenuText();

    /**
     * Translated "Table:::Insert %d Rows Below".
     *
     * @return translated "Table:::Insert %d Rows Below" //NON-NLS
     */
    @DefaultMessage("Table:::Insert %d Rows Below")
    @Key("tableInsertRowBelowPluralMenuText")
    String tableInsertRowBelowPluralMenuText();

    /**
     * Translated "Table:::Insert Row Above".
     *
     * @return translated "Table:::Insert Row Above" //NON-NLS
     */
    @DefaultMessage("Table:::Insert Row Above")
    @Key("tableInsertRowAboveMenuText")
    String tableInsertRowAboveMenuText();

    /**
     * Translated "Table:::Insert %d Rows Above".
     *
     * @return translated "Table:::Insert %d Rows Above"
     */
    @DefaultMessage("Table:::Insert %d Rows Above")
    @Key("tableInsertRowAbovePluralMenuText")
    String tableInsertRowAbovePluralMenuText(); //NON-NLS

    /**
     * Translated "Table:::Insert %d Rows Above".
     *
     * @return translated "Table:::Delete Row" //NON-NLS
     */
    @DefaultMessage("Table:::Delete Row")
    @Key("tableDeleteRowMenuText")
    String tableDeleteRowMenuText();

    /**
     * Translated "Delete %d Rows". //NON-NLS
     *
     * @return translated "Delete %d Rows"
     */
    @DefaultMessage("Delete %d Rows")
    @Key("tableDeleteRowPluralMenuText")
    String tableDeleteRowPluralMenuText();

    /**
     * Translated "Delete Table".
     *
     * @return translated "Delete Table"
     */ //NON-NLS
    @DefaultMessage("Delete Table")
    @Key("deleteTableMenuText")
    String deleteTableMenuText(); //NON-NLS

    /**
     * Translated "Table:::Next Cell".
     *
     * @return translated "Table:::Next Cell"
     */
    @DefaultMessage("Table:::Next Cell")
    @Key("tableNextCellMenuText")
    String tableNextCellMenuText();

    /**
     * Translated "Table:::Previous Cell".
     *
     * @return translated "Table:::Previous Cell"
     */
    @DefaultMessage("Table:::Previous Cell")
    @Key("tablePreviousCellMenuText") //NON-NLS
    String tablePreviousCellMenuText();

    /**
     * Translated "Table Align Column:::Left".
     *
     * @return translated "Table Align Column:::Left"
     */
    @DefaultMessage("Table Align Column:::Left")
    @Key("tableAlignColumnLeftMenuText")
    String tableAlignColumnLeftMenuText();

    /**
     * Translated "Table Align Column:::Right". //NON-NLS
     *
     * @return translated "Table Align Column:::Right" //NON-NLS
     */
    @DefaultMessage("Table Align Column:::Right")
    @Key("tableAlignColumnRightMenuText")
    String tableAlignColumnRightMenuText();

    /**
     * Translated "Table Align Column:::Center".
     *
     * @return translated "Table Align Column:::Center"
     */
    @DefaultMessage("Table Align Column:::Center")
    @Key("tableAlignColumnCenterMenuText")
    String tableAlignColumnCenterMenuText();

    /**
     * Translated "Table Align Column:::Default".
     *
     * @return translated "Table Align Column:::Default"
     */
    @DefaultMessage("Table Align Column:::Default") //NON-NLS
    @Key("tableAlignColumnDefaultMenuText")
    String tableAlignColumnDefaultMenuText();

    /**
     * Translated "Any...".
     *
     * @return translated "Any..." //NON-NLS
     */
    @DefaultMessage("Any...")
    @Key("anyMenuText")
    String anyMenuText();

    /**
     * Translated "Table...". //NON-NLS
     *
     * @return translated "Table..."
     */
    @DefaultMessage("Table...")
    @Key("tableMenuText")
    String tableMenuText(); //NON-NLS

    /**
     * Translated "Table...".
     *
     * @return translated "Link..."
     */
    @DefaultMessage("Link...")
    @Key("linkMenuText")
    String linkMenuText();

    /**
     * Translated "Remove Link".
     *
     * @return translated "Remove Link"
     */
    @DefaultMessage("Remove Link") //NON-NLS
    @Key("removeLinkMenuText")
    String removeLinkMenuText(); //NON-NLS //NON-NLS

    /**
     * Translated "Figure / Image...".
     *
     * @return translated "Figure / Image..." //NON-NLS
     */
    @DefaultMessage("Figure / Image...")
    @Key("figureImageMenuText")
    String figureImageMenuText();

    /**
     * Translated "Footnote".
     *
     * @return translated "Footnote"
     */
    @DefaultMessage("Footnote")
    @Key("footnoteMenuText")
    String footnoteMenuText();

    /**
     * Translated "Horizontal Rule".
     *
     * @return translated "Horizontal Rule" //NON-NLS
     */
    @DefaultMessage("Horizontal Rule")
    @Key("horizontalRuleMenuText") //NON-NLS
    String horizontalRuleMenuText();

    /**
     * Translated "Paragraph". //NON-NLS
     *
     * @return translated "Paragraph"
     */
    @DefaultMessage("Paragraph")
    @Key("paragraphMenuText")
    String paragraphMenuText();

    /**
     * Translated "Comment".
     *
     * @return translated "Comment"
     */
    @DefaultMessage("Comment")
    @Key("commentMenuText")
    String commentMenuText();

    /**
     * Translated "YAML Block".
     *
     * @return translated "YAML Block"
     */
    @DefaultMessage("YAML Block")
    @Key("yamlBlockMenuText") //NON-NLS
    String yamlBlockMenuText();
 //NON-NLS
    /**
     * Translated "Shortcode". //NON-NLS
     *
     * @return translated "Shortcode"
     */
    @DefaultMessage("Shortcode")
    @Key("shortcodeMenuText")
    String shortcodeMenuText();

    /**
     * Translated "Inline Math".
     *
     * @return translated "Inline Math" //NON-NLS
     */
    @DefaultMessage("Inline Math")
    @Key("inlineMathMenuText")
    String inlineMathMenuText();

    /**
     * Translated "Display Math".
     *
     * @return translated "Display Math"
     */
    @DefaultMessage("Display Math")
    @Key("displayMathMenuText")
    String displayMathMenuText();

    /**
     * Translated "Definition List".
     *
     * @return translated "Definition List" //NON-NLS
     */
    @DefaultMessage("Definition List")
    @Key("definitionListMenuText")
    String definitionListMenuText(); //NON-NLS

    /**
     * Translated "Term".
     *
     * @return translated "Term"
     */
    @DefaultMessage("Term")
    @Key("termMenuText")
    String termMenuText();

    /**
     * Translated "Description". //NON-NLS
     *
     * @return translated "Description" //NON-NLS
     */
    @DefaultMessage("Description")
    @Key("descriptionMenuText")
    String descriptionMenuText();

    /**
     * Translated "Citation...".
     *
     * @return translated "Citation..."
     */
    @DefaultMessage("Citation...")
    @Key("citationMenuText")
    String citationMenuText();

    /**
     * Translated "Cross Reference".
     *
     * @return translated "Cross Reference"
     */
    @DefaultMessage("Cross Reference")
    @Key("crossReferenceMenuText")
    String crossReferenceMenuText();

    /**
     * Translated "Insert Emoji...".
     *
     * @return translated "Insert Emoji..."
     */ //NON-NLS
    @DefaultMessage("Insert Emoji...")
    @Key("insertEmojiMenuText")
    String insertEmojiMenuText(); //NON-NLS

    /**
     * Translated "Insert Unicode...".
     *
     * @return translated "Insert Unicode..."
     */
    @DefaultMessage("Insert Unicode...")
    @Key("insertUnicodeMenuText")
    String insertUnicodeMenuText();

    /**
     * Translated "Insert:::Em Dash (—)".
     *
     * @return translated "Insert:::Em Dash (—)"
     */
    @DefaultMessage("Insert:::Em Dash (—)")
    @Key("insertEmDashMenuText") //NON-NLS
    String insertEmDashMenuText();

    /**
     * Translated "Insert:::En Dash (–)".
     *
     * @return translated "Insert:::En Dash (–)"
     */
    @DefaultMessage("Insert:::En Dash (–)")
    @Key("insertEnDashMenuText") //NON-NLS
    String insertEnDashMenuText();

    /**
     * Translated "Insert:::Non-Breaking Space".
     *
     * @return translated "Insert:::Non-Breaking Space" //NON-NLS
     */
    @DefaultMessage("Insert:::Non-Breaking Space")
    @Key("insertNonBreakingSpaceMenuText")
    String insertNonBreakingSpaceMenuText();

    /**
     * Translated "Insert:::Hard Line Break".
     *
     * @return translated "Insert:::Hard Line Break" //NON-NLS
     */
    @DefaultMessage("Insert:::Hard Line Break")
    @Key("insertHardLinkBreakMenuText")
    String insertHardLinkBreakMenuText(); //NON-NLS

    /**
     * Translated "Insert:::Tabset...". //NON-NLS
     *
     * @return translated "Insert:::Tabset..."
     */
    @DefaultMessage("Insert:::Tabset...")
    @Key("insertTabsetMenuText")
    String insertTabsetMenuText();

    /**
     * Translated "Insert:::Callout...".
     * //NON-NLS
     * @return translated "Insert:::Callout..."
     */
    @DefaultMessage("Insert:::Callout...")
    @Key("insertCalloutMenuText") //NON-NLS
    String insertCalloutMenuText();

    /**
     * Translated "Go to Next Section".
     *
     * @return translated "Go to Next Section" //NON-NLS
     */
    @DefaultMessage("Go to Next Section")
    @Key("goToNextSectionMenuText")
    String goToNextSectionMenuText();

    /**
     * Translated "Go to Previous Section".
     *
     * @return translated "Go to Previous Section"
     */
    @DefaultMessage("Go to Previous Section")
    @Key("goToPreviousSectionMenuText") //NON-NLS
    String goToPreviousSectionMenuText();

    /**
     * Translated "Go to Next Chunk".
     *
     * @return translated "Go to Next Chunk" //NON-NLS
     */
    @DefaultMessage("Go to Next Chunk") //NON-NLS
    @Key("goToNextChunkMenuText")
    String goToNextChunkMenuText();

    /**
     * Translated "Go to Previous Chunk".
     *
     * @return translated "Go to Previous Chunk"
     */
    @DefaultMessage("Go to Previous Chunk") //NON-NLS
    @Key("goToPreviousChunkMenuText")
    String goToPreviousChunkMenuText();

    /**
     * Translated "Insert:::Slide Pause".
     *
     * @return translated "Insert:::Slide Pause"
     */
    @DefaultMessage("Insert:::Slide Pause")
    @Key("insertSlidePauseMenuText")
    String insertSlidePauseMenuText();

    /**
     * Translated "Insert:::Slide Notes".
     * //NON-NLS
     * @return translated "Insert:::Slide Notes"
     */
    @DefaultMessage("Insert:::Slide Notes")
    @Key("insertSlideNotesMenuText")
    String insertSlideNotesMenuText();

    /**
     * Translated "Insert:::Slide Columns".
     *
     * @return translated "Insert:::Slide Columns"
     */
    @DefaultMessage("Insert:::Slide Columns")
    @Key("insertSlideColumnsMenuText")
    String insertSlideColumnsMenuText();

    /**
     * Translated "Command palette requested unknown command from visual editor: '". //NON-NLS
     *
     * @return translated "Command palette requested unknown command from visual editor: '"
     */
    @DefaultMessage("Command palette requested unknown command from visual editor: ") //NON-NLS
    @Key("unknownCommandDebugLog")
    String unknownCommandDebugLog();

    /**
     * Translated "Edit Attributes".
     *
     * @return translated "Edit Attributes"
     */
    @DefaultMessage("Edit Attributes")
    @Key("editAttributesCaption")
    String editAttributesCaption();

    /**
     * Translated "Span Attributes".
     *
     * @return translated "Span Attributes"
     */
    @DefaultMessage("Span Attributes")
    @Key("spanAttributesCaption") //NON-NLS
    String spanAttributesCaption();


    /**
     * Translated "Unwrap Span". //NON-NLS
     *
     * @return translated "Unwrap Span"
     */
    @DefaultMessage("Unwrap Span")
    @Key("unwrapSpanRemoveButtonCaption")
    String unwrapSpanRemoveButtonCaption();

    /**
     * Translated "Div Attributes".
     *
     * @return translated "Div Attributes" //NON-NLS //NON-NLS
     */
    @DefaultMessage("Div Attributes")
    @Key("divAttributesCaption")
    String divAttributesCaption();

    /**
     * Translated "Callout".
     *
     * @return translated "Callout"
     */
    @DefaultMessage("Callout")
    @Key("calloutCaption") //NON-NLS
    String calloutCaption();

    /**
     * Translated "Unwrap Div". //NON-NLS
     *
     * @return translated "Unwrap Div" //NON-NLS
     */
    @DefaultMessage("Unwrap Div")
    @Key("unwrapDivTitle") //NON-NLS
    String unwrapDivTitle();

    /**
     * Translated "remove".
     *
     * @return translated "remove"
     */
    @DefaultMessage("remove")
    @Key("removeActionText")
    String removeActionText();

    /**
     * Translated "Type: ".
     *
     * @return translated "Type: "
     */
    @DefaultMessage("Type: ")
    @Key("typeLabel")
    String typeLabel();

    /** //NON-NLS
     * Translated "note".
     *
     * @return translated "note"
     */
    @DefaultMessage("note")
    @Key("noteLabel") //NON-NLS
    String noteLabel();

    /**
     * Translated "tip".
     *
     * @return translated "tip"
     */
    @DefaultMessage("tip")
    @Key("tipLabel")
    String tipLabel();

    /**
     * Translated "important". //NON-NLS
     *
     * @return translated "important"
     */
    @DefaultMessage("important") //NON-NLS
    @Key("importantLabel")
    String importantLabel();

    /**
     * Translated "caution".
     *
     * @return translated "caution"
     */
    @DefaultMessage("caution")
    @Key("cautionLabel") //NON-NLS
    String cautionLabel();

    /**
     * Translated "warning".
     *
     * @return translated "warning"
     */
    @DefaultMessage("warning") //NON-NLS
    @Key("warningLabel")
    String warningLabel(); //NON-NLS


    /**
     * Translated "Appearance: ".
     *
     * @return translated "Appearance: " //NON-NLS
     */
    @DefaultMessage("Appearance: ")
    @Key("appearanceLabel")
    String appearanceLabel();

    /**
     * Translated "default".
     *
     * @return translated "default"
     */
    @DefaultMessage("default")
    @Key("defaultLabel")
    String defaultLabel();

    /**
     * Translated "simple".
     *
     * @return translated "simple"
     */
    @DefaultMessage("simple")
    @Key("simpleLabel")
    String simpleLabel(); //NON-NLS

    /**
     * Translated "minimal".
     *
     * @return translated "minimal"
     */ //NON-NLS
    @DefaultMessage("minimal") //NON-NLS
    @Key("minimalLabel")
    String minimalLabel();

    /**
     * Translated "Show icon".
     *
     * @return translated "Show icon" //NON-NLS
     */
    @DefaultMessage("Show icon")
    @Key("showIconLabel")
    String showIconLabel();

    /**
     * Translated "Caption:".
     *
     * @return translated "Caption:"
     */
    @DefaultMessage("Caption:")
    @Key("captionLabel")
    String captionLabel();

    /**
     * Translated "(Optional)".
     *
     * @return translated "(Optional)" //NON-NLS
     */
    @DefaultMessage("(Optional)")
    @Key("optionalPlaceholder")
    String optionalPlaceholder(); //NON-NLS

    /**
     * Translated "Div".
     *
     * @return translated "Div"
     */
    @DefaultMessage("Div") //NON-NLS
    @Key("divTabList") //NON-NLS
    String divTabList();

    /**
     * Translated "Callout".
     *
     * @return translated "Callout"
     */
    @DefaultMessage("Callout")
    @Key("calloutText")
    String calloutText();

    /**
     * Translated "Attributes".
     *
     * @return translated "Attributes"
     */
    @DefaultMessage("Attributes")
    @Key("attributesText")
    String attributesText();

    /**
     * Translated "Code Block".
     *
     * @return translated "Code Block"
     */
    @DefaultMessage("Code Block")
    @Key("codeBlockText")
    String codeBlockText();

    /**
     * Translated "Language". //NON-NLS
     *
     * @return translated "Language"
     */
    @DefaultMessage("Language")
    @Key("languageFormLabel")
    String languageFormLabel();

    /**
     * Translated "(optional)".
     * //NON-NLS
     * @return translated "(optional)"
     */
    @DefaultMessage("(optional)")
    @Key("optionalFormLabel")
    String optionalFormLabel();


    /**
     * Translated "Figure". //NON-NLS
     *
     * @return translated "Figure" //NON-NLS
     */
    @DefaultMessage("Figure")
    @Key("figureLabel")
    String figureLabel();

    /**
     * Translated "Image".
     *
     * @return translated "Image"
     */
    @DefaultMessage("Image")
    @Key("imageLabel")
    String imageLabel();

    /**
     * Translated "Width:".
     *
     * @return translated "Width:"
     */
    @DefaultMessage("Width:")
    @Key("widthLabel")
    String widthLabel();

    /**
     * Translated "Height:". //NON-NLS
     *
     * @return translated "Height:"
     */
    @DefaultMessage("Height:")
    @Key("heightLabel")
    String heightLabel();

    /**
     * Translated "(Auto)".
     *
     * @return translated "(Auto):"
     */
    @DefaultMessage("(Auto)")
    @Key("autoText") //NON-NLS
    String autoText();

    /**
     * Translated "Lock ratio".
     *
     * @return translated "Lock ratio"
     */
    @DefaultMessage("Lock ratio") //NON-NLS
    @Key("lockRatioText")
    String lockRatioText();

    /**
     * Translated "Left".
     *
     * @return translated "Left"
     */ //NON-NLS
    @DefaultMessage("Left")
    @Key("leftLabel")
    String leftLabel();

    /**
     * Translated "Center".
     *
     * @return translated "Center"
     */
    @DefaultMessage("Center")
    @Key("centerLabel")
    String centerLabel(); //NON-NLS

    /**
     * Translated "Right". //NON-NLS
     *
     * @return translated "Right"
     */
    @DefaultMessage("Right") //NON-NLS
    @Key("rightLabel")
    String rightLabel();

    /**
     * Translated "Alignment". //NON-NLS
     *
     * @return translated "Alignment" //NON-NLS
     */
    @DefaultMessage("Alignment")
    @Key("legendText")
    String legendText(); //NON-NLS

    /**
     * Translated "Alternative text:".
     *
     * @return translated "Alternative text:"
     */
    @DefaultMessage("Alternative text:") //NON-NLS
    @Key("alternativeTextLabel")
    String alternativeTextLabel();

    /**
     * Translated "Link to:".
     *
     * @return translated "Link to:" //NON-NLS
     */
    @DefaultMessage("Link to:")
    @Key("linkToLabel")
    String linkToLabel();

    /**
     * Translated "LaTeX environment:".
     *
     * @return translated "LaTeX environment:"
     */
    @DefaultMessage("LaTeX environment:")
    @Key("latexEnvironmentLabel")
    String latexEnvironmentLabel();

    /**
     * Translated "Title attribute:". //NON-NLS
     *
     * @return translated "Title attribute:"
     */
    @DefaultMessage("Title attribute:") //NON-NLS
    @Key("titleAttributeLabel")
    String titleAttributeLabel();

    /**
     * Translated "Advanced". //NON-NLS
     *
     * @return translated "Advanced"
     */ //NON-NLS
    @DefaultMessage("Advanced")
    @Key("advancedLabel")
    String advancedLabel();

    /**
     * Translated "Error".
     *
     * @return translated "Error"
     */
    @DefaultMessage("Error")
    @Key("errorCaption")
    String errorCaption();

    /**
     * Translated "You must provide a value for image width.".
     *
     * @return translated "You must provide a value for image width."
     */
    @DefaultMessage("You must provide a value for image width.")
    @Key("errorMessage")
    String errorMessage();

    /**
     * Translated "Units".
     *
     * @return translated "Units"
     */
    @DefaultMessage("Units")
    @Key("unitsLabel")
    String unitsLabel();

    /**
     * Translated "Link".
     *
     * @return translated "Link"
     */
    @DefaultMessage("Link")
    @Key("linkLabel")
    String linkLabel();

    /**
     * Translated "Remove Link".
     *
     * @return translated "Remove Link"
     */
    @DefaultMessage("Remove Link") //NON-NLS
    @Key("removeLinkTitle")
    String removeLinkTitle(); //NON-NLS

    /**
     * Translated "Text:".
     *
     * @return translated "Text:" //NON-NLS
     */
    @DefaultMessage("Text:")
    @Key("textFormLabel") //NON-NLS
    String textFormLabel();

    /**
     * Translated "Title/Tooltip:".
     *
     * @return translated "Title/Tooltip:"
     */
    @DefaultMessage("Title/Tooltip:") //NON-NLS
    @Key("titleToolTipLabel")
    String titleToolTipLabel();

    /**
     * Translated "You must provide a value for the link target.".
     *
     * @return translated "You must provide a value for the link target." //NON-NLS
     */ //NON-NLS
    @DefaultMessage("You must provide a value for the link target.")
    @Key("validateErrorMessage")
    String validateErrorMessage();

    /**
     * Translated "List".
     *
     * @return translated "List"
     */
    @DefaultMessage("List")
    @Key("listLabel")
    String listLabel();

    /**
     * Translated "(Default for presentation)".
     *
     * @return translated "(Default for presentation)"
     */
    @DefaultMessage("(Default for presentation)")
    @Key("defaultChoiceList") //NON-NLS
    String defaultChoiceList();

    /**
     * Translated "Incremental (one item at a time)". //NON-NLS
     *
     * @return translated "Incremental (one item at a time)"
     */
    @DefaultMessage("Incremental (one item at a time)")
    @Key("incrementalChoiceList")
    String incrementalChoiceList();

    /**
     * Translated "Non-Incremental (all items at once)".
     *
     * @return translated "Non-Incremental (all items at once)"
     */
    @DefaultMessage("Non-Incremental (all items at once)")
    @Key("nonIncrementalChoiceList")
    String nonIncrementalChoiceList();

    /**
     * Translated "Example".
     *
     * @return translated "Example"
     */
    @DefaultMessage("Example")
    @Key("exampleChoice")
    String exampleChoice();

    /**
     * Translated "Decimal".
     *
     * @return translated "Decimal" //NON-NLS //NON-NLS
     */
    @DefaultMessage("Decimal")
    @Key("decimalChoice")
    String decimalChoice();

    /**
     * Translated "Edit Equation ID".
     *
     * @return translated "Edit Equation ID"
     */
    @DefaultMessage("Edit Equation ID")
    @Key("editEquationCaption")
    String editEquationCaption();

    /** //NON-NLS
     * Translated "Invalid ID".
     *
     * @return translated "Invalid ID"
     */
    @DefaultMessage("Invalid ID") //NON-NLS
    @Key("invalidIDCaption")
    String invalidIDCaption();

    /**
     * Translated "Equation IDs must start with eq-".
     *
     * @return translated "Equation IDs must start with eq-"
     */
    @DefaultMessage("Equation IDs must start with eq-")
    @Key("invalidIDMessage") //NON-NLS
    String invalidIDMessage(); //NON-NLS

    /**
     * Translated "Raw {0}".
     *
     * @return translated "Raw {0}" //NON-NLS
     */ //NON-NLS
    @DefaultMessage("Raw {0}")
    @Key("modelDialogCaption")
    String modelDialogCaption(String caption);

    /**
     * Translated "Inline".
     *
     * @return translated "Inline"
     */
    @DefaultMessage("Inline")
    @Key("inlineText")
    String inlineText();

    /**
     * Translated "Block".
     *
     * @return translated "Block"
     */
    @DefaultMessage("Block")
    @Key("blockText")
    String blockText();

    /**
     * Translated "Remove Format".
     *
     * @return translated "Remove Format"
     */
    @DefaultMessage("Remove Format")
    @Key("removeFormatText")
    String removeFormatText();

    /**
     * Translated "No Content Specified".
     *
     * @return translated "No Content Specified"
     */
    @DefaultMessage("No Content Specified")
    @Key("validateCaption")
    String validateCaption();

    /**
     * Translated "You must provide content to apply the raw format to.". //NON-NLS
     *
     * @return translated "You must provide content to apply the raw format to." //NON-NLS
     */
    @DefaultMessage("You must provide content to apply the raw format to.") //NON-NLS
    @Key("validateMessage") //NON-NLS
    String validateMessage(); //NON-NLS

    /**
     * Translated "Image (File or URL):".
     *
     * @return translated "Image (File or URL):"
     */
    @DefaultMessage("Image (File or URL):")
    @Key("imageChooserLabel")
    String imageChooserLabel();

    /**
     * Translated "Browse...". //NON-NLS
     *
     * @return translated "Browse..."
     */
    @DefaultMessage("Browse...")
    @Key("browseLabel")
    String browseLabel();

    /**
     * Translated "Choose Image".
     *
     * @return translated "Choose Image"
     */
    @DefaultMessage("Choose Image")
    @Key("chooseImageCaption")
    String chooseImageCaption();

    /**
     * Translated "Looking Up DOI..".
     *
     * @return translated "Looking Up DOI.." //NON-NLS
     */
    @DefaultMessage("Looking Up DOI..")
    @Key("onProgressMessage")
    String onProgressMessage();

    /**
     * Translated "You must provide a value for the citation id.".
     *
     * @return translated "You must provide a value for the citation id."
     */
    @DefaultMessage("You must provide a value for the citation id.")
    @Key("errorValidateMessage")
    String errorValidateMessage(); //NON-NLS

    /**
     * Translated "Please provide a validation citation Id.".
     *
     * @return translated "Please provide a validation citation Id."
     */
    @DefaultMessage("Please provide a validation citation Id.")
    @Key("citationErrorMessage")
    String citationErrorMessage();

    /**
     * Translated "Please select a unique citation Id.".
     * //NON-NLS
     * @return translated "Please select a unique citation Id." //NON-NLS //NON-NLS
     */
    @DefaultMessage("Please select a unique citation Id.") //NON-NLS
    @Key("uniqueCitationErrorMessage")
    String uniqueCitationErrorMessage();

    /**
     * Translated "You must select a bibliography.".
     *
     * @return translated "You must select a bibliography."
     */
    @DefaultMessage("You must select a bibliography.")
    @Key("bibliographyErrorMessage")
    String bibliographyErrorMessage();

    /**
     * Translated "You must provide a bibliography file name.".
     *
     * @return translated "You must provide a bibliography file name."
     */
    @DefaultMessage("You must provide a bibliography file name.")
    @Key("bibliographyFileNameErrorMessage") //NON-NLS
    String bibliographyFileNameErrorMessage();

    /**
     * Translated "DOI Unavailable".
     *
     * @return translated "DOI Unavailable"
     */
    @DefaultMessage("DOI Unavailable")
    @Key("doiUnavailableCaption")
    String doiUnavailableCaption();

    /**
     * Translated "Citation from DOI".
     *
     * @return translated "Citation from DOI"
     */
    @DefaultMessage("Citation from DOI")
    @Key("citationDOITitle")
    String citationDOITitle();

    /**
     * Translated "Citation from ".
     *
     * @return translated "Citation from "
     */
    @DefaultMessage("Citation from ")
    @Key("citationFromText") //NON-NLS
    String citationFromText();

    /**
     * Translated "An error occurred while loading citation data for this DOI.".
     *
     * @return translated "An error occurred while loading citation data for this DOI." //NON-NLS
     */
    @DefaultMessage("An error occurred while loading citation data for this DOI.")
    @Key("kUnknownError")
    String kUnknownError();

    /**
     * Translated "Citation data for this DOI couldn't be found.".
     *
     * @return translated "Citation data for this DOI couldn't be found."
     */
    @DefaultMessage("Citation data for this DOI couldn''t be found.") //NON-NLS //NON-NLS
    @Key("kNoDataError")
    String kNoDataError();

    /**
     * Translated "Unable to reach server to load citation data for this DOI.".
     * //NON-NLS
     * @return translated "Unable to reach server to load citation data for this DOI."
     */
    @DefaultMessage("Unable to reach server to load citation data for this DOI.")
    @Key("kServerError")
    String kServerError();

    /**
     * Translated "Insert Table".
     *
     * @return translated "Insert Table"
     */
    @DefaultMessage("Insert Table")
    @Key("insertTableCaption")
    String insertTableCaption(); //NON-NLS

    /**
     * Translated "Insert Tabset".
     *
     * @return translated "Insert Tabset"
     */
    @DefaultMessage("Insert Tabset")
    @Key("insertTabsetCaption")
    String insertTabsetCaption();

    /**
     * Translated "Tab names:".
     *
     * @return translated "Tab names:"
     */
    @DefaultMessage("Tab names:")
    @Key("tabNamesFormLabel")
    String tabNamesFormLabel();

    /**
     * Translated "Image".
     *
     * @return translated "Image"
     */
    @DefaultMessage("Image") //NON-NLS
    @Key("imageTabListLabel")
    String imageTabListLabel(); //NON-NLS

    /**
     * Translated "Tabs".
     *
     * @return translated "Tabs" //NON-NLS
     */
    @DefaultMessage("Tabs")
    @Key("tabsText")
    String tabsText();

    /**
     * Translated "You must specify at least two tab names".
     * //NON-NLS
     * @return translated "You must specify at least two tab names"
     */ //NON-NLS
    @DefaultMessage("You must specify at least two tab names") //NON-NLS
    @Key("tabSetErrorMessage")
    String tabSetErrorMessage();

    /**
     * Translated "(Tab {0}{1})".
     *
     * @return translated "(Tab {0}{1})"
     */
    @DefaultMessage("(Tab {0}{1})") //NON-NLS
    @Key("addTabCaptionInput")
    String addTabCaptionInput(int index, String required); //NON-NLS

    /**
     * Translated "- Optional".
     *
     * @return translated "- Optional" //NON-NLS
     */
    @DefaultMessage("- Optional")
    @Key("optionalText")
    String optionalText(); //NON-NLS

    /**
     * Translated "Format:".
     *
     * @return translated "Format:"
     */
    @DefaultMessage("Format:")
    @Key("formatLabel")
    String formatLabel();

    /**
     * Translated "(Choose Format)".
     *
     * @return translated "(Choose Format)"
     */
    @DefaultMessage("(Choose Format)") //NON-NLS
    @Key("chooseFormatLabel") //NON-NLS
    String chooseFormatLabel();

    /**
     * Translated "incremental".
     *
     * @return translated "incremental"
     */
    @DefaultMessage("incremental")
    @Key("incrementalLabel")
    String incrementalLabel();

    /**
     * Translated "incremental".
     *
     * @return translated "incremental"
     */
    @DefaultMessage("nonincremental") //NON-NLS
    @Key("nonincrementalLabel")
    String nonincrementalLabel(); //NON-NLS

    /**
     * Translated "{0} occurrences replaced.".
     *
     * @return translated "{0} occurrences replaced."
     */
    @DefaultMessage("{0} occurrences replaced.")
    @Key("rStudioGinjectorErrorMessage")
    String rStudioGinjectorErrorMessage(int replaced);

    /**
     * Translated "(chunk {0})".
     *
     * @return translated "(chunk {0})"
     */
    @DefaultMessage("(chunk {0})") //NON-NLS
    @Key("chunkText")
    String chunkText(int sequence);

    /**
     * Translated "Reading bibliography...".
     *
     * @return translated "Reading bibliography..."
     */
    @DefaultMessage("Reading bibliography...")
    @Key("readingBibliographyProgressText")
    String readingBibliographyProgressText();

    /**
     * Translated "Saving biliography...".
     *
     * @return translated "Saving biliography..." //NON-NLS
     */
    @DefaultMessage("Saving biliography...")
    @Key("savingBibliographyProgressText")
    String savingBibliographyProgressText();

    /**
     * Translated "Looking up DOI...".
     *
     * @return translated "Looking up DOI..."
     */
    @DefaultMessage("Looking up DOI...")
    @Key("lookingUpDOIProgress")
    String lookingUpDOIProgress();

    /**
     * Translated "Loading Collections...".
     *
     * @return translated "Loading Collections..."
     */
    @DefaultMessage("Loading Collections...")
    @Key("loadingCollectionsProgressText")
    String loadingCollectionsProgressText();

    /**
     * Translated "Reading Collections...".
     *
     * @return translated "Reading Collections..."
     */
    @DefaultMessage("Reading Collections...")
    @Key("readingCollectionsProgressText")
    String readingCollectionsProgressText();

}
