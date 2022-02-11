# Board_Project

## 개발 환경
1. Back-end
- Java Spring boot 2.6.2 (Laguage level: Project default(11), JDK 11) <br />
- Gradle Project <br />

2. Front-end
- Vue.js <br />
- Vuetify <br />
- @vue/cli 4.5.15 <br />

3. Database
- MySQL <br />
- Mybatis <br />
-  
4. Development Tools
- IntelliJ(Ultimate) <br />
- Visual Studio Code <br />
- MySQL Workbench <br />
- Chrome <br />


## 프로젝트 개요
### 프로젝트 소개
- 1인으로 약 1달동안 진행한 토이 프로젝트입니다. <br />
- 블로그 형식의 웹 사이트이고, 크게 2가지 기능으로 회원 관리, 게시글 관리의 기능을 갖습니다. 로그인 여부에 따라 사용자에게 서비스가 다르게 제공됩니다. 게시판 서비스(글 목록 조회, 글 작성, 수정, 삭제)는 회원에게만 제공됩니다. 

### 프로젝트 기능
1. 회원가입
2. 로그인
3. 로그아웃
4. 게시글 목록(회원 전용)
5. 게시글 작성(회원 전용)
6. 게시글 수정(회원 전용, 본인의 글만 가능)
7. 게시글 삭제(회원 전용, 본인의 글만 가능)

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
 
## 데이터베이스 구성
### users
1. idx (BIGINT, PK, NN, AI)
2. id (VARCHAR(20), NN, UQ)
3. password (VARCHAR(20), NN)
4. name (VARCHAR(40), NN)
5. email (VARCHAR(40), NN)
6. signup_time (DATETIME, NN, CURRENT_TIMESTAMP)

### board
1. idx (BIGINT, PK, NN, AI)
2. title (LONGTEXT, NN)
3. content (LONGTEXT, NN)
4. id(writer/ VARCHAR(20), NN)
5. insert_time(DATETIME, NN)
## 페이지 구성(vue)
1. / : home
2. /signup: 회원가입 페이지
3. /login : login 페이지
4. /board : 게시판 첫 화면(게시글 목록)
