package com.eden.minicafe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderRequest {

  @NotNull
  @JsonProperty("user_id")
  private Long userId;

  @NotNull
  @JsonProperty("order_items")
  private List<OrderItemDto> orderItems;

}
