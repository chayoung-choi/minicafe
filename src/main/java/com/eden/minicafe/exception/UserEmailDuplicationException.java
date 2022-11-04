package com.eden.minicafe.exception;

/**
 * 회원 이메일 중복 예외
 */
public class UserEmailDuplicationException extends RuntimeException {
  public UserEmailDuplicationException(String email) {
    super("이미 사용중인 이메일입니다. : " + email);
  }
}
