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

package com.flaptor.indextank.index.lsi;

import com.flaptor.indextank.index.lsi.term.PayloadEncoder;
import com.flaptor.indextank.query.analyzers.FilteredTokenStreamComponents;
import org.apache.lucene.analysis.KeywordTokenizer;
import org.apache.lucene.analysis.ReusableAnalyzerBase;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.PayloadAttribute;
import org.apache.lucene.index.Payload;

import java.io.IOException;
import java.io.Reader;

public class PayloadAnalyzer extends ReusableAnalyzerBase {

    @Override
    protected FilteredTokenStreamComponents createComponents(String fieldName, Reader reader) {
        FilteredTokenStreamComponents components = new FilteredTokenStreamComponents(new KeywordTokenizer(reader));

        return components.add(Filter.class);
    }

    public static class Filter extends TokenFilter {
        private CharTermAttribute termAtt;
        private PayloadAttribute payAtt;

        public Filter(TokenStream input) {
            super(input);
            termAtt = addAttribute(CharTermAttribute.class);
            payAtt = addAttribute(PayloadAttribute.class);
        }

        @Override
        public final boolean incrementToken() throws IOException {
            boolean result = false;
            if (input.incrementToken()) {
                String docid = termAtt.toString();
                setTermBuffer(termAtt, LsiIndex.PAYLOAD_TERM_TEXT);
                payAtt.setPayload(new Payload(PayloadEncoder.encodePayloadId(docid)));
                return true;
            }
            return result;
        }

        private void setTermBuffer(CharTermAttribute termAttr, String buffer) {
            int length = buffer.length();
            termAttr.resizeBuffer(length);
            termAttr.copyBuffer(buffer.toCharArray(), 0, length);
            termAttr.setLength(length);
        }
    }
}
