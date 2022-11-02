package com.eden.minicafe.dto;

import com.eden.minicafe.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 회원 응답 정보
 */
@Getter
public class UserResponse {
  private Long id;
  private String email;
  private String name;
  private String phone;
  private Integer point;
  private String rank;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public UserResponse(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.name = user.getName();
    this.phone = user.getPhone();
    this.point = user.getPoint();
    this.rank = user.getRank();
    this.createdAt = user.getCreatedAt();
    this.updatedAt = user.getUpdatedAt();
  }
}
