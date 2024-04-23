package com.in28minute.rest.webservicess.spring.rest.webservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minute.rest.webservicess.spring.rest.webservice.User.Post;
import com.in28minute.rest.webservicess.spring.rest.webservice.User.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
