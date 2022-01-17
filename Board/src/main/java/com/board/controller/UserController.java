package com.board.controller;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class UserController {

    @Autowired
    private UserMapper userMapper;

    public void testOfInsert() {
        UserDTO params = new UserDTO();
        params.setUsername("ABC");
        params.setUserid("id");
        params.setUserpassword("password");


        int result = userMapper.insertUser(params);
        System.out.println("결과는 " + result + "입니다.");
    }

}