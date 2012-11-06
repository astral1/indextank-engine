package org.apache.lucene.analysis.kr;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.WordlistLoader;
import org.apache.lucene.util.Version;

import java.io.*;
import java.util.HashSet;

public final class KoreanWordlistLoader extends WordlistLoader {

    /**
     * Loads a text file and adds every line as an entry to a HashSet (omitting
     * leading and trailing whitespace). Every line of the file should contain only
     * one word. The words need to be in lowercase if you make use of an
     * Analyzer which uses LowerCaseFilter (like StandardAnalyzer).
     *
     * @param wordfile File containing the wordlist
     * @return A HashSet with the file's words
     */
    public static CharArraySet getWordSet(File wordfile) throws IOException {
        return getWordSet(wordfile, KoreanAnalyzer.DIC_ENCODING);
    }

    /**
     * Loads a text file and adds every line as an entry to a HashSet (omitting
     * leading and trailing whitespace). Every line of the file should contain only
     * one word. The words need to be in lowercase if you make use of an
     * Analyzer which uses LowerCaseFilter (like StandardAnalyzer).
     *
     * @param wordfile File containing the wordlist
     * @return A HashSet with the file's words
     */
    public static CharArraySet getWordSet(File wordfile, String encoding) throws IOException {
        InputStream is = new FileInputStream(wordfile);
        InputStreamReader reader = new InputStreamReader(is, encoding);
        return WordlistLoader.getWordSet(reader, Version.LUCENE_36);
    }
}
