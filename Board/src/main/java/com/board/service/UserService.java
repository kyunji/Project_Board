package com.board.service;

import com.board.domain.User;
import com.board.dto.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//회원 등록
@Service
public class UserService {
    @Autowired
    private final UserMapper userMapper; //final로 쓰는게 좋음 + 생성자 만들기

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //회원 등록
    public boolean insertUser(UserDTO requestDto){
        //DTO->domain
        User user = User.builder()
                .id(requestDto.getId())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();
        return userMapper.insertUser(user);
    }

    //회원 등록
    public User login(UserDTO requestDto){
        User user = User.builder()
                .id(requestDto.getId())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();

        //login 성공
        if(userMapper.findUser(user)!=null){
            User responseUser=userMapper.findUser(user);
            return responseUser;
        }
        // 실패
        else
            return null;
    }
}
