package com.board.mapper;

import com.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public void insertBoard(Board board);
    public Board selectUserid(String userid);
}
