# Board_Project

## 회원관리
### DB Table(users)
1. idx (BIGINT, PK, NN, AI)
2. id (VARCHAR(20), NN, UQ)
3. password (VARCHAR(20), NN)
4. name (VARCHAR(40), NN)
5. email (VARCHAR(40), NN)
6. signup_time (DATETIME, NN, CURRENT_TIMESTAMP)

 

## 게시판
### DB Table(board_table)
1. idx (BIGINT, PK, NN, AI)
2. title (LONGTEXT, NN)
3. content (LONGTEXT, NN)
4. id(writer/ VARCHAR(20), NN)
5. insert_time(DATETIME, NN)

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
6. api <br/>
6-1. ApiResponseMessage: spring -> vue로 상태코드 전송할 때 사용하는 객체 <br/>
6-2. BoardResponseMessage: spring -> vue로 board 관련 데이터 전송할 때 사용하는 객체 <br/>
6-3. BoardInsertResponseMessage:
6-4. BoardDeleteResponseMessage:
7. domain <br/>
7-1. user: user domain <br/>
7-2. board: board domain <br/>

src/main/resources  <br/>
1. mappers
1-1. UserMapper.xml : sql 쿼리
1-2. BoardMapper.xml : sql 쿼리


## 페이지 구성(vue)
1. / : home
2. /signup: 회원가입 페이지
3. /login : login 페이지
4. /board : 게시판 첫 화면(게시글 목록)
