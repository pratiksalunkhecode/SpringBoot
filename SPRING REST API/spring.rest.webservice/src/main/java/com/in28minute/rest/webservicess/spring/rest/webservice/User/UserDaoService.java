package com.in28minute.rest.webservicess.spring.rest.webservice.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		
		users.add(new User(++userCount,"pratik" ,LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "pandaa", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "dida", LocalDate.now().minusYears(30)));
		
	}
	
	
	
	public List<User> findAll(){
		return users; 
	}
	
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	

//
//	public User findOne(int id) {
//		Predicate<? super User> predicate = user -> user.getId().equals(id); 
//		return users.stream().filter(predicate).findFirst().get();
//	}
	
	public User getUserById(int id) {
		User userss = null;		
		userss = users.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
		return userss;		
	}
	
	
	public void deleteById(int id) {
			
		users = (List<User>) users.stream().filter(e -> e.getId() != id).
		collect(Collectors.toList());
		
		//users.removeIf((Predicate<? super User>) users);
	}
	
	
	

}
