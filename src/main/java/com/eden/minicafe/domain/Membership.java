package com.eden.minicafe.domain;

import lombok.AllArgsConstructor;

/**
 * 멤버십 등급
 */
@AllArgsConstructor
public enum Membership {
  BRONZE(0, 0), SILVER(100, 5), GOLD(500, 10), DIAMOND(1000, 20);

  private final Integer point; // 기준 포인트
  private final Integer rateOfDiscount; // 할인율

  public static Membership of(int point) {
    if (point >= Membership.DIAMOND.point) {
      return Membership.DIAMOND;
    } else if (point >= Membership.GOLD.point) {
      return Membership.GOLD;
    } else if (point >= Membership.SILVER.point) {
      return Membership.SILVER;
    } else {
      return Membership.BRONZE;
    }
  }

  /**
   * 멤버쉽별 할인된 총 금액 구하기
   */
  public int calculateDiscountTotalPrice(int totalPrice) {
    return totalPrice * (100 - rateOfDiscount) / 100;
  }
}
