package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
   @Autowired
   private JdbcTemplate springJdbcTemplet;
   
   private static String INSERT_QUERY = 
		   """
		   	INSERT INTO COURSE(ID,NAME,AUTHOE)
            VALUES(?,?,?)	
          	
		   		
		   		""";
   
   public void insert(Course course)
   {
	   springJdbcTemplet.update(INSERT_QUERY ,course.getId(),course.getName(),course.getAuthor());
   }

}
