package com.board.dto;

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
    private String id;
    private boolean delete_chk;
    private LocalDateTime insert_time;
    private LocalDateTime delete_time;

    @Override
    public String toString() {
        return "BoardDTO{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", delete_chk=" + delete_chk +
                ", insert_time=" + insert_time +
                ", delete_time=" + delete_time +
                '}';
    }
}
