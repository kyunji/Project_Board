package com.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private boolean delete_chk;
    private LocalDateTime insert_time;
    private LocalDateTime delete_time;

    public BoardDTO(String title, String content, String writer) {
        this.title=title;
        this.content=content;
        this.writer=writer;

    }

}
