package com.in28minute.learnJpaandHibernatefinal.course;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.in28minute.learnJpaandHibernatefinal.course.Course;
import com.in28minute.learnJpaandHibernatefinal.course.jdbc.CourseJdbcRepository;
import com.in28minute.learnJpaandHibernatefinal.course.jpa.CourseJpaRepository;

@Component
public class CourseJpaCommendLineRunner implements CommandLineRunner {
 
//	@Autowired
 //   private CourseJdbcRepository repo;
	
//	@Autowired
//    private CourseJpaRepository repo;
	
	@Autowired
	private CourseSpringDataJpaRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Course(1,"Learn java","PMT"));
		repo.save(new Course(2,"Learn java2","PMT"));
		repo.save(new Course(3,"Learn spring","PMT"));
		repo.save(new Course(4,"Learn java2","PMT"));
		repo.save(new Course(5,"Learn spring","PMT"));
		repo.save(new Course(6,"Learn java2","PMT"));
		repo.save(new Course(7,"Learn spring","PMT"));
		repo.save(new Course(8,"Learn java2","PMT"));
		repo.save(new Course(9,"Learn spring","PMT"));
		repo.save(new Course(10,"Learn java2","PMT"));
		repo.save(new Course(11,"Learn spring","PMT"));
		repo.save(new Course(12,"Learn java2","PMT"));
		repo.save(new Course(13,"Learn spring","PMT"));
		repo.save(new Course(14,"Learn java2","PMT"));
		repo.save(new Course(15,"Learn spring","PMT"));
		repo.save(new Course(16,"Learn java2","PMT"));
		repo.save(new Course(17,"Learn spring","PMT"));
		repo.save(new Course(18,"Learn java2","PMT"));
		repo.save(new Course(19,"Learn spring","PMT"));
		repo.save(new Course(20,"Learn java2","PMT"));
		repo.save(new Course(21,"Learn spring","PMT"));
		repo.save(new Course(22,"Learn java2","PMT"));
		repo.save(new Course(23,"Learn spring","PMT"));
		repo.save(new Course(24,"Learn java2","PMT"));
		repo.save(new Course(25,"Learn spring","PMT"));
		repo.save(new Course(4,"Learn spring boot","PMT"));
		System.out.println(((CourseJpaRepository) repo).select(1));
		System.out.println(((CourseJpaRepository) repo).select(3l));
		System.out.println(((CourseJpaRepository) repo).select(4));
		System.out.println(((CourseJpaRepository) repo).select(5));
		System.out.println(((CourseJpaRepository) repo).select(6));
		System.out.println(((CourseJpaRepository) repo).select(7));
		System.out.println(((CourseJpaRepository) repo).select(8));
		System.out.println(((CourseJpaRepository) repo).select(9));
		System.out.println(((CourseJpaRepository) repo).select(10));
		System.out.println(((CourseJpaRepository) repo).select(11));
		System.out.println(((CourseJpaRepository) repo).select(12));
		
		
		
	    repo.deleteById(1l);
	    System.out.println(repo.findByAuthor("PMT"));
	    System.out.println(repo.findByAuthor("PMT"));
	    
	    
	   
	   
		
		
	
	}

}
