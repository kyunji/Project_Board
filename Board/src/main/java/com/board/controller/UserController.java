package com.board.controller;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import com.board.service.UserService;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController // JSON 형태의 객체 return
//@NoArgsConstructor //생성자 주입 방법
public class UserController {
    @Autowired
    private UserService userService;
    //회원가입
    @PutMapping("/signup")
    public void signupUser(@RequestBody UserDTO requestDto) {
        userService.signupService(requestDto);
    }
}

//jsp
/* @Controller
public class UserController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
 */








