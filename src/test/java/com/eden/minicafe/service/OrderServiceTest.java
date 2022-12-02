package com.eden.minicafe.service;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.domain.item.Coffee;
import com.eden.minicafe.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class OrderServiceTest {

  @Autowired
  EntityManager em;

  @Autowired
  OrderService orderService;

  @Autowired
  OrderRepository orderRepository;

  @Test
  void 상품주문() {
    // given
    User user = createMember("회원1", "test@gmail.com");

    Coffee coffee = createCoffee(1500, "콜드브루", 100);

    // when
//    Long orderId = orderService.order(user, );

    // then
  }

  private User createMember(String name, String email) {
    User user = User.builder().name(name).email(email).build();
    em.persist(user);
    return user;
  }

  private Coffee createCoffee(int price, String name, int stockCount) {
    Coffee coffee = new Coffee();
    coffee.setName(name);
    coffee.setPrice(price);
    coffee.setStock(stockCount);
    em.persist(coffee);
    return coffee;
  }
}
