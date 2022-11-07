package com.eden.minicafe.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
