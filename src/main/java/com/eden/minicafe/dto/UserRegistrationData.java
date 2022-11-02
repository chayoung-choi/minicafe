package com.eden.minicafe.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 회원 생성 요청 정보
 */
@Data
public class UserRegistrationData {
  private String email;

  @NotBlank
  private String name;

  private String phone;

  @NotNull
  @Size(min = 8, max = 128)
  private String password;
}
