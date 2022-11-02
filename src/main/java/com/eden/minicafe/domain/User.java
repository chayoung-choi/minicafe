package com.eden.minicafe.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@ToString
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Email
  @Column(nullable = false, unique = true, length = 50)
  private String email;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(length = 20)
  private String phone;

  private Integer point;

  private String rank;

  private String password;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Builder
  public User(String email, String name, String phone, String password) {
    this.email = email;
    this.name = name;
    this.phone = phone;
    this.password = password;
    this.point = 0;
    this.rank = "silver";
  }
}
