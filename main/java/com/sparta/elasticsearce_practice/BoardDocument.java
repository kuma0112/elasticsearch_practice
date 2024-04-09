package com.sparta.elasticsearce_practice;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Document(indexName = "boards")
@Setting(settingPath = "/elasticsearch/board-document.json")
public class BoardDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Long)
    private Long boardId;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime registerDt;

    public BoardDocument(Board board) {
        this.id = board.getBoardId();
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.registerDt = board.getRegisterDt();
    }
}
