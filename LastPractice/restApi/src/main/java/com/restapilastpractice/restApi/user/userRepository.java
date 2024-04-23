package com.restapilastpractice.restApi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class userRepository {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "pratik", LocalDate.now().minusYears(20)));
		users.add(new User(2, "paty", LocalDate.now().minusYears(20)));
		users.add(new User(2, "patudi", LocalDate.now().minusYears(20)));
	}

	
	// @RequestMapping(path = "/user", method = RequestMethod.GET)
	public List<User> findAll() {
		return users;
	}

}
