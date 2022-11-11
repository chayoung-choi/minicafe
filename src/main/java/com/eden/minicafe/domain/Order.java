package com.eden.minicafe.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * 상품 주문 정보
 */
@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Order extends BaseTime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  @Column(name = "order_date")
  private LocalDateTime orderDate; // 주문시간

  @Enumerated(EnumType.STRING)
  private OrderStatus status; // 주문상태

  public static Order createOrder(User user, OrderItem... orderItems) {
    Order order = new Order();
    order.setUser(user);
    for (OrderItem orderItem : orderItems) {
      order.addOrderItem(orderItem);
    }
    order.setStatus(OrderStatus.ORDER);
    order.setOrderDate(LocalDateTime.now());
    return order;
  }

  public void setUser(User user) {
    this.user = user;
    user.getOrders().add(this);
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }

  public int getTotalPrice() {
    int totalPrice = 0;
    for (OrderItem orderItem : orderItems) {
      totalPrice += orderItem.getTotalPrice();
    }
    return totalPrice;
  }
}
