package com.eden.minicafe.controller;

import com.eden.minicafe.domain.Order;
import com.eden.minicafe.dto.OrderRequest;
import com.eden.minicafe.dto.OrderResponse;
import com.eden.minicafe.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class OrderController {

  private final OrderService orderService;

  /**
   * 주문
   *
   * @param orderRequest 주문 정보
   * @return 주문 정보 id
   */
  @PostMapping("/orders")
  @ResponseStatus(HttpStatus.CREATED)
  Long order(@RequestBody OrderRequest orderRequest) {
    return orderService.order(orderRequest);
  }

  /**
   * 주문 조회
   *
   * @param orderId 주문 id
   * @return 주문 정보
   */
  @GetMapping("/orders/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  OrderResponse order(@PathVariable Long orderId) {
    Order order = orderService.getOrder(orderId);
    return new OrderResponse(order);
  }

  /**
   * 주문 확인 처리
   *
   * @param orderId 주문 id
   * @return 주문 id
   */
  @PostMapping("/orders/{orderId}/confirm")
  @ResponseStatus(HttpStatus.OK)
  Long confirmOrder(@PathVariable Long orderId) {
    orderService.confirmOrder(orderId);
    return orderId;
  }

  /**
   * 주문 취소
   *
   * @param orderId 주문 id
   * @return 주문 id
   */
  @PostMapping("/orders/{orderId}/cancel")
  @ResponseStatus(HttpStatus.OK)
  Long cancelOrder(@PathVariable Long orderId) {
    orderService.cancelOrder(orderId);
    return orderId;
  }

}

