package com.eden.minicafe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderRequest {

  @NotNull
  @JsonProperty("user_id")
  private Long userId;

  @NotNull
  @JsonProperty("item_id")
  private Long itemId;

  @NotNull
  private Integer count;
  
}
