package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Category;
import com.eden.minicafe.domain.item.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDto {

  private Long itemId;

  private String name;

  private Integer price;

  private Category category;

  private Integer stock;
  /**
   * 원산지
   */
  private String origin;

  /**
   * 유통기한
   */
  private LocalDateTime shelfLifeDate;

  public Item toEntity() {
    switch (category) {
      case COFFEE: {
        Coffee coffee = new Coffee();
        coffee.setId(itemId);
        coffee.setName(name);
        coffee.setStock(stock);
        coffee.setOrigin(origin);
        return coffee;
      }
      case DRINK: {
        Drink drink = new Drink();
        drink.setId(itemId);
        drink.setName(name);
        drink.setStock(stock);
        return drink;
      }
      case TEA: {
        Tea tea = new Tea();
        tea.setId(itemId);
        tea.setName(name);
        tea.setStock(stock);
        tea.setOrigin(origin);
        return tea;
      }
      case FOOD: {
        Food food = new Food();
        food.setId(itemId);
        food.setName(name);
        food.setStock(stock);
        food.setShelfLifeDate(shelfLifeDate);
        return food;
      }
    }
    throw new IllegalArgumentException("카테고리를 확인해주세요.");
  }
}
