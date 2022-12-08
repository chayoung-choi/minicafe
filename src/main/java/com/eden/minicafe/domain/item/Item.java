package com.eden.minicafe.domain.item;

import com.eden.minicafe.domain.BaseTime;
import com.eden.minicafe.domain.Category;
import com.eden.minicafe.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.*;


/**
 * 상품 정보
 */
@ToString
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category")
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Item extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    @Column(columnDefinition = "integer default 0")
    private Integer stock;


    @Enumerated(EnumType.STRING)
    @Column(name = "category", insertable = false, updatable = false)
    private Category category;

    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stock += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stock - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.");
        }
        this.stock = restStock;
    }
}
