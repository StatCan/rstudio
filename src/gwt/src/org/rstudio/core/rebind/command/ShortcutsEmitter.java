/*
 * ShortcutsEmitter.java
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
package org.rstudio.core.rebind.command;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.user.rebind.SourceWriter;

import org.rstudio.core.client.command.KeyboardShortcut;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.Result;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ShortcutsEmitter
{
   private static class ShortcutKeyCombination
   {
      public String key;
      public String keyCode;
      public int modifiers;
   }
   
   public ShortcutsEmitter(TreeLogger logger,
                           String groupName, 
                           Element shortcutsEl) throws UnableToCompleteException
   {
      logger_ = logger;
      shortcutsEl_ = shortcutsEl;
      groupName_ = groupName;
   }

   public void generate(SourceWriter writer) throws UnableToCompleteException
   {
      NodeList children = shortcutsEl_.getChildNodes();
      for (int i = 0; i < children.getLength(); i++)
      {
         Node childNode = children.item(i);
         if (childNode.getNodeType() != Node.ELEMENT_NODE)
            continue;
         Element childEl = (Element)childNode;
         if (!childEl.getTagName().equals("shortcut")) //$NON-NLS-1$
         {
            // i18n: Concatenation/Message.  Is this seen by user?  Looks like dev code and then can be ignored
            logger_.log(Type.ERROR, "Unexpected element: " + elementToString(childEl));
            throw new UnableToCompleteException();
         }

         String condition = childEl.getAttribute("if"); //$NON-NLS-1$
         String command = childEl.getAttribute("refid"); //$NON-NLS-1$
         String shortcutValue = childEl.getAttribute("value"); //$NON-NLS-1$
         String title = childEl.getAttribute("title"); //$NON-NLS-1$
         String disableModes = childEl.getAttribute("disableModes"); //$NON-NLS-1$

         // Use null when we don't have a command associated with the shortcut,
         // otherwise refer to the function that returns the command 
         command += command.isEmpty() ? "null" : "()"; //$NON-NLS-1$

         if (shortcutValue.length() == 0)
         {
            // i18n: Concatenation/Message.  Is this seen by user?  Looks like dev code and then can be ignored
            logger_.log(Type.ERROR, "Required attribute shortcut was missing\n" + elementToString(childEl));
            throw new UnableToCompleteException();
         }

         List<String> shortcuts = preprocessShortcutValue(shortcutValue);
         for (String shortcut : shortcuts)
         {
            printShortcut(writer, condition, shortcut, 
                  command, groupName_, title, disableModes);
         }
      }
   }
   
   private static List<String> preprocessShortcutValue(String shortcutValue)
   {
      List<String> shortcuts = new ArrayList<>();
      
      for (String keySequence : shortcutValue.split("\\|")) //$NON-NLS-1$
      {
         if (keySequence.indexOf("Cmd") != -1) //$NON-NLS-1$
         {
            shortcuts.add(keySequence.replaceAll("Cmd", "Ctrl"));
            shortcuts.add(keySequence.replaceAll("Cmd", "Meta"));
         }
         else
         {
            shortcuts.add(keySequence);
         }
      }
      
      return shortcuts;
   }

   private void printShortcut(SourceWriter writer,
                              String condition,
                              String shortcut,
                              String command,
                              String shortcutGroup,
                              String title,
                              String disableModes) throws UnableToCompleteException
   {
      List<ShortcutKeyCombination> keys = new ArrayList<>();
      
      for (String keyCombination : shortcut.split("\\s+"))// $NON-NLS-1$
      {
         String[] chunks = keyCombination.split("\\+");
         
         // Build the shortcut modifiers integer and validate
         // as we build.
         int modifiers = KeyboardShortcut.NONE;
         for (int i = 0; i < chunks.length - 1; i++)
         {
            String m = chunks[i];
            if (m.equals("Ctrl")) //$NON-NLS-1$
               modifiers += KeyboardShortcut.CTRL;
            else if (m.equals("Alt")) //$NON-NLS-1$
               modifiers += KeyboardShortcut.ALT;
            else if (m.equals("Shift")) //$NON-NLS-1$
               modifiers += KeyboardShortcut.SHIFT;
            else if (m.equals("Meta")) //$NON-NLS-1$
               modifiers += KeyboardShortcut.META;
            else
            {
               logger_.log(
                     Type.ERROR,
                // i18n: Concatenation/Message.  Is this seen by user?  Looks like dev code and then can be ignored
                     "Invalid modifier '" + m + "'; expected one of " +
                     "'Ctrl', 'Alt', 'Shift', 'Meta'");
               
               throw new UnableToCompleteException();
            }
         }
            
         // Extract the key name.
         String key = chunks[chunks.length - 1];
         
         // Push the keys to the list.
         ShortcutKeyCombination combination = new ShortcutKeyCombination();
         
         combination.key = key;
         combination.keyCode = toKeyCode(key);
         combination.modifiers = modifiers;
         
         keys.add(combination);
      }
      
      // Emit the relevant code registering these shortcuts.
      if (!condition.isEmpty())
      {
         writer.println("if (" + condition + ") {"); //$NON-NLS-1$
         writer.indent();
      }
      
      if (keys.size() == 1)
      {
         ShortcutKeyCombination combination = keys.get(0);
         writer.println("ShortcutManager.INSTANCE.register(" + //$NON-NLS-1$
         
               // Key set
               "\"" + combination.key + "\", " +
               combination.keyCode + ", " +
               combination.modifiers + ", " +
               
               // Command + group
               command + ", " +
               "\"" + shortcutGroup + "\", " +
               "\"" + title + "\", " + 
               "\"" + disableModes + "\");");
      }
      else if (keys.size() == 2)
      {
         ShortcutKeyCombination c1 = keys.get(0);
         ShortcutKeyCombination c2 = keys.get(1);
         
         writer.println("ShortcutManager.INSTANCE.register(" + //$NON-NLS-1$
         
               // First key set
               "\"" + c1.key + "\", " +
               c1.keyCode + ", " +
               c1.modifiers + ", " +
               
               // Second key set
               "\"" + c2.key + "\", " +
               c2.keyCode + ", " +
               c2.modifiers + ", " +
               
               // Command + group
               command + ", " +
               "\"" + shortcutGroup + "\", " +
               "\"" + title + "\", " + 
               "\"" + disableModes + "\");");
      }
      else
      {
         logger_.log(
               Type.ERROR,
          // i18n: Concatenation/Message.  Is this seen by user?  Looks like dev code and then can be ignored
               "Invalid key sequence: sequences must be of length 1 or 2");
         throw new UnableToCompleteException();
      }
      
      if (!condition.isEmpty())
      {
         writer.outdent();
         writer.println("}");
      }
   }

   private String toKeyCode(String val)
   {
      if (val.matches("^[a-zA-Z0-9]$")) //$NON-NLS-1$
         return "'" + val.toUpperCase() + "'";
      if (val.equals("/"))
         return "191";
      if (val.equalsIgnoreCase("enter")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_ENTER";
      if (val.equalsIgnoreCase("right")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_RIGHT";
      if (val.equalsIgnoreCase("left")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_LEFT";
      if (val.equalsIgnoreCase("up")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_UP";
      if (val.equalsIgnoreCase("down")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_DOWN";
      if (val.equalsIgnoreCase("tab")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_TAB";
      if (val.equalsIgnoreCase("pageup")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_PAGEUP";
      if (val.equalsIgnoreCase("pagedown")) //$NON-NLS-1$
         return "com.google.gwt.event.dom.client.KeyCodes.KEY_PAGEDOWN";
      if (val.equalsIgnoreCase("space")) //$NON-NLS-1$
         return "32";
      if (val.equalsIgnoreCase("F1")) //$NON-NLS-1$
         return "112";
      if (val.equalsIgnoreCase("F2")) //$NON-NLS-1$
         return "113";
      if (val.equalsIgnoreCase("F3")) //$NON-NLS-1$
         return "114";
      if (val.equalsIgnoreCase("F4")) //$NON-NLS-1$
         return "115";
      if (val.equalsIgnoreCase("F5")) //$NON-NLS-1$
         return "116";
      if (val.equalsIgnoreCase("F6")) //$NON-NLS-1$
         return "117";
      if (val.equalsIgnoreCase("F7")) //$NON-NLS-1$
         return "118";
      if (val.equalsIgnoreCase("F8")) //$NON-NLS-1$
         return "119";
      if (val.equalsIgnoreCase("F9")) //$NON-NLS-1$
         return "120";
      if (val.equalsIgnoreCase("F10")) //$NON-NLS-1$
         return "121";
      if (val.equalsIgnoreCase("F11")) //$NON-NLS-1$
         return "122";
      if (val.equalsIgnoreCase("F12")) //$NON-NLS-1$
         return "123";
      if (val.equalsIgnoreCase("F13")) //$NON-NLS-1$
         return "124";
      if (val.equalsIgnoreCase("F14")) //$NON-NLS-1$
         return "125";
      if (val.equalsIgnoreCase("F15")) //$NON-NLS-1$
         return "126";
      if (val.equalsIgnoreCase("F16")) //$NON-NLS-1$
         return "127";
      if (val.equalsIgnoreCase("F17")) //$NON-NLS-1$
         return "128";
      if (val.equalsIgnoreCase("F18")) //$NON-NLS-1$
         return "129";
      if (val.equalsIgnoreCase("F19")) //$NON-NLS-1$
         return "130";
      if (val.equalsIgnoreCase("F20")) //$NON-NLS-1$
         return "131";
      if (val.equalsIgnoreCase("F21")) //$NON-NLS-1$
         return "132";
      if (val.equalsIgnoreCase("F22")) //$NON-NLS-1$
         return "133";
      if (val.equalsIgnoreCase("F23")) //$NON-NLS-1$
         return "134";
      if (val.equalsIgnoreCase("F24")) //$NON-NLS-1$
         return "135";
      if (val.equals("`"))
         return "192";
      if (val.equals("."))
         return "190";
      if (val.equals("="))
         return "187";
      if (val.equals(","))
         return "188";
      if (val.equals("-"))
         return "189";
      if (val.equals("Backspace")) //$NON-NLS-1$
         return "8";
      if (val.equals("["))
         return "219";
      if (val.equals("]"))
         return "221";

      logger_.log(Type.WARN, "Returning null from toKeyCode for key " + val);// $NON-NLS-1$
      return null;
   }

   private String elementToString(Element el) throws UnableToCompleteException
   {
      try
      {
         javax.xml.transform.TransformerFactory tfactory = TransformerFactory.newInstance();
         javax.xml.transform.Transformer xform = tfactory.newTransformer();
         javax.xml.transform.Source src = new DOMSource(el);
         java.io.StringWriter writer = new StringWriter();
         Result result = new javax.xml.transform.stream.StreamResult(writer);
         xform.transform(src, result);
         return writer.toString();
      }
      catch (Exception e)
      {
         logger_.log(Type.ERROR, "Error attempting to stringify some XML", e);
         throw new UnableToCompleteException();
      }
   }

   private final TreeLogger logger_;
   private final Element shortcutsEl_;
   private final String groupName_;
}
