package com.eden.minicafe.dto;

import com.eden.minicafe.domain.Membership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 회원 응답 정보
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private Integer point;
    private Membership membership;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
