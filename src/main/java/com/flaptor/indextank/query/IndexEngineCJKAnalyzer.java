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

import com.google.common.collect.Maps;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.StopwordAnalyzerBase;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.cjk.CJKBigramFilter;
import org.apache.lucene.analysis.cjk.CJKTokenizer;
import org.apache.lucene.analysis.cjk.CJKWidthFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;

import java.io.Reader;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class IndexEngineCJKAnalyzer extends StopwordAnalyzerBase {
    //~ Static fields/initializers ---------------------------------------------

    /**
     * An array containing some common English words that are not usually
     * useful for searching and some double-byte interpunctions.
     *
     * @deprecated use {@link #getDefaultStopSet()} instead
     */
    @Deprecated
    public final static String[] STOP_WORDS = {
            "a", "and", "are", "as", "at", "be",
            "but", "by", "for", "if", "in",
            "into", "is", "it", "no", "not",
            "of", "on", "or", "s", "such", "t",
            "that", "the", "their", "then",
            "there", "these", "they", "this",
            "to", "was", "will", "with", "",
            "www"
    };

    //~ Instance fields --------------------------------------------------------

    /**
     * Returns an unmodifiable instance of the default stop-words set.
     *
     * @return an unmodifiable instance of the default stop-words set.
     */
    public static Set<?> getDefaultStopSet() {
        return DefaultSetHolder.DEFAULT_STOP_SET;
    }

    private static class DefaultSetHolder {
        static final Set<?> DEFAULT_STOP_SET = CharArraySet
                .unmodifiableSet(new CharArraySet(Version.LUCENE_CURRENT, Arrays.asList(STOP_WORDS),
                        false));
    }

    //~ Constructors -----------------------------------------------------------

    /**
     * Builds an analyzer which removes words in {@link #getDefaultStopSet()}.
     */
    public IndexEngineCJKAnalyzer(Version matchVersion) {
        this(matchVersion, DefaultSetHolder.DEFAULT_STOP_SET);
    }

    /**
     * Builds an analyzer with the given stop words
     *
     * @param matchVersion lucene compatibility version
     * @param stopwords    a stopword set
     */
    public IndexEngineCJKAnalyzer(Version matchVersion, Set<?> stopwords) {
        super(matchVersion, stopwords);
    }

    /**
     * Builds an analyzer which removes words in the provided array.
     *
     * @param stopWords stop word array
     * @deprecated use {@link #IndexEngineCJKAnalyzer(Version, Set)} instead
     */
    @Deprecated
    public IndexEngineCJKAnalyzer(Version matchVersion, String... stopWords) {
        super(matchVersion, StopFilter.makeStopSet(matchVersion, stopWords));
    }

    //~ Methods ----------------------------------------------------------------

    @Override
    protected TokenStreamComponents createComponents(String fieldName,
                                                     Reader reader) {
        if (matchVersion.onOrAfter(Version.LUCENE_36)) {
            final Tokenizer source = new StandardTokenizer(matchVersion, reader);
            // run the widthfilter first before bigramming, it sometimes combines characters.
            TokenStream result = new CJKWidthFilter(source);
            result = new LowerCaseFilter(matchVersion, result);
            result = new CJKBigramFilter(result);
            return new TokenStreamComponents(source, new StopFilter(matchVersion, result, stopwords));
        } else {
            final Tokenizer source = new CJKTokenizer(reader);
            return new TokenStreamComponents(source, new StopFilter(matchVersion, source, stopwords));
        }
    }

    public IndexEngineCJKAnalyzer(Map<Object, Object> configuration) {
        // Matching version requested for first testing user
        super(Version.valueOf((String) configuration.get("match_version")));
    }

    public IndexEngineCJKAnalyzer() {
        this(Maps.newHashMap());
    }

    public static Analyzer buildAnalyzer(Map<Object, Object> configuration) {
        return new IndexEngineCJKAnalyzer(configuration);
    }

}
