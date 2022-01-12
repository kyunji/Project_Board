package com.example.demo.controller;

import com.example.demo.domain.UserDto;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
	@PostMapping("/signup")
	public String mainPage(Model model,UserDto user){
		LocalDate now = LocalDate.now();

		model.addAttribute("userId",user.getUserId());
		model.addAttribute("userName",user.getUserName());
		model.addAttribute("userPassword",user.getUserPassword());
		model.addAttribute("userEmail",user.getUserEmail());
		model.addAttribute("userAddDate",now);
		System.out.print("======================= \n");
		System.out.print(user);
		System.out.print("======================= \n");
		
		return "index";
	}
	
}
