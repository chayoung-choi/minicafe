package com.eden.minicafe.domain;

import lombok.*;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_item_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  private int orderPrice; // 주문 가격
  private int count; // 주문 수량

  /**
   * 주문 생성
   */
  public static OrderItem createOrderItem(Item item, int count) {
    OrderItem orderItem = OrderItem.builder().item(item).orderPrice(item.getPrice()).count(count).build();
    item.removeStock(count);
    return orderItem;
  }

  /**
   * 주문 취소
   */
  public void cancel() {
    getItem().addStock(count);
  }

  /**
   * 주문상품 전체 가격 조회
   */
  public int getTotalPrice() {
    return getOrderPrice() * getCount();
  }
}
