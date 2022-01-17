package com.board.controller;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;

@RestController // JSON 형태의 객체 return
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PutMapping("/signup")
    public UserDTO insertUser(@RequestBody UserDTO requestDto) {
        UserDTO params = new UserDTO();
        params.setUserid(requestDto.getUserid());
        params.setUsername(requestDto.getUsername());
        params.setUserpassword(requestDto.getUserpassword());
        params.setUseremail(requestDto.getUseremail());
        params.setSignupTime(now().toString());
        userMapper.insertUser(params);
        System.out.println(params);
        //System.out.println(userMapper.selectUsername("name").getUsername());

        return params;
    }
}