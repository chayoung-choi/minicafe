package com.eden.minicafe.dto;

import com.eden.minicafe.domain.OrderStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 상품 주문 정보
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderDto {
    private Long userId;
    private List<OrderItemDto> orderItems;
    private LocalDateTime orderDate; // 주문시간
    private OrderStatus status; // 주문상태
    private Integer totalPrice; // 총 금액
    private Integer discountTotalPrice; // 할인된 총 금액
}
