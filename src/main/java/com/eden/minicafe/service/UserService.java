package com.eden.minicafe.service;

import com.eden.minicafe.domain.User;
import com.eden.minicafe.dto.UserDto;
import com.eden.minicafe.dto.UserJoinData;
import com.eden.minicafe.dto.UserLoginData;
import com.eden.minicafe.exception.DuplicationException;
import com.eden.minicafe.exception.LoginFailException;
import com.eden.minicafe.exception.NotFoundException;
import com.eden.minicafe.mapper.UserMapper;
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
     * @param request
     * @return
     */
    @Transactional
    public Long join(UserJoinData request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .phone(request.getPhone())
                .build();

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
            throw new DuplicationException("이미 존재하는 이메일입니다. : ".concat(user.getEmail()));
        }
    }

    /**
     * 회원 정보 조회
     *
     * @param id 회원 ID
     * @return 회원 정보
     */
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("회원(%d)", id)));
        return UserMapper.INSTANCE.toDto(user);
    }

    /**
     * 회원 로그인
     *
     * @param userLoginData 로그인 요청 정보
     * @return 회원 정보
     */
    public UserDto login(UserLoginData userLoginData) {
        User user = userRepository.findByEmailAndPassword(userLoginData.getEmail(), userLoginData.getPassword())
                .orElseThrow(() -> new LoginFailException(userLoginData.getEmail()));
        return UserMapper.INSTANCE.toDto(user);
    }
}
