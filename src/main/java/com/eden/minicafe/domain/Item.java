package com.eden.minicafe.domain;

import com.eden.minicafe.exception.NotEnoughStockException;
import lombok.*;

import javax.persistence.*;

/**
 * 상품 정보
 */
@ToString
@Getter
//@Setter
@Entity
@Table(name = "items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_id")
  private Long id;

  private String name;

  private Integer price;

  @Enumerated(EnumType.STRING)
  private Category category;

  @Column(columnDefinition = "integer default 0")
  private Integer stock;

  @Builder
  public Item(String name, Integer price, Category category, Integer stock) {
    this.name = name;
    this.price = price;
    this.category = category;
    this.stock = stock;
  }

  /**
   * stock 증가
   */
  public void addStock(int quantity) {
    this.stock += quantity;
  }


  /**
   * stock 감소
   */
  public void removeStock(int quantity) {
    int restStock = this.stock - quantity;
    if (restStock < 0) {
      throw new NotEnoughStockException("재고가 부족합니다.");
    }
    this.stock = restStock;
  }
}
