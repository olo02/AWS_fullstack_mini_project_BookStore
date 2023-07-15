# 온라인 서점, 잘라딘 - Java/CLI

<div align="center">
<img width="500" alt="image" src="https://github.com/olo02/olo02/assets/121186383/523dc5a3-e646-4279-8133-56c70d01fefc">

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Folo02%2FAWS_fullstack_mini_project_BookStore&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

<br>

**AWS 풀스택 개발자 양성과정 미니 프로젝트** <br/>
**개발기간: 2022.02.06 ~ 2022.02.15**

</div>

---

## 프로젝트 소개

AWS 풀스택 개발자 과정 한 달 차에 Java 내용 복습을 위해 미니프로젝트로 작업하였습니다.
사용자 인터페이스가 갖춰야할 기능인 CRUD를 효과적으로 구현할 수 있는 주제를 선정하고자 하였고, 그 중 평소에 친숙하게 사용하였던 인터넷 서점관리시스템을 선택하게 되었습니다.

Kakao Rest API를 활용하여 도서 더미데이터를 구축하였습니다.

객체지향 프로그래밍에 대한 이해와 Java를 통해 기본적인 CRUD 기능을 구현하는 것을 목표로 하여 프로젝트를 진행하였습니다.

---

## 시작 가이드

### Requirements

For building and running the application you need:

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) (Java 1.8 이상)

- 데이터 크롤링
  - Gson 2.8.9 이상
  - [Kakao 검색 API](https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide) : 인증키 필요

### Installation

```bash
$ git clone https://github.com/olo02/AWS_fullstack_mini_project_BookStore.git
```

### Dummy data

```
회원 정보

1. 일반 회원
    id : ycy
    pw : 1234
2. 출판사 회원
    id : wisdom
    pw : 1234
3. 관리자 회원
    id : admin
    pw : 1234
```

---

## Stacks

### Environment

<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=Eclipse IDE&logoColor=white">
<img src="https://img.shields.io/badge/subversion-809CC9?style=for-the-badge&logo=subversion&logoColor=white">


### Development

 <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">

---

## 프로젝트 구성

<div align="center">

|                                                   회원가입                                                    |                                                    로그인                                                     |
| :-----------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------: |
| <img width="500" src="https://github.com/olo02/olo02/assets/121186383/2b0bcde2-7e8a-448b-9e58-557a3f9a5f86"/> | <img width="500" src="https://github.com/olo02/olo02/assets/121186383/50d54799-5941-4e84-8eb5-77a2965d3235"/> |
|                                                    책 검색                                                    |                                                     주문                                                      |
| <img width="500" src="https://github.com/olo02/olo02/assets/121186383/866f3c09-def4-4e77-91b8-68a367cb6163"/> | <img width="500" src="https://github.com/olo02/olo02/assets/121186383/9dc7e902-bac5-4117-91b1-8db1532191ea"/> |

</div>

---

## 기능

> [x] 작업완료 [ ] 작업예정

### ⭐️ 회원가입

- [x] 일반회원, 출판사 회원가입 구분
- [x] 일반회원 : id, pw, 이름, email, 주소, 연락처를 입력하여 회원가입
- [x] 출판사 : id, pw, 이름, 사업자등록번호 13자리를 입력하여 회원가입
- [x] id 중복 검사

### ⭐️ 로그인

- [x] 일반회원, 출판사 로그인 구분

### ⭐️ 도서 검색

- [x] 책 제목, 작가, isbn 코드를 통해 검색
- [x] 검색 결과 8개씩 페이지네이션

### ⭐️ 도서 관리

- 출판사
  - [x] isbn 코드로 해당 출판사의 도서 상품 신청
  - [x] isbn 코드 중복 검사
  - [x] isbn 코드로 해당 출판사의 도서 상품 수정
- 관리자
  - [x] 출판사가 신청한 상품 목록 확인
  - [x] 추천도서 선정 및 해제

### ⭐️ 장바구니

- [x] 선택한 도서 장바구니에 담기
- [ ] 장바구니에 담긴 도서 삭제

### ⭐️ 도서 구매

- [x] 장바구니에 담긴 도서 구매하기

### ⭐️ 주문 관리

- 관리자
  - [ ] 모든 회원의 주문 내역 확인

---

## 아키텍쳐

### 디렉토리 구조

```bash
├── README.md
├── src/team1
│   ├── dataCrawling : 데이터 크롤링
│   │   └── KakaoDataCrawling.java : 전체 프로젝트 실행시 주석 요
│   ├── exception : 예외 처리
│   │   ├── BookRangeException.java
│   │   ├── BookStoreException.java
│   │   ├── IdException.java
│   │   ├── IsbnException.java
│   │   ├── MyrangeException.java
│   │   └── RequiredInputException.java
│   ├── service : 서비스
│   │   ├── impl : 서비스 구현체
│   │   ├── AdminService.java
│   │   ├── BookService.java
│   │   ├── BookStoreService.java
│   │   ├── CustomerService.java
│   │   ├── MemberService.java
│   │   ├── PaymentService.java
│   │   └── PublisherService.java
│   ├── utils
│   │   └── BookStoreUtils.java : 콘솔창 스캐너
│   ├── vo : Value Object
│   │   ├── Admin.java
│   │   ├── Book.java
│   │   ├── Buy.java
│   │   ├── Call.java
│   │   ├── Cart.java
│   │   ├── Customer.java
│   │   ├── Member.java
│   │   ├── Order.java
│   │   ├── Payment.java
│   │   ├── PaymentStatus.java
│   │   └── Publisher.java
│   └── BookStoreEx.java : 프로젝트 실행 main
├── .gitignore
├── admins.ser : 관리자 데이터
├── book.ser : 책 데이터
├── customer.ser : 일반 회원 데이터
└── publisher.ser : 출판사 데이터

```

---

## 개발팀 소개

<div align="center">

|                                      박한솔                                      |                                       양찬용                                       |                                                               천은경                                                               |
| :------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------: |
| <img width="160px" src="https://avatars.githubusercontent.com/u/79947860?v=4" /> | <img height="160px" src="https://avatars.githubusercontent.com/u/128908315?v=4" /> | <img height="160px" src="https://user-images.githubusercontent.com/121186383/242636171-4e873ee3-bb3e-4961-806a-2f960c7210d1.jpg"/> |
|                     [@hsnachos](https://github.com/hsnachos)                     |                  [@yangchanyong](https://github.com/yangchanyong)                  |                                                 [@olo02](https://github.com/olo02)                                                 |
|                       - 장바구니 서비스 <br> - 구매 서비스                       |                                   - 회원 서비스                                    |                                              - 도서 데이터 크롤링 <br> - 도서 서비스                                               |

</div>

<br>

---

## 프로젝트 후기

> 첫 프로젝트인 만큼 설계와 구현 과정이 흥미로웠습니다. 특히 검색을 구현할 때, 검색어와 검색 결과의 관계 및 페이징 처리에서 이것저것 시도하는 과정이 즐거웠습니다. 그러나 미숙한 경험으로 인해 계획대로 구현하지 못한 부분과 콘솔창에서 구현해야 하는 한계가 아쉬웠습니다. 또 구현 과정 중 객체 지향 개념과 코드의 재사용을 활용하는 부분에서 가장 노력했지만 여전히 중복된 코드가 많았던 점이 아쉽습니다.

<br>

---

## References

참고 사이트 : [Aladin 서점](https://www.aladin.co.kr/home/welcome.aspx)
<br> 데이터 크롤링 : [Kakao 도서 검색](https://www.aladin.co.kr/home/welcome.aspx)
<br> README Template : [parkjiye](https://velog.io/@luna7182/%EB%B0%B1%EC%97%94%EB%93%9C-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-README-%EC%93%B0%EB%8A%94-%EB%B2%95)
<br> Hit : [hit](https://hits.seeyoufarm.com/)
