package com.eden.minicafe.exception;

import com.eden.minicafe.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * HTTP 요청 시 발생한 에러에 대한 응답을 담당합니다.
 */
@ResponseBody
@ControllerAdvice
public class ControllerExceptionAdvice {
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(UserEmailDuplicationException.class)
  public ErrorResponse handleUserEmailIsAlreadyExisted() {
    return new ErrorResponse("중복된 이메일입니다.");
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ErrorResponse handleNotFound() {
    return new ErrorResponse("요청 정보를 찾을 수 없습니다.");
  }

}
