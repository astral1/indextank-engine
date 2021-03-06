/*
 * Copyright (c) 2011 LinkedIn, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flaptor.indextank.storage.alternatives;

import com.flaptor.indextank.index.BoostedDocument;
import com.flaptor.util.Pair;

import java.util.Map;

/**
 * Abstract implementation of IndexStorage that takes care of the defaults for the <code>requireConsistency</code>
 * parameters (setting them as <code>false</code>
 *
 * @author iperez
 */
public abstract class AbstractIndexStorage implements IndexStorage {

    @Override
    public Iterable<Pair<String, BoostedDocument>> getAllDocuments() {
        return getAllDocuments(false);
    }

    @Override
    public Iterable<Pair<String, BoostedDocument>> getAllDocuments(long backTo) {
        return getAllDocuments(false, backTo);
    }

    @Override
    public BoostedDocument getDocument(String docId) {
        return getDocument(docId, false);
    }

    @Override
    public Map<String, BoostedDocument> getDocuments(Iterable<String> docIds) {
        return getDocuments(docIds, false);
    }

}
