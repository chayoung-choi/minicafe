package com.eden.minicafe.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("FOOD")
@Getter
@Setter
public class Food extends Item {
    /**
     * 유통기한
     */
    private LocalDateTime shelfLifeDate;
}
