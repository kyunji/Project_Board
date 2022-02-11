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
📦Board <br />
 ┣ 📂.gradle <br />
 ┣ 📂.idea <br />
 ┣ 📂.settings <br />
 ┣ 📂build <br />
 ┣ 📂gradle <br />
 ┣ 📂src <br />
 ┃ ┣ 📂.idea <br />
 ┃ ┣ 📂main <br />
 ┃ ┃ ┣ 📂java <br />
 ┃ ┃ ┃ ┗ 📂com <br />
 ┃ ┃ ┃ ┃ ┗ 📂board <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂api <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDeleteResponseMessage.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardInsertResponseMessage.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardResponseMessage.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardUpdateResponseMessage.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserResponseMessage.java <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂configuration <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DBConfiguration.java  <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domain <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Board.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDTO.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDTO.java <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂errorhandler <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GlobalErrorController.java <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardMapper.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserMapper.java <br />
 ┃ ┃ ┃ ┃ ┃ ┣ 📂service <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardService.java <br />
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java <br />
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BoardApplication.java <br />
 ┃ ┃ ┣ 📂resources <br />
 ┃ ┃ ┃ ┣ 📂mappers <br />
 ┃ ┃ ┃ ┃ ┣ 📜BoardMapper.xml <br />
 ┃ ┃ ┃ ┃ ┗ 📜UserMapper.xml <br />
 ┃ ┃ ┃ ┣ 📂static <br />
 ┃ ┃ ┃ ┃ ┣ 📂js <br />
 ┃ ┃ ┃ ┣ 📂templates <br />
 ┃ ┃ ┃ ┣ 📜application.properties <br />
 ┃ ┃ ┃ ┗ 📜mybatis-config.xml <br />
 ┃ ┃ ┗ 📜main.iml <br />
 ┣ 📜.classpath <br />
 ┣ 📜.gitignore <br />
 ┣ 📜.project <br />
 ┣ 📜Board.iml <br />
 ┣ 📜build.gradle <br />
 ┣ 📜gradlew <br />
 ┣ 📜gradlew.bat <br />
 ┣ 📜HELP.md <br />
 ┣ 📜package-lock.json <br />
 ┣ 📜package.json <br />
 ┗ 📜settings.gradle <br />
 
 
## 페이지 구성(vue)
1. / : home
2. /signup: 회원가입 페이지
3. /login : login 페이지
4. /board : 게시판 첫 화면(게시글 목록)
