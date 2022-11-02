package com.eden.minicafe.application;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.domain.UserRepository;
import com.eden.minicafe.dto.UserRegistrationData;
import com.eden.minicafe.exception.UserEmailDuplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 회원에 관한 비즈니스 로직
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  /**
   * 회원 등록
   *
   * @param registrationData
   * @return 생성된 회원 정보
   */
  public User registerUser(UserRegistrationData registrationData) {
    String email = registrationData.getEmail();
    if (userRepository.existsByEmail(email)) {
      throw new UserEmailDuplicationException(email);
    }

    User user = userRepository.save(
            User.builder()
                    .email(email)
                    .name(registrationData.getName())
                    .phone(registrationData.getPhone())
                    .password(registrationData.getPassword())
                    .build());
    return user;
  }
}
