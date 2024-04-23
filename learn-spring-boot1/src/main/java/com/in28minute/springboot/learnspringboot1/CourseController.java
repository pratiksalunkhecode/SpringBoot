package com.in28minute.springboot.learnspringboot1;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
    public List<Course> retriveCourse(){
    	
    	return Arrays.asList(
    			
    			new Course(1,"java","PS2"),
    			new Course(2,"C#","PS2"),
    			new Course(3,"DSA","PS2")
    			
    			);
    			
    	
    }

}
