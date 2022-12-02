package com.eden.minicafe.service;

import com.eden.minicafe.domain.Order;
import com.eden.minicafe.domain.OrderItem;
import com.eden.minicafe.domain.User;
import com.eden.minicafe.domain.item.Item;
import com.eden.minicafe.exception.NotFoundException;
import com.eden.minicafe.repository.ItemRepository;
import com.eden.minicafe.repository.OrderRepository;
import com.eden.minicafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
   */
  @Transactional
  public Long order(Long userId, List<OrderItem> orderItems) {
    User user = userRepository.findById(userId).get();

//    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.forEach(oi -> {
      Item item = itemRepository.findById(oi.getId()).orElseThrow(() -> new NotFoundException("상품"));

      // 주문 상품 생성
      OrderItem orderItem = OrderItem.createOrderItem(item, oi.getCount());
      orderItems.add(orderItem);
    });


    // 주문 생성
    Order order = Order.createOrder(user, orderItems.toArray(new OrderItem[orderItems.size()]));
    orderRepository.save(order);
    return order.getId();
  }

  /**
   * 주문 취소
   *
   * @param orderId
   */
  @Transactional
  public void cancelOrder(Long orderId) {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("주문 정보"));
    order.cancel();
  }

  /**
   * 주문 정보 조회
   *
   * @param orderId
   * @return Order
   */
  public Order getOrder(Long orderId) {
    return orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("주문 정보"));
  }

  @Transactional
  public void confirmOrder(Long orderId) {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("주문 정보"));
    order.confirm();
  }
}
