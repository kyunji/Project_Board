package com.board.service;

import com.board.domain.User;
import com.board.dto.UserDTO;
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

    //회원 등록
    public int insertUser(UserDTO requestDto){
        //DTO->domain
        User user = User.builder()
                .id(requestDto.getId())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();
        if(userMapper.insertUser(user))
            return 1;
        else
            return 0;
    }
    //회원 중복 체크
    /* public void duplicatedUser(UserDTO user){
        if(userMapper.findUser(user.getId())!=null)
            throw new IllegalStateException("이미 존재합니다");

    }*/

    //회원 등록
    public int login(User requestDto){
        //login 성공
        if(userMapper.findUser(requestDto)!=null)
            return 1;
        // 실패
        else
            return 0;
    }
}
