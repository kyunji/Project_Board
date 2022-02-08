package com.board.mapper;

import com.board.domain.Board;
import com.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void insertBoard(Board board);
    public List<Board> findBoard();
    public int deleteBoard(Board board);
}
