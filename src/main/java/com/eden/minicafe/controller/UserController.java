package com.eden.minicafe.controller;

import com.eden.minicafe.application.UserService;
import com.eden.minicafe.domain.User;
import com.eden.minicafe.dto.UserData;
import com.eden.minicafe.dto.UserRegistrationData;
import com.eden.minicafe.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

  private final UserService userService;

  /**
   * 회원 가입
   *
   * @param registrationData 회원 정보
   * @return 생성된 회원 정보
   */
  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  UserResponse create(@RequestBody @Valid UserRegistrationData registrationData) {
    User user = userService.registerUser(registrationData);
    return new UserResponse(user);
  }

  /**
   * 회원 정보 조회
   *
   * @param id 회원 ID
   * @return 회원 정보
   */
  @GetMapping("/users/{id}")
  @ResponseStatus(HttpStatus.OK)
  UserResponse getUser(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return new UserResponse(user);
  }

  /**
   * 회원 로그인
   *
   * @param userData 회원 로그인 요청 정보
   * @return 회원 정보
   */
  @PostMapping(value = "/login")
  @ResponseStatus(HttpStatus.OK)
  UserResponse login(@RequestBody @Valid UserData userData) {
    User user = userService.login(userData);
    return new UserResponse(user);
  }
}

