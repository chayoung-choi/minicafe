package com.eden.minicafe.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 회원 생성 요청 정보
 */
@Data
public class UserRegistrationData {
    @Email
    private String email;

    @NotBlank
    private String name;

    private String phone;

    @NotNull
    @Size(min = 8, max = 128)
    private String password;
}
