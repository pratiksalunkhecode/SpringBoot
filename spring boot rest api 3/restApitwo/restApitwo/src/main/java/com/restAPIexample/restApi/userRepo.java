package com.restAPIexample.restApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userRepo {
	
	 private static List<templeteOfMyUser> list = new ArrayList<>();
	
	static {
		
		list.add(new templeteOfMyUser(1, "pratik", "Pune"));
		list.add(new templeteOfMyUser(2, "minay", "Mumbai"));
		list.add(new templeteOfMyUser(3, "king", "pune"+"Mumbai"));
		list.add(new templeteOfMyUser(4, "king", "pune"+"Mumbai"+"delhi"));
		
		
	}
	
	public static List<templeteOfMyUser> getUsers() {
		return list;
		
	}

}
