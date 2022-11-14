package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Order;
import com.eden.minicafe.domain.OrderStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderResponse {

  private Long orderId;

  private String userName;

  private List<OrderItemDto> orderItems;

  private LocalDateTime orderDate; // 주문시간

  private OrderStatus status; // 주문상태

  private Integer totalPrice;

  public OrderResponse(Order order) {
    this.orderId = order.getId();
    this.userName = order.getUser().getName();
    this.orderItems = order.getOrderItems().stream()
        .map(o -> new OrderItemDto(o))
        .collect(Collectors.toList());
    this.orderDate = order.getOrderDate();
    this.status = order.getStatus();
    this.totalPrice = order.getTotalPrice();
  }
}
