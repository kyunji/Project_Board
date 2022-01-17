package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.UserDTO;

@Mapper
public interface UserMapper {

    public int insertUser(UserDTO params);
    public UserDTO selectUsername(String userid);


}