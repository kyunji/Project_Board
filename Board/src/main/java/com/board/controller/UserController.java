package com.board.controller;

import com.board.domain.BoardDTO;
import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import com.board.service.BoardService;
import com.board.service.UserService;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//vue 포트
@CrossOrigin(origins="http://localhost:8081")
@RestController // JSON 형태의 객체 return
//@NoArgsConstructor //생성자 주입 방법
public class UserController {
    @Autowired //필드주입
    private UserService userService;
    @Autowired //필드주입
    private BoardService boardService;

    //welcome page
    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    //회원가입
    @PutMapping("/signup")
    public void signupUser(@RequestBody UserDTO userRequestDto) {
        userService.signupService(userRequestDto);
        System.out.println(userRequestDto.toString());
    }

    //게시판
    @PutMapping("/board")
    public void writeBoard(@RequestBody BoardDTO boardRequestDto) {
        boardService.insertService(boardRequestDto);
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








