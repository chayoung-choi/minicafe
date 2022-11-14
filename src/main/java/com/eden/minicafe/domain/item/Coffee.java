package com.eden.minicafe.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Coffee")
@Getter
@Setter
public class Coffee extends Item {
  /**
   * 원산지
   */
  private String origin;
}
