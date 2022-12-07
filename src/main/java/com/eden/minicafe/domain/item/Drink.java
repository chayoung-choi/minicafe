package com.eden.minicafe.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@DiscriminatorValue("DRINK")
@Getter
@Setter
public class Drink extends Item {
}
