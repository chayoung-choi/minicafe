package com.eden.minicafe.controller;

import com.eden.minicafe.dto.UserDto;
import com.eden.minicafe.dto.UserJoinData;
import com.eden.minicafe.dto.UserLoginData;
import com.eden.minicafe.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    /**
     * 회원 가입
     *
     * @param request 회원 정보
     * @return 생성된 회원 정보
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    Long create(final @RequestBody UserJoinData request) {
        return userService.join(request);
    }

    /**
     * 회원 정보 조회
     *
     * @param id 회원 ID
     * @return 회원 정보
     */
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * 회원 로그인
     *
     * @param userLoginData 회원 로그인 요청 정보
     * @return 회원 정보
     */
    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    UserDto login(@RequestBody UserLoginData userLoginData) {
        return userService.login(userLoginData);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }
}

