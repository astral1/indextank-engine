package com.flaptor.indextank.query.analyzers;

import org.apache.lucene.analysis.ReusableAnalyzerBase;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FilteredTokenStreamComponents extends ReusableAnalyzerBase.TokenStreamComponents {
    public FilteredTokenStreamComponents(Tokenizer source, TokenStream result) {
        super(source, result);
    }

    public FilteredTokenStreamComponents(Tokenizer source) {
        super(source);
    }

    public FilteredTokenStreamComponents add(Class<? extends TokenFilter> filterClass) {
        try {
            Constructor<? extends TokenFilter> constructor = filterClass.getConstructor(TokenStream.class);
            TokenFilter filter = constructor.newInstance(sink);
            return new FilteredTokenStreamComponents(source, filter);
        } catch (NoSuchMethodException e) {
            return this;
        } catch (InvocationTargetException e) {
            return this;
        } catch (InstantiationException e) {
            return this;
        } catch (IllegalAccessException e) {
            return this;
        }
    }

    @Override
    public boolean reset(Reader reader) throws IOException {
        return super.reset(reader);
    }

    @Override
    public TokenStream getTokenStream() {
        return super.getTokenStream();
    }
}
