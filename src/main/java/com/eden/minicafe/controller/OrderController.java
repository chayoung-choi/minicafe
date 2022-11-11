package com.eden.minicafe.controller;

import com.eden.minicafe.dto.OrderRequest;
import com.eden.minicafe.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  /**
   * 주문
   *
   * @param orderRequest 주문 정보
   * @return 주문 정보 id
   */
  @PostMapping("")
  @ResponseStatus(HttpStatus.OK)
  Long order(@RequestBody OrderRequest orderRequest) {
    return orderService.order(orderRequest);
  }

}

