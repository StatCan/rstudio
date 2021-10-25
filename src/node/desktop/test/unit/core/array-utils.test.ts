/*
 * array-utils.test.ts
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

import { describe } from 'mocha';
import { assert } from 'chai';

import { nextLowest, nextHighest } from '../../../src/core/array-utils';

describe('array-util', () => {

  const choices = [1, 3, 9, 11, 17];

  describe('nextLowest', () => {
    it('returns next lowest choice', () => {
      const current = 9;
      assert.equal(nextLowest(current, choices), 3);
    });
    it('returns lowest choice when already at bottom', () => {
      const current = 1;
      assert.equal(nextLowest(current, choices), 1);
    });
    it('returns next lowest choice when between choices', () => {
      const current = 5;
      assert.equal(nextLowest(current, choices), 3);
    });
    it('returns current value if no choices', () => {
      const noChoices: number[] = [];
      const current = 5;
      assert.equal(nextLowest(current, noChoices), 5);
    });
  });

  describe('nextHighest', () => {
    it('returns next highest choice', () => {
      const current = 9;
      assert.equal(nextHighest(current, choices), 11);
    });
    it('returns highest choice when already at top', () => {
      const current = 17;
      assert.equal(nextHighest(current, choices), 17);
    });
    it('returns next highest choice when between choices', () => {
      const current = 10;
      assert.equal(nextHighest(current, choices), 11);
    });
    it('returns current value if no choices', () => {
      const noChoices: number[] = [];
      const current = 5;
      assert.equal(nextHighest(current, noChoices), 5);
    });
  });
});
 