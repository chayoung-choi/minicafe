package com.eden.minicafe.exception;

public class NotEnoughStockException extends RuntimeException {
  public NotEnoughStockException(String message) {
    super(message);
  }
}
