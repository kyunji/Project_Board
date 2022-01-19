package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
	
	@Autowired
    private UserRepository userRepository;
	
	@PostMapping("/signup")
	public String mainPage(Model model,User user){
		model.addAttribute(user.getEmail());
		model.addAttribute(user.getName());
		
		User user1=new User();
    	user1.setEmail(user.getEmail());
    	user1.setName(user.getName());
        userRepository.save(user1);
        //userRepository.flush();
        System.out.println(userRepository.findAll());
		
		return "index";
	}
	
}
