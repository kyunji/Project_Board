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
    public Board(String title, String content){
        this.title=title;
        this.content=content;
        //this.id=id;
    }


}
