package com.eden.minicafe.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Drink")
@Getter
@Setter
public class Drink extends Item {
}
