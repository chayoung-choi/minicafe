package com.eden.minicafe.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * 회원 로그인 요청 정보
 */
@Data
public class UserData {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
