package com.eden.minicafe.service;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.dto.UserData;
import com.eden.minicafe.exception.LoginFailException;
import com.eden.minicafe.exception.NotFoundException;
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
   * 회원 가입
   *
   * @param user
   * @return
   */
  @Transactional
  public Long join(User user) {
    validateDuplicateUser(user);
    userRepository.save(user);
    return user.getId();
  }

  /**
   * 중복 회원 검사
   *
   * @param user
   */
  private void validateDuplicateUser(User user) {
    String email = user.getEmail();
    if (userRepository.existsByEmail(email)) {
      throw new IllegalStateException("이미 존재하는 이메일입니다. : ".concat(user.getEmail()));
    }
  }

  /**
   * 회원 정보 조회
   *
   * @param id 회원 ID
   * @return 회원 정보
   */
  public User findById(Long id) {
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
