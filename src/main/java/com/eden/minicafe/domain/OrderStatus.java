package com.eden.minicafe.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {
  ORDER("주문"), CONFIRM("주문확인"), COMPLETION("제조완료"), PICKUP("픽업"), CANCEL("작업완료");

  private String stateName;
}
