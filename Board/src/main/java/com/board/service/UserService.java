package com.board.service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.LocalDateTime.now;

//회원 등록
@Service
public class UserService {
    @Autowired
    private final UserMapper userMapper; //final로 쓰는게 좋음 + 생성자 만들기

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void signupService(UserDTO requestDto){
        userMapper.insertUser(requestDto);
    }
}
