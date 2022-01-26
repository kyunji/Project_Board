package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.UserDTO;

@Mapper
public interface UserMapper {

    public boolean insertUser(UserDTO user);
    public UserDTO selectUsername(String id);
    public UserDTO findUser(UserDTO user);


}