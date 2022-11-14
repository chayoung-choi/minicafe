package com.eden.minicafe.exception;

import com.eden.minicafe.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.awt.*;

/**
 * HTTP 요청 시 발생한 에러에 대한 응답을 담당합니다.
 */
@ResponseBody
@ControllerAdvice
public class ControllerExceptionAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DuplicationException.class)
  public ErrorResponse handleDuplicationException(DuplicationException e) {
    return new ErrorResponse(String.format("이미 사용중인 %s입니다.", e.getMessage()));
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({IllegalArgumentException.class, IllegalComponentStateException.class, NotEnoughStockException.class,})
  public ErrorResponse handleNotEnoughStockException(Exception e) {
    return new ErrorResponse(e.getMessage());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ErrorResponse handleNotFoundException(NotFoundException e) {
    return new ErrorResponse(e.getMessage());
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(LoginFailException.class)
  public ErrorResponse handleLoginFailException() {
    return new ErrorResponse("Log-in failed");
  }
}
