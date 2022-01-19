package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.UserDTO;

@Mapper
public interface UserMapper {

    public void insertUser(UserDTO user);
    public UserDTO selectUsername(String userid);


}