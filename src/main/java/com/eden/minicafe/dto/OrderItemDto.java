package com.eden.minicafe.dto;

import com.eden.minicafe.domain.OrderItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderItemDto {
  private Long orderItemId;

  private Long itemId;
  private String itemName;
  private int orderPrice;
  private int count;

  public OrderItemDto(OrderItem orderItem) {
    this.orderItemId = orderItem.getId();
    this.itemId = orderItem.getItem().getId();
    this.itemName = orderItem.getItem().getName();
    this.orderPrice = orderItem.getOrderPrice();
    this.count = orderItem.getCount();
  }
}
