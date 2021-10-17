# 게시판 API

## (코드 수정중)

<br>

### 1. 패키지 구성
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
* exception
* repository
* service

<br>

### 2. API 구현

- 게시글 조회
    - 페이징 조회 (GET "/posts")
    - 단건 조회 (GET "/posts/{id}")
- 게시글 작성 (POST "/posts")
- 게시글 수정 (POST "/posts/{id}")

<br>

### 3. REST-DOCS를 이용한 API 문서화
