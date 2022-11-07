package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Category;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemResponse {
  private Long id;

  private String name;

  private Integer price;

  private Category category;

  private Integer stock;
}
