# Mini-Cafe

> SpringBoot & JPA 기반의 Mini-Cafe 기능을 구현한 프로젝트

## 프로젝트 환경

| #          | version |
|------------|---------|
| Java       | 17      |
| SpringBoot | 2.7.5   |
| Gradle     | 7.5.1   |

## API Dosc

http://localhost:8080/docs/index.html

### USERS : 사용자

`POST /users` : 회원 가입

`GET /users/{id}` : 회원 정보 조회

`POST /login` : 로그인

### ITEMS : 상품

`GET /items` : 상품 전체 조회

`POST /items` : 상품 등록

## TO-DO

- [ ] 회원 가입, 회원 정보 조회, 로그인
- [ ] 상품 등록, 상품 전체 조회
- [ ] Enum @Valid