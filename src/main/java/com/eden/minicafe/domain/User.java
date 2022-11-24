package com.eden.minicafe.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Email
  @Column(nullable = false, unique = true, length = 50)
  private String email;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(length = 20)
  private String phone;

  private Integer point;

  @Enumerated(EnumType.STRING)
  private Membership membership;

  private String password;

  @OneToMany(mappedBy = "user") // 읽기 전용 설정
  private List<Order> orders = new ArrayList<>();

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
    this.membership = Membership.BRONZE;
  }
}
