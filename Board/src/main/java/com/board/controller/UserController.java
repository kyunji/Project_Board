package com.board.controller;

import com.board.api.*;
import com.board.dto.UserDTO;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLIntegrityConstraintViolationException;

//vue 포트
@CrossOrigin(origins="http://localhost:8081")
@RestController // JSON 형태의 객체 return
public class UserController {
    @Autowired //필드주입
    private UserService userService;

     @RequestMapping(value = "/")
    public void home(){
        System.out.println("home");
    }

    //회원가입
    @RequestMapping(value = "/signup", method=RequestMethod.PUT)
    public ResponseEntity<UserResponseMessage> signup(@Validated @RequestBody UserDTO userRequestDto){
         userService.insertUser(userRequestDto);
        UserResponseMessage apiResponseMessage=new UserResponseMessage("SUCCESS","Signup SUCCESS",null);
        return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.OK);
    }

    //로그인
    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseMessage> login(@Validated @RequestBody UserDTO userRequestDto){
        try{
            UserDTO responseUser=userService.login(userRequestDto);
            UserResponseMessage apiResponseMessage=new UserResponseMessage("SUCCESS","Login SUCCESS",responseUser);
            return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            UserResponseMessage apiResponseMessage=new UserResponseMessage("FAIL","Login FAILED",null);
            return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(value= SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<UserResponseMessage> SQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
        UserResponseMessage apiResponseMessage=new UserResponseMessage("FAILED",e.getMessage(),null);
        return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<UserResponseMessage> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        UserResponseMessage apiResponseMessage=new UserResponseMessage("FAILED",e.getBindingResult().getAllErrors().get(0).getDefaultMessage(),null);
        return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
    }


}








