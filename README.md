Team SanUltari Patch
====================

해당 리포지토리는 LinkedIn의 IndexTank 프로젝트에서 포크된 리포지토리입니다.

패치된 항목은 아래와 같습니다.

* Lucene core 3.6.1로 업그레이드(진행중 - @Deprecated로 표시된 Method의 사용 제거중)
* UTF-8 encoding 지원(linkedin/indextank-engine에도 반영)
* KoreanAnalyzer 적용(루씬 한글분석기 오픈소스 프로젝트[http://cafe.naver.com/korlucene])
** 은태환(theun)님과 anoixi님의 패치된 분석기를 적용하였습니다.

설정은 가장 아래 부분의 예제를 참고하십시오.

위 패치는 develop 브랜치에 정리되어 있으며, master에는 UTF-8 encoding 지원까지만 반영되어 있습니다.
소스 확인시 참고해 주시기 바랍니다.

라이센스는 IndexTank 관련 소스는 APL v2.0을 KrAnalyzer 역시 APL v2.0을 따릅니다.

About IndexTank Engine
======================

This project contains IndexTank (http://indextank.com) search engine implementation.
Includes features like variables (boosts), categories (facets), faceted search, snippeting, custom scoring functions, suggest, and autocomplete.

For IndexTank's full administrative stack (which makes use of this engine) see http://github.com/linkedin/indextank-service

### License:

Apache Public License (APL) 2.0

### Artifacts:

1. indextank-engine-1.0.0.jar <-- core library

### Maven:

groupId: com.flaptor.indextank
artifactId: indextank-engine
version: 1.0.0

Package generation:
-------------------

Build a single jar containing all dependencies by:

    $ mvn compile package assembly:single

This will create a single file in:

    target/indextank-engine-1.0.0-jar-with-dependencies.jar

Quick start with the standalone REST API
----------------------------------------

You can try basic indexing and searching

Main class: com.flaptor.indextank.api.Launcher

After running the package generation:

    $ java -cp target/indextank-engine-1.0.0-jar-with-dependencies.jar com.flaptor.indextank.api.Launcher

This command starts an API server (http://www.indextank.com/documentation/api) at port 20220.
The indexing and searching can be done with any client or for example, via curl:

    $ curl -d "{\"docid\":\"post1\", \"fields\":{\"text\":\"I love Fallout\"}}" -v -X PUT http://localhost:20220/v1/indexes/idx/docs

    $ curl -d "{\"docid\":\"post2\", \"fields\":{\"text\":\"I love Planescape\"}}" -v -X PUT http://localhost:20220/v1/indexes/idx/docs

    $ curl http://localhost:20220/v1/indexes/idx/search?q=love

API Clients (compatible with the embedded API)
----------------------------------------------

Java: https://github.com/flaptor/indextank-java
Python: https://github.com/flaptor/indextank-py
Ruby: https://github.com/flaptor/indextank-rb
PHP: https://github.com/flaptor/indextank-php

Thrift API sample configuration:
--------------------------------

Main class: com.flaptor.indextank.index.IndexEngine

VM args:

    -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -Dorg.apache.lucene.FSDirectory.class=org.apache.lucene.store.MMapDirectory -Xmx600M

Program args:

    --facets --rti-size 500 --conf-file sample-engine-config --port 20220 --environment-prefix TEST --recover --dir index --snippets --suggest documents --boosts 3 --index-code dgmqn --functions 0:-age

Sample engine configuration file contents:

    {
        "encoding": "utf-8",
        "max_variables": 3,
        "functions": {"0": "-age"},
        "index_code": "dbajo",
        "allows_facets": true,
        "ram": 600,
        "log_based_storage": false,
        "log_server_host": "index123.localhost",
        "log_server_port": 15100,
        "autocomplete": true,
        "autocomplete_type": "documents",
        "allows_snippets": true,
        "rti_size": 500,
        "facets_bits": 5,
        "base_port": 20220,
        "xmx": 600,
        "analyzer_config": {
            "factory": "org.apache.lucene.analysis.kr.IndexEngineKoreanAnalyzer",
            "configuration": {
               "match_version": "LUCENE_36"
            }
        }
    }

Tests:
------

Execute the following command to run:

    mvn test

Avoid running tests by adding:

    mvn -Dmaven.test.skip=true compile
