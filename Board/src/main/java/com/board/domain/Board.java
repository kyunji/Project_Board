package com.board.domain;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {
    private Long idx;
    private String title;
    private String content;
    private String id;
    private boolean delete_chk;
    private LocalDateTime insert_time;
    private LocalDateTime delete_time;

    @Builder
    public Board(String title, String content, String id, boolean delete_chk, LocalDateTime insert_time, LocalDateTime delete_time){
        this.title=title;
        this.content=content;
        this.id=id;
        this.delete_chk=delete_chk;
        this.insert_time=insert_time;
        this.delete_time=delete_time;
    }

}
