package com.sparta.elasticsearch_practice;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private Long memberId;
    private String title;
    private String content;
    private String keyword;
}
