# Board_Project

## 회원관리
### DB Table(tb_users)
1. id(random number)
2. userName(user_name)
3. userId(user_id)
4. userPassword(user_password)
5. userEmail(user_email)
6. userAddDate(user_add_date)
7. userDeleteDate(user_delete_date)
8. userDeleteChk(user_delete_chk)

### 프로젝트 구성
main/java <br/>

1. Controller <br/>
1-1. UserController.java <br/>
2. DTO <br/>
2-1. UserDto.java  <br/>
3. Mapper <br/>
3-1. UserMapper.java (I) <br/>
4. Service <br/>  <br/>

src/main/resources  <br/>
1. Mapper
1-1. userMapper.xml : sql 쿼리
2. board
2-1. signup.html
2-2. signin.html

## 게시판
### DB Table(tb_users)
1. id(random number)
2. userId(user_id)
3. Title
4. Body
5. textAddDate(write_add_date)
6. textDeleteDate(write_delete_date)
7. textDeleteChk(write_delete_chk)
8. 
