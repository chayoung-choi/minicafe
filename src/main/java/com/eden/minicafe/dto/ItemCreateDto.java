package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemCreateDto {


  @NotBlank
  private String name;

  @NotNull
  private Integer price;

  //  @Enum(enumClass = Category.class, ignoreCase = true)
  private Category category;

  private Integer stock;
}
