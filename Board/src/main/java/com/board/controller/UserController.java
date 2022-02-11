package com.board.controller;

import com.board.api.*;
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
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
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
    }

    //회원가입   원래는 /signup
    @RequestMapping(value = "/signup", method=RequestMethod.PUT)
    public ResponseEntity<UserResponseMessage> signup(@Validated @RequestBody UserDTO userRequestDto){
         userService.insertUser(userRequestDto);
         //상태코드(회원가입 성공한 경우)
        UserResponseMessage apiResponseMessage=new UserResponseMessage("SUCCESS","Signup SUCCESS",null);
        return new ResponseEntity<UserResponseMessage>(apiResponseMessage, HttpStatus.OK);
    }

    //로그인
    @RequestMapping(value = "/login", method=RequestMethod.POST)
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

    //게시판
    @RequestMapping(value = "/board", method=RequestMethod.GET)
    public ResponseEntity<BoardResponseMessage> boardList() {
        List<BoardDTO> boardDTOList=boardService.findBoard();
        try{
            BoardResponseMessage apiResponseMessage=new BoardResponseMessage("SUCCESS","Board List SUCCESS",boardDTOList);
            return new ResponseEntity<BoardResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            BoardResponseMessage apiResponseMessage=new BoardResponseMessage("FAILED","Board List FAILED",boardDTOList);
            return new ResponseEntity<BoardResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
        }

    }

    //게시판 글 작성
    @RequestMapping(value = "/boardInsert", method=RequestMethod.PUT)
    public ResponseEntity<BoardInsertResponseMessage> boardInsert(@Validated @RequestBody BoardDTO boardRequestDto) {
        try{
            boardService.insertService(boardRequestDto);
            BoardInsertResponseMessage apiResponseMessage=new BoardInsertResponseMessage("SUCCESS","Board Insert SUCCESS",boardRequestDto);

            String[] content=boardRequestDto.getContent().split("\\s");
            System.out.println(content);

            return new ResponseEntity<BoardInsertResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            BoardInsertResponseMessage apiResponseMessage=new BoardInsertResponseMessage("FAILED","Board Insert FAILED",boardRequestDto);
            return new ResponseEntity<BoardInsertResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
        }

    }

    //게시판 글 삭제
    @RequestMapping(value = "/boardDelete", method=RequestMethod.POST)
    public ResponseEntity<BoardDeleteResponseMessage> boardDelete(@Validated @RequestBody BoardDTO boardRequestDto) {
        try{
            boardService.deleteBoard(boardRequestDto);
            BoardDeleteResponseMessage apiResponseMessage=new BoardDeleteResponseMessage("SUCCESS","Board Delete SUCCESS");
            return new ResponseEntity<BoardDeleteResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            BoardDeleteResponseMessage apiResponseMessage=new BoardDeleteResponseMessage("FAILED","Board Delete FAILED");
            return new ResponseEntity<BoardDeleteResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);

        }

    }

    //게시판 글 수정
    @RequestMapping(value = "/boardUpdate", method=RequestMethod.POST)
    public ResponseEntity<BoardUpdateResponseMessage> boardUpdate(@Validated @RequestBody BoardDTO boardRequestDto) {
        try{
            boardService.updateBoard(boardRequestDto);
            BoardUpdateResponseMessage apiResponseMessage=new BoardUpdateResponseMessage("SUCCESS","Board Update SUCCESS", boardRequestDto);
            return new ResponseEntity<BoardUpdateResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            BoardUpdateResponseMessage apiResponseMessage=new BoardUpdateResponseMessage("FAILED","Board Update FAILED", boardRequestDto);
            return new ResponseEntity<BoardUpdateResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
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








