package com.board.mapper;

import com.board.domain.BoardDTO;
import com.board.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO boardDTO);
    public BoardDTO selectUserid(String userid);
}
