package com.eden.minicafe.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("TEA")
@Getter
@Setter
public class Tea extends Item {
    /**
     * 원산지
     */
    private String origin;
}
