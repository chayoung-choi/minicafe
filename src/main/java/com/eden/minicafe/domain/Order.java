package com.eden.minicafe.domain;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 상품 주문 정보
 */
@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "order_date")
    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태

    private Integer discountTotalPrice; // 할인된 총 금액

    /**
     * 주문 생성
     */
    public static Order createOrder(User user, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setUser(user);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());

        int discountTotalPrice = user.getMembership().calculateDiscountTotalPrice(order.getTotalPrice());
        order.setDiscountTotalPrice(discountTotalPrice);
        return order;
    }

    public void setUser(User user) {
        this.user = user;
        user.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    /**
     * 주문 상품 전체 가격 조회
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }

    /**
     * 주문 취소
     */
    public void cancel() {
        switch (status) {
            case CONFIRM -> throw new IllegalStateException("이미 제조가 시작된 주문은 취소가 불가능합니다.");
            case COMPLETION -> throw new IllegalStateException("이미 제조가 완료된 주문은 취소가 불가능합니다.");
            case PICKUP -> throw new IllegalStateException("취소가 불가능합니다.");
            case CANCEL -> throw new IllegalStateException("이미 취소된 주문입니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        orderItems.stream().forEach(OrderItem::cancel);
    }

    /**
     * 주문 확인
     */
    public void confirm() {
        if (status != OrderStatus.ORDER) {
            throw new IllegalComponentStateException("잘못된 요청입니다.");
        }

        this.setStatus(OrderStatus.CONFIRM);
    }
}
