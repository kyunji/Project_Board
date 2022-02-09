package com.board.service;

import com.board.domain.Board;
import com.board.dto.BoardDTO;
import com.board.mapper.BoardMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .id(boardDTO.getId())
                .insertTime(boardDTO.getInsertTime())
                .deleteTime(boardDTO.getDeleteTime())
                .build();
        boardMapper.insertBoard(board);
    };

    public List<BoardDTO> findBoard(){
        ModelMapper modelMapper=new ModelMapper();

        List<Board> boardList= boardMapper.findBoard();
        List<BoardDTO> boardDTOList=
                boardList.stream().map(
                        p-> modelMapper.map(p,BoardDTO.class)).collect(Collectors.toList()
                );
        return boardDTOList;
    }

    public int deleteBoard(BoardDTO boardDTO){
        Board board=Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .id(boardDTO.getId())
                .insertTime(boardDTO.getInsertTime())
                .deleteTime(boardDTO.getDeleteTime())
                .build();
        return boardMapper.deleteBoard(board);

    }

    public int updateBoard(BoardDTO boardDTO){
        Board board=Board.builder()
                .idx(boardDTO.getIdx())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .id(boardDTO.getId())
                .insertTime(boardDTO.getInsertTime())
                .deleteTime(boardDTO.getDeleteTime())
                .build();
        return boardMapper.updateBoard(board);

    }

}
