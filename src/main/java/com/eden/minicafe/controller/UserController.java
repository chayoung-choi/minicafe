package com.eden.minicafe.controller;

import com.eden.minicafe.application.UserService;
import com.eden.minicafe.domain.User;
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
@RequestMapping("/users")
public class UserController {

  private final UserService userService;


  /**
   * 회원 가입
   *
   * @param registrationData 회원 정보
   * @return 생성된 회원 정보
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  UserResponse create(@RequestBody @Valid UserRegistrationData registrationData) {
    User user = userService.registerUser(registrationData);
    log.info(user.toString());
    return new UserResponse(user);
  }


}

