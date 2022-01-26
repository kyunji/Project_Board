package com.board.controller;

import com.board.api.ApiResponseMessage;
import com.board.domain.BoardDTO;
import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import com.board.service.BoardService;
import com.board.service.UserService;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
    public void home(){
        System.out.println("home");
        //return "home";
    }

    //회원가입
    @RequestMapping(value = "/signup", method=RequestMethod.PUT)
    public ResponseEntity<ApiResponseMessage> signup(@Validated @RequestBody UserDTO userRequestDto){
        System.out.println("=============Signup======== \n");
        //userService.duplicatedUser(userRequestDto);
        userService.insertUser(userRequestDto);

        //상태코드(회원가입 성공한 경우)
        ApiResponseMessage apiResponseMessage=new ApiResponseMessage("SUCCESS","Signup SUCCESS");
        return new ResponseEntity<ApiResponseMessage>(apiResponseMessage, HttpStatus.OK);
    }

    //로그인
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public void login(@Validated @RequestBody UserDTO userRequestDto){
        if(userService.login(userRequestDto)==1){
            System.out.println("login 성공");
        }
        else
            System.out.println("login 실패");
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








