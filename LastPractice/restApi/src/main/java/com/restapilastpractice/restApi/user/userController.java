package com.restapilastpractice.restApi.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
	
	private userRepository service;

	public userController(userRepository service) {
		super();
		this.service = service;
	}
	
   @GetMapping("/users")	
   public List<User> retriveAllUser(){
	   return service.findAll();
   }
	

}
