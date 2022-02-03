package com.board.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//front로 전송할 메세지
public class ApiResponseMessage {
    private String status;
    private String message;

}
