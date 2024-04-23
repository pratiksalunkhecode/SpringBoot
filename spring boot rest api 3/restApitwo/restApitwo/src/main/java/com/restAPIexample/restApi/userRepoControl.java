package com.restAPIexample.restApi;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userRepoControl {
	
	
	private userRepo res;
	
	public userRepoControl(userRepo res) {
		super();
		this.res = res;
	}

	@RequestMapping("/User")
	public List<templeteOfMyUser> getMyuser() {
		return res.getUsers();		
		
	}
	
	
	

}
