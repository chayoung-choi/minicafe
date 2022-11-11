package com.eden.minicafe.service;

import com.eden.minicafe.domain.Item;
import com.eden.minicafe.domain.Order;
import com.eden.minicafe.domain.OrderItem;
import com.eden.minicafe.domain.User;
import com.eden.minicafe.dto.OrderRequest;
import com.eden.minicafe.exception.NotFoundException;
import com.eden.minicafe.repository.ItemRepository;
import com.eden.minicafe.repository.OrderRepository;
import com.eden.minicafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final UserRepository userRepository;
  private final ItemRepository itemRepository;

  /**
   * 주문
   *
   * @param orderRequest
   * @return 주문 id
   */
  @Transactional
  public Long order(OrderRequest orderRequest) {
    User user = userRepository.findById(orderRequest.getUserId()).orElseThrow(() -> new NotFoundException("회원"));
    Item item = itemRepository.findById(orderRequest.getItemId()).orElseThrow(() -> new NotFoundException("상품"));

    // 주문 상품 생성
    OrderItem orderItem = OrderItem.createOrderItem(item, orderRequest.getCount());

    // 주문 생성
    Order order = Order.createOrder(user, orderItem);
    orderRepository.save(order);
    return order.getId();
  }
}
