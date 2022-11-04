package com.eden.minicafe.application;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.domain.UserRepository;
import com.eden.minicafe.dto.UserRegistrationData;
import com.eden.minicafe.exception.NotFoundException;
import com.eden.minicafe.exception.UserEmailDuplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


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
   * @param id 회원 ID
   * @return 회원 정보
   */
  public User getUserById(Long id)  {
    return userRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("회원(%d)", id)));
  }
}
