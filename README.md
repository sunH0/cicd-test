# πͺ§ Project Board


##  νλ‘μ νΈ λͺ©μ  
* Spring Data Jpa νμ©
* MockMvcλ₯Ό μ΄μ©ν API νμ€νΈ
* Rest-Docsλ₯Ό μ΄μ©ν API λ¬Έμν 


## βοΈ κΈ°μ  μ€ν
* Spring Data Jpa
* H2 database
* RestDocs

<br>

### βοΈ ν¨ν€μ§ κ΅¬μ±
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
* exception - (λ―Έμμ±)
* repository
* service

<br>

### βοΈ API κ΅¬ν

- κ²μκΈ μ‘°ν
    - νμ΄μ§ μ‘°ν (GET "/api/v1/posts")
    - λ¨κ±΄ μ‘°ν (GET "/api/v1/posts/{id}")
    - μ μ  κ²μκΈ μ‘°ν(GET "/api/v1/posts/user/{id}")
- κ²μκΈ μμ± (POST "/api/v1/posts")
- κ²μκΈ μμ  (PUT "/api/v1/posts")
- κ²μκΈ μ­μ  (DELETE "/api/v1/posts/{id}")


- μ μ  μ‘°ν
  - νμ΄μ§ μ‘°ν (GET "/api/v1/users")
  - λ¨κ±΄ μ‘°ν (GET "/api/v1/users/{id}")
- μ μ  λ±λ‘ (POST "/api/v1/users")
- μ μ  μμ  (PUT "/api/v1/users)
- μ μ  μ­μ  (DELETE "/api/v1/users/{id})

<br>

### βοΈ REST-DOCSλ₯Ό μ΄μ©ν API λ¬Έμν
* μμΉ : /src/main/resources/documentation/index.html

## Commit Message μμ± κ·μΉ
```bash
1- β­ feat : μλ‘μ΄ κΈ°λ₯μ λν μ»€λ°
2- βοΈ chore : κ·Έ μΈ μμν μμ μ λν μ»€λ°
3- π fix : λ²κ·Έ μμ μ λν μ»€λ°
4- π docs : λ¬Έμ μμ μ λν μ»€λ°
5- π style : μ½λ μ€νμΌ νΉμ ν¬λ§· λ±μ κ΄ν μ»€λ°
6- β»οΈ refactor : μ½λ λ¦¬ν©ν λ§μ λν μ»€λ°
7- π¦ test : νμ€νΈ μ½λ μμ μ λν μ»€λ°
8- π CI : CI/CD
9- π Release : μ ν μΆμ
10- π init : μ΅μ΄ μ»€λ°
11- π οΈ Config : νκ²½μ€μ μ λν μ»€λ°
12- π¦ Revert : λ¦¬λ²νΈ
```
