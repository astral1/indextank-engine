package org.apache.lucene.analysis.kr;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.lucene.analysis.kr.morph.MorphException;
import org.apache.lucene.analysis.kr.utils.FileUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class KoreanEnv {

    public static final String FILE_SYLLABLE_FEATURE = "syllable.dic";

    public static final String FILE_DICTIONARY = "dictionary.dic";

    public static final String FILE_JOSA = "josa.dic";

    public static final String FILE_EOMI = "eomi.dic";

    public static final String FILE_EXTENSION = "extension.dic";

    public static final String FILE_PREFIX = "prefix.dic";

    public static final String FILE_SUFFIX = "suffix.dic";

    public static final String FILE_COMPOUNDS = "compounds.dic";

    public static final String FILE_UNCOMPOUNDS = "uncompounds.dic";

    public static final String FILE_CJ = "cj.dic";

    public static final String FILE_KOREAN_PROPERTY = "kranalyzer/korean.properties";


    public static final String ENCODING = "Encoding";
    private Properties defaults = null;

    /**
     * The props member gets its values from the configuration in the property file.
     */
    private Properties props = null;

    private static KoreanEnv instance = null;

    /**
     * The constructor loads property values from the property file.
     */
    private KoreanEnv() throws MorphException {
        try {
            initDefaultProperties();
            props = loadProperties(defaults);
        } catch (MorphException e) {
            throw new MorphException("Failure while initializing property values:\n" + e.getMessage());
        }
    }

    public static KoreanEnv getInstance() throws MorphException {
        if (instance == null)
            instance = new KoreanEnv();

        return instance;
    }

    /**
     * Initialize the default property values.
     */
    private void initDefaultProperties() {
        defaults = new Properties();

        defaults.setProperty(FILE_SYLLABLE_FEATURE, "kranalyzer/dic/syllable.dic");
        defaults.setProperty(FILE_DICTIONARY, "kranalyzer/dic/dictionary.dic");
        defaults.setProperty(FILE_EXTENSION, "kranalyzer/dic/extension.dic");
        defaults.setProperty(FILE_JOSA, "kranalyzer/dic/josa.dic");
        defaults.setProperty(FILE_EOMI, "kranalyzer/dic/eomi.dic");
        defaults.setProperty(FILE_PREFIX, "kranalyzer/dic/prefix.dic");
        defaults.setProperty(FILE_SUFFIX, "kranalyzer/dic/suffix.dic");
        defaults.setProperty(FILE_COMPOUNDS, "kranalyzer/dic/compounds.dic");
        defaults.setProperty(FILE_UNCOMPOUNDS, "kranalyzer/dic/uncompounds.dic");
        defaults.setProperty(FILE_CJ, "kranalyzer/dic/cj.dic");

        defaults.setProperty(ENCODING, "UTF-8");
    }


    /**
     * Given a property file name, load the property file and return an object
     * representing the property values.
     *
     * @param def Default property values, or <code>null</code> if there are no defaults.
     * @return The loaded SortedProperties object.
     */
    private Properties loadProperties(Properties def) throws MorphException {
        Properties properties = new Properties();

        if (def != null) {
            properties = new Properties(def);
        }

        File file = null;
        try {
            file = FileUtil.getClassLoaderFile(FILE_KOREAN_PROPERTY);
            if (file != null) {
                properties.load(new FileInputStream(file));
                return properties;
            }

            byte[] in = FileUtil.readByteFromCurrentJar(FILE_KOREAN_PROPERTY);
            properties.load(new ByteArrayInputStream(in));
        } catch (Exception e) {
            throw new MorphException("Failure while trying to load properties file " + file.getPath(), e);
        }
        return properties;
    }


    /**
     * Returns the value of a property.
     *
     * @param name The name of the property whose value is to be retrieved.
     * @return The value of the property.
     */
    public String getValue(String name) {
        return props.getProperty(name);
    }
}
