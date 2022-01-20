# Board_Project

## 회원관리
### DB Table(user_table)
1. idx
2. userid
3. userpassword
4. username
5. useremail
6. signup_time


### 프로젝트 구성
main/java <br/>

1. controller <br/>
1-1. UserController.java <br/>
2. domain <br/>
2-1. UserDTO.java  <br/>
3. mapper <br/>
3-1. UserRepository.java (I) <br/>
4. configuration <br/>
4-1. DBConfiguration.java <br/>
5. service <br/>
5-1. UserService.java : 회원가입(db insert)

src/main/resources  <br/>
1. mappers
1-1. UserMapper.xml : sql 쿼리
2. board


### 페이지 구성(vue)
1. / : home
2. /signup: 회원가입 페이지
3. /login : login 페이지
4. /user : user만 접근할 수 있는 페이지 (로그인 성공)
 

## 게시판
### DB Table()
1. id(random number)
2. userId(user_id)
3. Title
4. Body
5. textAddDate(write_add_date)
6. textDeleteDate(write_delete_date)
7. textDeleteChk(write_delete_chk)
