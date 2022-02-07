package com.board.controller;

import com.board.api.BoardInsertResponseMessage;
import com.board.api.BoardResponseMessage;
import com.board.api.UserResponseMessage;
import com.board.domain.Board;
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

import java.util.List;


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
    public ResponseEntity<UserResponseMessage> signup(@Validated @RequestBody UserDTO userRequestDto){
        //1.27
        userService.insertUser(userRequestDto);
        //상태코드(회원가입 성공한 경우)
        UserResponseMessage apiResponseMessage=new UserResponseMessage("SUCCESS","Signup SUCCESS",null);
        return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.OK);


    }

    //로그인
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public ResponseEntity<UserResponseMessage> login(@Validated @RequestBody UserDTO userRequestDto){
        try{
            User responseUser=userService.login(userRequestDto);
            UserResponseMessage apiResponseMessage=new UserResponseMessage("SUCCESS","Login SUCCESS",responseUser);
            return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            return null;

        }
    }

    //게시판
    @RequestMapping(value = "/board", method=RequestMethod.GET)
    public ResponseEntity<BoardResponseMessage> boardList() {
        List<BoardDTO> boardDTOList=boardService.findBoard();
        try{
            BoardResponseMessage apiResponseMessage=new BoardResponseMessage("SUCCESS","Board List SUCCESS",boardDTOList);
            return new ResponseEntity<BoardResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            return null;

        }

    }

    //게시판 글 작성
    @RequestMapping(value = "/board1", method=RequestMethod.PUT)
    public ResponseEntity<BoardInsertResponseMessage> boardList(@Validated @RequestBody BoardDTO boardRequestDto) {
        try{
            boardService.insertService(boardRequestDto);
            BoardInsertResponseMessage apiResponseMessage=new BoardInsertResponseMessage("SUCCESS","Board Insert SUCCESS",boardRequestDto);
            return new ResponseEntity<BoardInsertResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            return null;

        }

    }


}








