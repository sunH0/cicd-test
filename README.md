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
* 위치 : /src/main/resources/documentation/index.html

## Commit Message 작성 규칙
```bash
1- ⭐ feat : 새로운 기능에 대한 커밋
2- ⚙️ chore : 그 외 자잘한 수정에 대한 커밋
3- 🐞 fix : 버그 수정에 대한 커밋
4- 📖 docs : 문서 수정에 대한 커밋
5- 💅 style : 코드 스타일 혹은 포맷 등에 관한 커밋
6- ♻️ refactor : 코드 리팩토링에 대한 커밋
7- 🚦 test : 테스트 코드 수정에 대한 커밋
8- 🚀 CI : CI/CD
9- 🔖 Release : 제품 출시
10- 🎉 init : 최초 커밋
11- 🛠️ Config : 환경설정에 대한 커밋
12- 🦔 Revert : 리버트
```
