# 🪧 Project Board


##  프로젝트 목적 
* Spring Data Jpa 활용
* MockMvc를 이용한 API 테스트
* Rest-Docs를 이용한 API 문서화 


## ✔️ 기술 스택
* Spring Data Jpa
* H2 database
* RestDocs

<br>

### ✔️ 패키지 구성
* common
* controller
* converter
* domain
  * post
    * vo
  * user
    * vo
* dto
  * post
  * user
* exception - (미완성)
* repository
* service

<br>

### ✔️ API 구현

- 게시글 조회
    - 페이징 조회 (GET "/api/v1/posts")
    - 단건 조회 (GET "/api/v1/posts/{id}")
    - 유저 게시글 조회(GET "/api/v1/posts/user/{id}")
- 게시글 작성 (POST "/api/v1/posts")
- 게시글 수정 (PUT "/api/v1/posts")
- 게시글 삭제 (DELETE "/api/v1/posts/{id}")


- 유저 조회
  - 페이징 조회 (GET "/api/v1/users")
  - 단건 조회 (GET "/api/v1/users/{id}")
- 유저 등록 (POST "/api/v1/users")
- 유저 수정 (PUT "/api/v1/users)
- 유저 삭제 (DELETE "/api/v1/users/{id})

<br>

### ✔️ REST-DOCS를 이용한 API 문서화
