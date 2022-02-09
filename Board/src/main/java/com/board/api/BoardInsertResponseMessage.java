package com.board.api;

import com.board.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class BoardInsertResponseMessage {
    private String status;
    private String message;
    private BoardDTO data;
}
