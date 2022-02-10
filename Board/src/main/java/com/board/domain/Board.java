package com.board.domain;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@RequiredArgsConstructor
public class Board {
    private Long idx;
    private String title;
    private String content;
    private String id;
    private LocalDateTime insertTime;

    @Builder
    public Board(Long idx, String title, String content, String id, LocalDateTime insertTime){
        this.idx=idx;
        this.title=title;
        this.content=content;
        this.id=id;
        this.insertTime=insertTime;
    }

    @Override
    public String toString() {
        return "Board{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", insert_time=" + insertTime +
                '}';
    }
}
