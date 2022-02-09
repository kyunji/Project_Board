package com.example.demo;

import com.board.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
//@Transactional
class UserRepositoryTest {
	
    @Autowired
    private UserRepository userRepository;
    
    @Test
    void crud() { // create, read, update, delete
    	User user=new User();
    	user.setEmail("david@fastcampus.com");
    	user.setName("david");
//        userRepository.save(user);
        //userRepository.flush();
//        System.out.println(userRepository.findAll());

    }
}