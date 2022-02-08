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
    private boolean deleteChk;
    private LocalDateTime insertTime;
    private LocalDateTime deleteTime;

    @Builder
    public Board(String title, String content, String id, boolean deleteChk, LocalDateTime insertTime, LocalDateTime deleteTime){
        this.title=title;
        this.content=content;
        this.id=id;
        this.deleteChk=deleteChk;
        this.insertTime=insertTime;
        this.deleteTime=deleteTime;
    }

    @Override
    public String toString() {
        return "Board{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", delete_chk=" + deleteChk +
                ", insert_time=" + insertTime +
                ", delete_time=" + deleteTime +
                '}';
    }
}
