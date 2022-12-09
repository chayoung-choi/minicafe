package com.eden.minicafe.domain;

import com.eden.minicafe.domain.item.Coffee;
import com.eden.minicafe.domain.item.Item;
import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void createOrder() {
    User user = User.builder().build();
    Item coffee = new Coffee();
    coffee.setName("카테라떼");
    coffee.setPrice(4000);
    coffee.setStock(50);
//    OrderItem orderItem = OrderItem.createOrderItem(user, coffee);

  }

  @Test
  void addOrderItem() {
  }

  @Test
  void getTotalPrice() {
  }
}
