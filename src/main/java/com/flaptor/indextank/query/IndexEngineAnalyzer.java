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

package com.flaptor.indextank.query;

import com.flaptor.indextank.query.analyzers.FilteredTokenStreamComponents;
import com.flaptor.indextank.query.analyzers.StopAnalyzer;
import com.google.common.collect.Maps;
import org.apache.lucene.analysis.ASCIIFoldingFilter;
import org.apache.lucene.analysis.Analyzer;

import java.io.Reader;
import java.util.Map;

public class IndexEngineAnalyzer extends StopAnalyzer {

    @SuppressWarnings("deprecation")
    public IndexEngineAnalyzer(Map<Object, Object> configuration) {
        super(configuration);
    }

    public IndexEngineAnalyzer() {
        this(Maps.newHashMap());
    }

    @Override
    protected FilteredTokenStreamComponents createComponents(String fieldName, Reader reader) {
        FilteredTokenStreamComponents components = super.createComponents(fieldName, reader);

        return components.add(ASCIIFoldingFilter.class);
    }

    public static Analyzer buildAnalyzer(Map<Object, Object> configuration) {
        return new IndexEngineAnalyzer(configuration);
    }

}
