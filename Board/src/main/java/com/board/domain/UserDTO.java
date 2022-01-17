package com.board.domain;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {
    private Long idx;
    private String userid;
    private String userpassword;
    private String username;
    private String useremail;
    private String signupTime;
}
