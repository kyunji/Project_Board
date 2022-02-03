package com.board.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalErrorController {

    @ExceptionHandler(value= SQLException.class)
    public ResponseEntity sqlException(Exception e){
        System.out.println(e.getClass().getName());
        /* if(e.getClass().getName().equals("org.springframework.dao.DuplicateKeyException"))
            System.out.println(e.getClass().getName());
        else
            System.out.println(e.getClass().getName()); */

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DuplicateKeyException");

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity argumentException(Exception e){
        System.out.println(e.getClass().getName());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("MethodArgumentNotValidException");

    }


}
