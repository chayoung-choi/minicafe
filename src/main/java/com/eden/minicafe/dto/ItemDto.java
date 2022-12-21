package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Category;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
