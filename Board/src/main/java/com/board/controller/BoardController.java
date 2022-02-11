package com.board.controller;

import com.board.api.*;
import com.board.dto.BoardDTO;
import com.board.service.BoardService;
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
public class BoardController {
    @Autowired //필드주입
    private BoardService boardService;

    //게시판
    @GetMapping(value = "/board")
    public ResponseEntity<BoardResponseMessage> boardList() {
        try{
            List<BoardDTO> boardDTOList=boardService.findBoard();
            BoardResponseMessage apiResponseMessage=new BoardResponseMessage("SUCCESS","Board List SUCCESS",boardDTOList);
            return new ResponseEntity<BoardResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            BoardResponseMessage apiResponseMessage=new BoardResponseMessage("FAILED","Board List FAILED",null);
            return new ResponseEntity<BoardResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    //게시판 글 작성
    @PutMapping(value = "/boardInsert")
    public ResponseEntity<BoardInsertResponseMessage> boardInsert(@Validated @RequestBody BoardDTO boardRequestDto) {
        try{
            boardService.insertService(boardRequestDto);
            BoardInsertResponseMessage apiResponseMessage=new BoardInsertResponseMessage("SUCCESS","Board Insert SUCCESS",boardRequestDto);
            return new ResponseEntity<BoardInsertResponseMessage>(apiResponseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            BoardInsertResponseMessage apiResponseMessage=new BoardInsertResponseMessage("FAILED","Board Insert FAILED",boardRequestDto);
            return new ResponseEntity<BoardInsertResponseMessage>(apiResponseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    //게시판 글 삭제
    @PostMapping(value = "/boardDelete")
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
    @PostMapping(value = "/boardUpdate")
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








