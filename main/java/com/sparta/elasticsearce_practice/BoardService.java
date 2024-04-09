package com.sparta.elasticsearce_practice;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardService {
    private final ElasticsearchOperations elasticsearchOperations;

    public Page<BoardDocument> searchBy(Pageable pageable,
                                        BoardRequestDto requestDto) {
//        BoolQueryBuilder = QueryBuilders.boolQuery();
//
//        SearchHits<BoardDocument> searchHits = this.elasticsearchOperations.search(
//                new NativeSearchQueryBuilder().withPageable(pageable).withQuery(boolQueryBuilder).build(),
//                BoardDocument.class
//        );
//        return new PageWrapperResponseDto<>(
//                searchHits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList()),
//                pageable,
//                searchHits.getTotalHits()
//        );
        return null;
    }
}
