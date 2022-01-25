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
    private String id;
    private String password;//카멜케이스
    private String name;
    private String email;
    private LocalDateTime signupTime;

    public UserDTO(String id, String password, String name, String email) {
        this.id=id;
        this.password=password;
        this.name=name;
        this.email=email;

    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idx=" + idx +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", signupTime=" + signupTime +
                '}';
    }
}
