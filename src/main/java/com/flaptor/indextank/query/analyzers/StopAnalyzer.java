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

package com.flaptor.indextank.query.analyzers;

import com.google.common.collect.ImmutableSet;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.StopwordAnalyzerBase;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WordlistLoader;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.IOUtils;
import org.apache.lucene.util.Version;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class StopAnalyzer extends StopwordAnalyzerBase {
    /**
     * Default maximum allowed token length
     */
    public static final int DEFAULT_MAX_TOKEN_LENGTH = 255;

    private int maxTokenLength = DEFAULT_MAX_TOKEN_LENGTH;

    /**
     * Specifies whether deprecated acronyms should be replaced with HOST type.
     * See {@linkplain "https://issues.apache.org/jira/browse/LUCENE-1068"}
     */
    private final boolean replaceInvalidAcronym;

    /**
     * An unmodifiable set containing some common English words that are usually not
     * useful for searching.
     */
    public static final Set<?> STOP_WORDS_SET = org.apache.lucene.analysis.StopAnalyzer.ENGLISH_STOP_WORDS_SET;


    private static final String STOPWORDS = "stopwords";

    public StopAnalyzer(Map<Object, Object> analyzerConfiguration) {
        super(Version.LUCENE_36, getStopWords(analyzerConfiguration));
        replaceInvalidAcronym = true;
    }

    /**
     * Builds an analyzer with the given stop words.
     *
     * @param matchVersion Lucene version to match See {@link
     *                     <a href="#version">above</a>}
     * @param stopWords    stop words
     */
    public StopAnalyzer(Version matchVersion, Set<?> stopWords) {
        super(matchVersion, stopWords);
        replaceInvalidAcronym = matchVersion.onOrAfter(Version.LUCENE_24);
    }

    /**
     * Builds an analyzer with the default stop words ({@link
     * #STOP_WORDS_SET}).
     *
     * @param matchVersion Lucene version to match See {@link
     *                     <a href="#version">above</a>}
     */
    public StopAnalyzer(Version matchVersion) {
        this(matchVersion, STOP_WORDS_SET);
    }

    /**
     * Builds an analyzer with the stop words from the given file.
     *
     * @param matchVersion Lucene version to match See {@link
     *                     <a href="#version">above</a>}
     * @param stopwords    File to read stop words from
     * @see org.apache.lucene.analysis.WordlistLoader#getWordSet(java.io.Reader, Version)
     * @deprecated Use {@link #StopAnalyzer(Version, java.io.Reader)} instead.
     */
    @Deprecated
    public StopAnalyzer(Version matchVersion, File stopwords) throws IOException {
        this(matchVersion, WordlistLoader.getWordSet(IOUtils.getDecodingReader(stopwords,
                IOUtils.CHARSET_UTF_8), matchVersion));
    }

    /**
     * Builds an analyzer with the stop words from the given reader.
     *
     * @param matchVersion Lucene version to match See {@link
     *                     <a href="#version">above</a>}
     * @param stopwords    Reader to read stop words from
     * @see WordlistLoader#getWordSet(java.io.Reader, Version)
     */
    public StopAnalyzer(Version matchVersion, Reader stopwords) throws IOException {
        this(matchVersion, WordlistLoader.getWordSet(stopwords, matchVersion));
    }

    /**
     * Set maximum allowed token length.  If a token is seen
     * that exceeds this length then it is discarded.  This
     * setting only takes effect the next time tokenStream or
     * reusableTokenStream is called.
     */
    public void setMaxTokenLength(int length) {
        maxTokenLength = length;
    }

    /**
     * @see #setMaxTokenLength
     */
    public int getMaxTokenLength() {
        return maxTokenLength;
    }

    @Override
    protected FilteredTokenStreamComponents createComponents(final String fieldName, final Reader reader) {
        final StandardTokenizer src = new StandardTokenizer(matchVersion, reader);
        src.setMaxTokenLength(maxTokenLength);
        src.setReplaceInvalidAcronym(replaceInvalidAcronym);
        TokenStream tok = new StandardFilter(matchVersion, src);
        tok = new LowerCaseFilter(matchVersion, tok);
        tok = new StopFilter(matchVersion, tok, stopwords);
        return new FilteredTokenStreamComponents(src, tok) {
            @Override
            public boolean reset(final Reader reader) throws IOException {
                src.setMaxTokenLength(StopAnalyzer.this.maxTokenLength);
                return super.reset(reader);
            }
        };
    }

    private static Set<String> getStopWords(Map<Object, Object> analyzerConfiguration) {
        if (analyzerConfiguration.containsKey(STOPWORDS)) {
            JSONArray stopwordList = (JSONArray) analyzerConfiguration.get(STOPWORDS);
            Set<String> stopwords = new HashSet<String>(stopwordList.size());
            for (Object stopword : stopwordList) {
                if (!(stopword instanceof String)) {
                    throw new IllegalArgumentException("Stopwords aren't Strings");
                }
                stopwords.add((String) stopword);
            }
            return stopwords;
        } else {
            return ImmutableSet.of();
        }
    }
}
