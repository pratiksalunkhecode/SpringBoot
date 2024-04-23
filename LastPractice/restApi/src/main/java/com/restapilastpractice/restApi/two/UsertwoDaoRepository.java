package com.restapilastpractice.restApi.two;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class UsertwoDaoRepository {

	private static List<Usertwo> users = new ArrayList<>();

//	private static Integer userCount = 0;

	static {

		users.add(new Usertwo(1, "pratik", LocalDate.now().minusYears(6)));
		users.add(new Usertwo(2, "pratik", LocalDate.now().minusYears(6)));
		users.add(new Usertwo(3, "pratik", LocalDate.now().minusYears(6)));
		users.add(new Usertwo(4, "pratik", LocalDate.now().minusYears(6)));

	}

	public List<Usertwo> findAll() {
		return users;
	}

	public Usertwo findOne(int id) {
		Usertwo userss = null;
		userss = users.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
		return userss;
	}

	public Usertwo saveUsertwo(Usertwo user) {
		user.setId(5);
		users.add(user);
		return user;
	}

	public void deleteById(int id) {  

		users = (List<Usertwo>) users.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
		// users.removeIf((Predicate<? super User>) users);
	}

}
