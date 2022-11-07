package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Category;
import lombok.Data;

@Data
public class ItemDto {

  private Long itemId;

  private String name;

  private Integer price;

  private Category category;

  private Integer stock;
}
