package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDto {

    private Long itemId;

    private String name;

    private Integer price;

    private Category category;

    private Integer stock;
    /**
     * 원산지
     */
    private String origin;

    /**
     * 유통기한
     */
    private LocalDateTime shelfLifeDate;

}
