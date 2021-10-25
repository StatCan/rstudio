/*
 * cite-completion-quarto-xref.ts
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
import { Node as ProsemirrorNode } from 'prosemirror-model';
import { EditorView } from 'prosemirror-view';

import { EditorUI } from '../../api/ui';

import { performCiteCompletionReplacement } from './cite';
import { CiteCompletionEntry, CiteCompletionProvider } from './cite-completion';
import { EditorServer } from '../../api/server';
import { XRef, xrefKey } from '../../api/xref';
import { kQuartoXRefTypes } from '../xref/xref-completion';

export const kCiteCompletionTypeXref = "xref";

export function quartoXrefCiteCompletionProvider(ui: EditorUI, server: EditorServer): CiteCompletionProvider {
  const referenceEntryForXref = (xref: XRef, forceLightMode?: boolean): CiteCompletionEntry => {

    // The type (e.g. fig)
    const type = kQuartoXRefTypes[xref.type];

    // The id (e.g. fig-foobar)
    const id = xrefKey(xref, "quarto");

    // The display text for the entry
    const primaryText = id;
    const secondaryText = (len: number) => {
      return xref.file;
    };
    const detailText = xref.title || "";

    // The image and adornment
    const image = type?.image(ui) || ui.images.omni_insert?.generic!;
    const imageAdornment = undefined;

    // Insert item
    const replace = (view: EditorView, pos: number, _server: EditorServer) => {
      // It's already in the bibliography, just write the id
      const tr = view.state.tr;
      const schema = view.state.schema;
      const idMark = schema.text(id, [schema.marks.cite_id.create()]);
      performCiteCompletionReplacement(tr, pos, idMark);
      view.dispatch(tr);
      return Promise.resolve();
    };

    return {
      id,
      type: kCiteCompletionTypeXref,
      primaryText,
      secondaryText,
      detailText,
      image,
      imageAdornment,
      replace
    };
  };

  let loadedEntries: CiteCompletionEntry[] | undefined;
  return {
    currentEntries: () => {
      return loadedEntries;
    },
    streamEntries: (doc: ProsemirrorNode, onStreamReady: (entries: CiteCompletionEntry[]) => void) => {
      const docPath = ui.context.getDocumentPath();
      if (docPath) {
        ui.context.withSavedDocument().then(() => {
          server.xref.quartoIndexForFile(docPath).then(xrefs => {
            loadedEntries = xrefs.refs.map(ref => referenceEntryForXref(ref));
            onStreamReady(loadedEntries);
          });
        });
      }
    },
    awaitEntries: async (doc: ProsemirrorNode) => {
      const docPath = ui.context.getDocumentPath();
      if (docPath) {
        await ui.context.withSavedDocument();
        const index = await server.xref.quartoIndexForFile(docPath);
        loadedEntries = index.refs.map(ref => referenceEntryForXref(ref));
        return loadedEntries;
      } else {
        return Promise.resolve([]);
      }
    },
    warningMessage: () => {
      return undefined;
    }
  };
}


