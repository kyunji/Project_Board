package com.board.controller;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import com.board.service.UserService;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//@CrossOrigin(origins="http://localhost:8081")
@RestController // JSON 형태의 객체 return
//@NoArgsConstructor //생성자 주입 방법
public class UserController {
    @Autowired //필드주입
    private UserService userService;

    //welcome page
    @RequestMapping("/")
    public String home(){
        System.out.println("home \n");
        return "home";
    }

    //회원가입
    @PutMapping("/api/signup")
    public void signupUser(@RequestBody UserDTO requestDto) {
        userService.signupService(requestDto);
        System.out.println("signup \n");
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








