package com.eden.minicafe.domain;

import lombok.AllArgsConstructor;

/**
 * 멤버십 등급
 */
@AllArgsConstructor
public enum Rank {
  BRONZE(0), SILVER(100), GOLD(500), DIAMOND(1000);

  private Integer point;

  Rank(int i) {

  }
}
