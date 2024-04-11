package com.sparta.elasticsearce_practice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public String migrateDataFromMySQLToElasticsearch(){
        boardService.migrateDataFromMySQLToElasticsearch();
        return "엘라스틱서치에 성공적으로 저장하였습니다.";
    }

    @GetMapping("/board")
    public List<Board> searchBy(@RequestParam String keyword){
        return boardService.searchBy(keyword);
    }
}
