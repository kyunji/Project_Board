package com.board.service;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.BoardDTO;
import com.board.dto.UserDTO;
import com.board.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserDTO login(UserDTO requestDto) {

        // DTO->domain
        User user = User.builder()
                .id(requestDto.getId())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();
        User responseUser = userMapper.findUser(user);

        UserDTO userDTO=new UserDTO(responseUser.getIdx(),responseUser.getId(), responseUser.getPassword(),
                responseUser.getName(), responseUser.getEmail(),responseUser.getSignupTime());

        return userDTO;
    }
}
