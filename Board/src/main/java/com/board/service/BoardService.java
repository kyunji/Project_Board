package com.board.service;

import com.board.domain.Board;
import com.board.dto.BoardDTO;
import com.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public void insertService(BoardDTO boardDTO){
        Board board=Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
//                .id(boardDTO.getId())
                .build();
        boardMapper.insertBoard(board);
    };

}
