package com.sparta.elasticsearch_practice;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardService {
    private final ElasticsearchOperations elasticsearchOperations;
    private final BoardRepository boardRepository;
    private final BoardDocumentRepository boardDocumentRepository;

    // MySQL 데이터를 읽어와서 Elasticsearch에 저장하는 메서드
    @Transactional
    public void migrateDataFromMySQLToElasticsearch() {
        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            BoardDocument boardDocument = new BoardDocument(board);
            boardDocumentRepository.save(boardDocument);
        }
    }


    public List<Board> searchBy(String keyword) {
        Criteria criteria = new Criteria("title").contains(keyword)
                .or(new Criteria("content").contains(keyword));
        Query query = new CriteriaQuery(criteria).setPageable(PageRequest.of(0, 10));

        SearchHits<BoardDocument> searchHits = elasticsearchOperations.search(query, BoardDocument.class);
        return searchHits.stream()
                .map(SearchHit::getContent)
                .map(this::convertToBoard)
                .collect(Collectors.toList());
    }

    private Board convertToBoard(BoardDocument boardDocument) {
        Board board = new Board();
        board.setBoardId(boardDocument.getBoardId());
        board.setMemberId(1L);
        board.setTitle(boardDocument.getTitle());
        board.setContent(boardDocument.getContent());
        return board;
    }
}
