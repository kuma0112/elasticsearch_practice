package com.sparta.elasticsearch_practice;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BoardDocumentRepository extends ElasticsearchRepository<BoardDocument, Long> {
}
