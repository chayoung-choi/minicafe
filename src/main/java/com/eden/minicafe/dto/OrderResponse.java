package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Order;
import com.eden.minicafe.domain.OrderStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderResponse {

  private Long orderId;

  private String userName;

  private List<OrderItemDto> orderItems;

  private LocalDateTime orderDate; // 주문시간

  private OrderStatus status; // 주문상태

  private Integer totalPrice;
  private Integer discountTotalPrice;

  public static OrderResponse of(Order order) {
    OrderResponse orderResponse = new OrderResponse();
    orderResponse.orderId = order.getId();
    orderResponse.userName = order.getUser().getName();
    orderResponse.orderItems = order.getOrderItems().stream()
        .map(OrderItemDto::new)
        .toList();
    orderResponse.orderDate = order.getOrderDate();
    orderResponse.status = order.getStatus();
    orderResponse.totalPrice = order.getTotalPrice();
    orderResponse.discountTotalPrice = order.getDiscountTotalPrice();
    return orderResponse;
  }
}
