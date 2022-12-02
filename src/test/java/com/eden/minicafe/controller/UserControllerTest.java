package com.eden.minicafe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {
  static Map<String, String> user = new HashMap<>();
  @Autowired
  private MockMvc mvc;
  @Autowired
  private ObjectMapper objectMapper;

  @BeforeAll
  static void setUp() {
    user.put("email", "test@gmail.com");
    user.put("name", "테스트");
    user.put("password", "test1234");
  }

  @Test
  @Order(1)
  @DisplayName("회원 가입")
  void sign_up() throws Exception {

    user.put("email", "test2@gmail.com");

    mvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.email").exists())
        .andDo(document("create-users"));
  }

  @Test
  @Order(2)
  @DisplayName("중복 회원 가입이면, BadRequest")
  void sign_up_duplicate() throws Exception {
    mvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isBadRequest());
  }

  @Test
  @Order(3)
  @DisplayName("로그인")
  void login() throws Exception {
    mvc.perform(post("/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.email").exists())
        .andDo(document("login"));
  }

  @Test
  @Order(4)
  @DisplayName("비밀번호 오류이면, LoginFailException")
  void login_fail() throws Exception {
    user.put("password", "test");

    mvc.perform(post("/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isUnauthorized())
        .andDo(document("login"));
  }

  @Order(5)
  @ParameterizedTest
  @CsvSource({"test@gmail.com, ", " ,test", "noemail,test"})
  @DisplayName("로그인 필수값 오류면, BadRequest")
  void login_bad_request(String email, String password) throws Exception {
    Map<String, String> userDto = new HashMap<>();
    userDto.put("email", email);
    userDto.put("password", password);

    mvc.perform(post("/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userDto)))
        .andExpect(status().isBadRequest())
        .andDo(document("login"));
  }

  @Test
  void test() throws Exception {
    String url = new DefaultUriBuilderFactory().builder()
        .path("http://qamos20.daekyo.co.kr:6040/SMOSMGR/api/cuMbrTerms/history.do?zlogin_id=31178978&kunnr=0051856789")
        .build().toString();

    DefaultUriBuilderFactory uriBuilder = new DefaultUriBuilderFactory(url);

    mvc.perform(get("http://qamos20.daekyo.co.kr:6040/SMOSMGR/api/cuMbrTerms/history.do?zlogin_id=31178978&kunnr=0051856789")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());
  }
}
