# Board_Project

## 회원관리
### DB Table(users)
1. idx
2. id
3. password
4. name
5. email
6. signup_time

 

## 게시판
### DB Table(board_table)
1. idx
2. title
3. content
4. id(writer)
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
6-2. BoardResponseMessage: spring -> vue로 board 관련 데이터 전송할 때 사용하는 객체
6-3. BoardInsertResponseMessage:
6-4. BoardDeleteResponseMessage:
7. domain <br />
7-1. user: user domain
7-2. board: board domain

src/main/resources  <br/>
1. mappers
1-1. UserMapper.xml : sql 쿼리
1-2. BoardMapper.xml : sql 쿼리


## 페이지 구성(vue)
1. / : home
2. /signup: 회원가입 페이지
3. /login : login 페이지
4. /board : 게시판 첫 화면(게시글 목록)
