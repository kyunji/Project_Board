package com.board.domain;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static java.time.LocalTime.now;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private Long idx;
    @NotBlank
    @Size(min=1, max = 20)
    private String id;
    @NotBlank
    @Size(min=1, max = 20)
    private String password;//카멜케이스
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private LocalDateTime signupTime;

    @Builder
    public User(String id, String password, String name, String email) {
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