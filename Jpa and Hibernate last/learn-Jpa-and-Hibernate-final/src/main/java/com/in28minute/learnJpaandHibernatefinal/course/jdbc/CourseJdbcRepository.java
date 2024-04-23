package com.in28minute.learnJpaandHibernatefinal.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minute.learnJpaandHibernatefinal.course.Course;

@Repository // class talk to database use as a repository
public class CourseJdbcRepository {
	
	
	@Autowired
	private JdbcTemplate springjdbctemplet;
	
	private static String INSERT_QUERY =
			"""
				
                insert into course(id,name,author) values (?,?,?)	           
				
					""";
	
	private static String DELETE_QUERY =
			"""
				
               	           
				delete from course where id = ?;
					""";
	
	public void insert(Course course)
	{
		springjdbctemplet.update(INSERT_QUERY, course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(long id)
	{
		springjdbctemplet.update(DELETE_QUERY, id);
	}

}
