package com.board.domain;
import lombok.*;

import java.time.LocalDateTime;

import static java.time.LocalTime.now;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long idx;
    private String userid;
    private String userpassword;
    private String username;
    private String useremail;
    private LocalDateTime signupTime;

    public UserDTO(String userid, String userpassword, String username, String useremail) {
        this.userid=userid;
        this.userpassword=userpassword;
        this.username=username;
        this.useremail=useremail;

    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idx=" + idx +
                ", userid='" + userid + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", signupTime='" + signupTime + '\'' +
                '}';
    }
}
