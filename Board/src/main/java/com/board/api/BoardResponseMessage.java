package com.board.api;

import com.board.domain.Board;
import com.board.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
//Board data 넘겨주는 controller
public class BoardResponseMessage {
    private String status;
    private String message;
    private List<BoardDTO> data;
}
