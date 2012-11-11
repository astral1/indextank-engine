package org.apache.lucene.analysis.kr;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import java.io.StringReader;

public class KrAnalyzer {
    public static void main(String[] args) {
        String source = "우리나라 라면에서부터 일본 라면이 파생되었잖니?";

        long start = System.currentTimeMillis();

        IndexEngineKoreanAnalyzer koreanAnalyzer = new IndexEngineKoreanAnalyzer();
        TokenStream stream = koreanAnalyzer.tokenStream("k", new StringReader(source));
        Token t;
    }
}
