package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.User;

@Mapper
public interface UserMapper {

    public boolean insertUser(User user);
    public User selectUsername(String id);
    public User findUser(User user);

}