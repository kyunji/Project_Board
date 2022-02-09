package com.board.api;

import com.board.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardDeleteResponseMessage {
    private String status;
    private String message;
}
