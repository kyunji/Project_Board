# Board_Project

## 회원관리
### DB Table(user_table)
1. idx
2. userid
3. userpassword
4. username
5. useremail
6. signup_time

 

## 게시판
### DB Table(board_table)
1. idx
2. title
3. content
4. writer
5. delete_chk(0: not deleted, 1: deleted)
6. insert_time(현재 시각)
7. delete_time

## 프로젝트 구성
main/java <br/>

1. controller <br/>
1-1. UserController.java <br/>
2. domain <br/>
2-1. UserDTO.java  <br/>
2-2. BoardDTO.java <br/>
3. mapper <br/>
3-1. UserMapper.java (I) <br/>
3-2. BoardMapper.java (I) <br/>
4. configuration <br/>
4-1. DBConfiguration.java <br/>
5. service <br/>
5-1. UserService.java : 회원가입(db insert)
5-2. BoardService.java : 게시판 글 작성(db insert)
6. api <br />
6-1. ApiResponseMessage: spring -> vue로 상태코드 전송할 때 사용하는 객체

src/main/resources  <br/>
1. mappers
1-1. UserMapper.xml : sql 쿼리
1-2. BoardMapper.xml : sql 쿼리


## 페이지 구성(vue)
1. / : home
2. /signup: 회원가입 페이지
3. /login : login 페이지
4. /user : user만 접근할 수 있는 페이지 (로그인 성공)
5. /board : 게시판 첫 화면
