package com.eden.minicafe.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
