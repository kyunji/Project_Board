package com.board;

import com.board.domain.User;
import com.board.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void insertUser() {
        User params = new User();
        params.setUserid("id");
        params.setUsername("name");
        params.setUserpassword("password");
        params.setUseremail("id@password.com");
        userMapper.insertUser(params);

//        System.out.println(userMapper.selectUsername("name").getUsername());
    }
}
