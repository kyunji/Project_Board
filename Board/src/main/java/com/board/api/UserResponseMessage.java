package com.board.api;

import com.board.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//front로 전송할 메세지
public class UserResponseMessage {
    private String status;
    private String message;
    private UserDTO data;

}
