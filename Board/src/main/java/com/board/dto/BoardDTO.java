package com.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long idx;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String id;
    private boolean deleteChk;
    private LocalDateTime insertTime;
    private LocalDateTime deleteTime;

    @Override
    public String toString() {
        return "BoardDTO{" +
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
