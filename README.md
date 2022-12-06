#  Spring Boot & Spring Security & JWT를 이용한 인가 처리 실습

## 📌 공식 문서

👉 Spring Security : https://docs.spring.io/spring-authorization-server/docs/current/reference/html/getting-started.html

👉 JWT : https://jwt.io/

<br />

<br />

## 📒 참고 자료

👉 스프링부트 핵심가이드 -스프링 부트를 활용한 애플리케이션 개발 실무- 

<br />

<br />



## 🛠 Dev Tool & Stack

- IntelliJ IDEA  2022.2.3
  - Spring Boot
  - JPA 
  - Spring Security
  - Spring Security Test
  - JWT
  - Lombok
  - MySQL Driver
- MySql 8.0
- Talend API Tester

<br />

<br />

## 💻 구현 기능

|                   기능                    |                             Note                             |       API Mapping        |  ex  |
| :---------------------------------------: | :----------------------------------------------------------: | :----------------------: | :--: |
|                 회원가입                  | [회원가입](https://github.com/Soyeong4250/spring-security-exercise/blob/master/note/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.md) | POST /api/v1/users/join  |      |
|                  로그인                   | [Login](https://github.com/Soyeong4250/spring-security-exercise/blob/master/note/Login.md) | POST /api/v1/users/login |      |
| JWT로 접근 권한 인증하기 (with 댓글 등록) | [JWT 권한 부여](https://github.com/Soyeong4250/spring-security-exercise/blob/master/note/JWT%EC%9D%B4%EC%9A%A9%ED%95%98%EA%B8%B0.md) |                          |      |
|                 댓글 등록                 | [Review 등록](https://github.com/Soyeong4250/spring-security-exercise/blob/master/note/Review%EB%93%B1%EB%A1%9D.md) |   POST /api/v1/reviews   |      |
