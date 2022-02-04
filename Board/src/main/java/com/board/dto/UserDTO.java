package com.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
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