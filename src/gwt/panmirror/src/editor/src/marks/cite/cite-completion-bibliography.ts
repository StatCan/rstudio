/*
 * cite-completion-bibliography.ts
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

import { BibliographySource, BibliographyManager } from '../../api/bibliography/bibliography';
import { kZoteroProviderKey } from '../../api/bibliography/bibliography-provider_zotero';
import { formatAuthors, formatIssuedDate } from '../../api/cite';
import { imageForType, CSLName } from '../../api/csl';
import { EditorUI } from '../../api/ui';

import { insertCitation as insertSingleCitation, performCiteCompletionReplacement } from './cite';
import { CiteCompletionEntry, CiteCompletionProvider } from './cite-completion';
import { EditorServer } from '../../api/server';

export const kCiteCompletionTypeBibliography = "bibl";

export function bibliographyCiteCompletionProvider(ui: EditorUI, bibliographyManager: BibliographyManager): CiteCompletionProvider {

  const referenceEntryForSource = (source: BibliographySource, forceLightMode?: boolean): CiteCompletionEntry => {

    // Core item metadata
    const id = source.id;
    const primaryText = id;
    const detailText = source.title || source['short-title'] || source['container-title'] || source.type;
    const image = imageForType(ui.images, source.type)[ui.prefs.darkMode() && !forceLightMode ? 1 : 0];
    const imageAdornment = source.providerKey === kZoteroProviderKey ? ui.images.citations?.zoteroOverlay : undefined;

    // The author text (and index representation)
    const secondaryText = (len: number) => {
      const authorStr = formatAuthors(source.author, len - source.id.length);
      const date = source.issued ? formatIssuedDate(source.issued) : '';
      const detail = `${authorStr} ${date}`;
      return detail;
    };
    const authorIndexStr = (cslName: CSLName) => {
      const names: string[] = [];
      if (cslName.family) {
        names.push(cslName.family);
      }
      if (cslName.given) {
        names.push(cslName.given);
      }
      if (cslName.literal) {
        names.push(cslName.literal);
      }
      return names.join(" ");
    }
    const secondaryIndex = source.author?.map(authorIndexStr).join(" ");

    // The function to insert this entry
    const replace = (view: EditorView, pos: number, server: EditorServer) => {
      if (source && bibliographyManager.findIdInLocalBibliography(source.id)) {
        // It's already in the bibliography, just write the id
        const tr = view.state.tr;
        const schema = view.state.schema;
        const citeIdMark = schema.text(source.id, [schema.marks.cite_id.create()]);
        performCiteCompletionReplacement(tr, pos, citeIdMark);
        view.dispatch(tr);
        return Promise.resolve();
      } else if (source) {
        // It isn't in the bibliography, show the insert cite dialog
        return insertSingleCitation(
          view,
          source.DOI || '',
          bibliographyManager,
          pos,
          ui,
          server.pandoc,
          source,
          bibliographyManager.providerName(source.providerKey),
        );
      } else {
        return Promise.resolve();
      }
    };

    return {
      id,
      type: kCiteCompletionTypeBibliography,
      primaryText,
      secondaryText,
      detailText,
      image,
      imageAdornment,
      index: {
        secondary: secondaryIndex,
        tertiary: detailText
      },
      replace
    };
  };

  return {
    currentEntries: () => {
      if (bibliographyManager.hasSources()) {
        return bibliographyManager.allSources().map(source => referenceEntryForSource(source));
      } else {
        return undefined;
      }
    },
    streamEntries: (doc: ProsemirrorNode, onStreamReady: (entries: CiteCompletionEntry[]) => void) => {
      bibliographyManager.load(ui, doc).then(() => {
        onStreamReady(bibliographyManager.allSources().map(source => referenceEntryForSource(source)));
      });
    },
    awaitEntries: async (doc: ProsemirrorNode) => {
      await bibliographyManager.load(ui, doc);
      return bibliographyManager.allSources().map(source => referenceEntryForSource(source));
    },
    warningMessage: () => {
      return bibliographyManager.warning();
    }

  };
}


