package com.eden.minicafe.domain;

import lombok.AllArgsConstructor;

/**
 * 멤버십 등급
 */
@AllArgsConstructor
public enum Rank {
  BRONZE(0, 0), SILVER(100, 5), GOLD(500, 10), DIAMOND(1000, 20);

  private final Integer point; // 기준 포인트
  private final Integer rateOfDiscount; // 할인율

  public static Rank of(int point) {
    if (point >= Rank.DIAMOND.point) {
      return Rank.DIAMOND;
    } else if (point >= Rank.GOLD.point) {
      return Rank.GOLD;
    } else if (point >= Rank.SILVER.point) {
      return Rank.SILVER;
    } else {
      return Rank.BRONZE;
    }
  }
}
