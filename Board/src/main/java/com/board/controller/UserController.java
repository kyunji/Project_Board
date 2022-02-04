package com.board.controller;

import com.board.api.ApiResponseMessage;
import com.board.domain.User;
import com.board.dto.BoardDTO;
import com.board.dto.UserDTO;
import com.board.service.BoardService;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

    //회원가입   원래는 /signup
    @RequestMapping(value = "/signup", method=RequestMethod.PUT)
    public ResponseEntity<ApiResponseMessage> signup(@Validated @RequestBody UserDTO userRequestDto){
        //1.27
        userService.insertUser(userRequestDto);
        //상태코드(회원가입 성공한 경우)
        ApiResponseMessage apiResponseMessage=new ApiResponseMessage("SUCCESS","Signup SUCCESS",null);
        return new ResponseEntity<ApiResponseMessage>(apiResponseMessage, HttpStatus.OK);


    }

    //로그인
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public ResponseEntity<ApiResponseMessage> login(@Validated @RequestBody UserDTO userRequestDto){
        try{
            User responseUser=userService.login(userRequestDto);
            ApiResponseMessage apiResponseMessage=new ApiResponseMessage("SUCCESS","Login SUCCESS",responseUser);
            return new ResponseEntity<ApiResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            return null;

        }
    }

    //게시판
    @RequestMapping(value = "/board", method=RequestMethod.PUT)
    public void writeBoard(@RequestBody @Valid BoardDTO boardRequestDto) {
        boardService.insertService(boardRequestDto);

    }
}








