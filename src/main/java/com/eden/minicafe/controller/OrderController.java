package com.eden.minicafe.controller;

import com.eden.minicafe.dto.OrderDto;
import com.eden.minicafe.dto.OrderItemDto;
import com.eden.minicafe.service.OrderService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class OrderController {

    private final OrderService orderService;

    /**
     * 주문
     *
     * @param request 주문 정보
     * @return 주문 정보 id
     */
    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    Long order(@RequestBody OrderRequest request) {
        return orderService.order(request.getUserId(), request.getOrderItemsDto());
    }

    /**
     * 주문 조회
     *
     * @param orderId 주문 id
     * @return 주문 정보
     */
    @GetMapping("/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    OrderDto order(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
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

    @Data
    static class OrderRequest {
        @NotNull
        @JsonProperty("user_id")
        private Long userId;

        @NotNull
        @JsonProperty("order_items")
        private List<OrderItemDto> orderItemsDto;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

}

