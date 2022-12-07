package com.eden.minicafe.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@DiscriminatorValue("COFFEE")
@Getter
@Setter
public class Coffee extends Item {
    /**
     * 원산지
     */
    private String origin;
}
