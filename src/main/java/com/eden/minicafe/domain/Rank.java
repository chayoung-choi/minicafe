package com.eden.minicafe.domain;

import lombok.AllArgsConstructor;

/**
 * 멤버십 등급
 */
@AllArgsConstructor
public enum Rank {
  BRONZE(0), SILVER(100), GOLD(500), DIAMOND(1000);

  private Integer point;

  public static Rank of(int point) {
    Rank rank = Rank.SILVER;
    if (point <= Rank.BRONZE.point) {
      rank = Rank.BRONZE;
    } else if (point <= Rank.SILVER.point) {
      rank = Rank.SILVER;
    } else if (point <= Rank.GOLD.point) {
      rank = Rank.GOLD;
    } else if (point <= Rank.DIAMOND.point) {
      rank = Rank.DIAMOND;
    }
    return rank;
  }
}
