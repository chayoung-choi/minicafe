package com.eden.minicafe.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 중복 예외
 */
@Slf4j
public class DuplicationException extends RuntimeException {
  public DuplicationException(String message) {
    super(message);
  }

  public DuplicationException(String key, String value) {
    super(key);
    log.warn(String.format("이미 사용중인 %s입니다. : %s", key, value));
  }
}
