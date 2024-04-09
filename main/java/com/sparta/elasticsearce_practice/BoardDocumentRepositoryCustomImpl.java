package com.sparta.elasticsearce_practice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardDocumentRepositoryCustomImpl implements BoardDocumentRepositoryCustom{
    private final ElasticsearchOperations elasticsearchOperations;
}
