/*
 * preload.ts
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
import { contextBridge } from 'electron';

import { removeDups } from '../core/string-utils';

import { getDesktopInfoBridge } from './desktop-info-bridge';
import { getMenuBridge } from './menu-bridge';
import { getDesktopBridge } from './desktop-bridge';
import { firstStartingWith } from '../core/array-utils';

/**
 * The preload script is run in the renderer before our GWT code and enables
 * setting up a bridge between the main process and the renderer process via
 * the contextBridge mechanism.
 *
 * Preload code has access to powerful node.js and Electron APIs even though
 * the renderer itself is configured with node disabled and context isolation.
 *
 * Be careful to only expose the exact APIs desired; DO NOT expose general-purpose
 * IPC objects, etc.
 *
 * Actual implementation happens in the main process, reached via ipcRenderer.
 */

// --apiKeys= argument contains list of apiKeys to expose, separated by '|'.
const apiKeys = removeDups(firstStartingWith(process.argv, '--apiKeys=').split('|'));
for (const apiKey of apiKeys) {
  switch (apiKey) {
    case 'desktop':
      contextBridge.exposeInMainWorld(apiKey, getDesktopBridge());
      break;
    case 'desktopInfo':
      contextBridge.exposeInMainWorld(apiKey, getDesktopInfoBridge());
      break;
    case 'desktopMenuCallback':
      contextBridge.exposeInMainWorld(apiKey, getMenuBridge());
      break;
    // case 'remoteDesktop':
    //   // TODO: RDP-only
    //   break;
    default:
      console.error(`Preload ignoring unsupported apiKey: ${apiKey}`);
  }
}
