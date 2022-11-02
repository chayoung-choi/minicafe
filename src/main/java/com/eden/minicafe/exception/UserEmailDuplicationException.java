package com.eden.minicafe.exception;

/**
 * 회원 이메일 중복 예외
 */
public class UserEmailDuplicationException extends RuntimeException {
  public UserEmailDuplicationException(String email) {
    super("User email is already existed: " + email);
  }
}
