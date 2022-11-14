package com.eden.minicafe.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Food")
@Getter
@Setter
public class Food extends Item {
  /**
   * 유통기한
   */
  private LocalDateTime shelfLifeDate;
}
