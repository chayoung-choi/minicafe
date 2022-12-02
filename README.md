# Mini-Cafe

> SpringBoot & JPA 기반의 Mini-Cafe 기능을 구현한 프로젝트

## 프로젝트 환경

| #          | version |
|------------|---------|
| Java       | 17      |
| SpringBoot | 2.7.5   |
| Gradle     | 7.5.1   |

### Database H2 Start

```shell
sh /h2/bin/h2.sh
```

## API Dosc

http://localhost:8080/docs/index.html

### USERS : 사용자

`POST /users` : 회원 가입

`GET /users/{id}` : 회원 정보 조회

`POST /login` : 로그인

### ITEMS : 상품

`POST /items` : 상품 등록

`GET /items` : 상품 전체 조회

## 구현 기능

### 회원

- [X] 회원 가입
    - [X] email 중복 체크
- [X] 회원 정보 조회
- [X] 로그인
- [X] 회원 등급 enum으로 관리

### 주문

- [x] 주문 요청
    - [X] 주문 정보 등록과 상품 재고 변경
- [X] 주문 정보 조회
- [X] 주문 확인 상태 변경
- [X] 주문 취소 상태 변경
    - [X] 주문 취소에 따른 상품 재고 복원
- [X] 멤버십 등급에 따른 금액 할인

### 상품

- [X] 상품 등록
    - [X] 상품 이름 중복 체크
- [X] 상품 전체 조회

### 공통

- [X] Enum @Valid
