package com.eden.minicafe.service;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.dto.UserData;
import com.eden.minicafe.dto.UserRegistrationData;
import com.eden.minicafe.exception.LoginFailException;
import com.eden.minicafe.exception.NotFoundException;
import com.eden.minicafe.exception.UserEmailDuplicationException;
import com.eden.minicafe.repository.UserRepository;
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
   * @param registrationData 등록 정보
   * @return 생성된 회원 정보
   */
  @Transactional
  public User registerUser(UserRegistrationData registrationData) {
    String email = registrationData.getEmail();
    if (userRepository.existsByEmail(email)) {
      throw new UserEmailDuplicationException(email);
    }

    return userRepository.save(
        User.builder()
            .email(email)
            .name(registrationData.getName())
            .phone(registrationData.getPhone())
            .password(registrationData.getPassword())
            .build());
  }

  /**
   * 회원 정보 조회
   *
   * @param id 회원 ID
   * @return 회원 정보
   */
  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("회원(%d)", id)));
  }

  /**
   * 회원 로그인
   *
   * @param userData 로그인 요청 정보
   * @return 회원 정보
   */
  public User login(UserData userData) {
    return userRepository.findByEmailAndPassword(userData.getEmail(), userData.getPassword())
        .orElseThrow(() -> new LoginFailException(userData.getEmail()));
  }
}
