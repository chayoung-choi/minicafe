package com.eden.minicafe.exception;



/**
 * 요청 정보를 찾을 수 없을 때 예외
 */
public class NotFoundException extends RuntimeException {
  public NotFoundException(String target) {
    super(String.format("찾을 수 없는 %s입니다.", target));
  }
}
