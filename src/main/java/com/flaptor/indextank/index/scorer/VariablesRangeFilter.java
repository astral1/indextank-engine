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

package com.flaptor.indextank.index.scorer;

import com.flaptor.indextank.index.DocId;
import com.flaptor.indextank.index.scorer.DynamicDataManager.DynamicData;
import com.flaptor.indextank.query.QueryVariables;
import com.flaptor.util.Pair;
import com.google.common.collect.Multimap;

import java.util.Collection;

public class VariablesRangeFilter implements MatchFilter {
    private DynamicDataManager dynamicDataManager;
    /**
     * The ranges apply considering both ends as inclusive and using OR to
     * join filters for the same variable and AND for different variables.
     */
    private Multimap<Integer, Pair<Float, Float>> ranges;
    public static MatchFilter NO_FILTER = new NoneMatchFilter();


    public VariablesRangeFilter(DynamicDataManager dynamicDataManager, Multimap<Integer, Pair<Float, Float>> ranges) {
        this.dynamicDataManager = dynamicDataManager;
        this.ranges = ranges;
    }

    @Override
    public boolean matches(DocId documentId, double textualScore, int now, QueryVariables queryVars) {
        DynamicData dynamicData = dynamicDataManager.getDynamicData(documentId);
        for (Integer variable : ranges.keySet()) {
            if (!checkVariable(dynamicData.getBoost(variable), ranges.get(variable))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVariable(Float value, Collection<Pair<Float, Float>> ranges) {
        for (Pair<Float, Float> range : ranges) {
            if ((range.first() == null || value >= range.first()) && (range.last() == null || value <= range.last())) {
                return true;
            }
        }
        return false;
    }
}

