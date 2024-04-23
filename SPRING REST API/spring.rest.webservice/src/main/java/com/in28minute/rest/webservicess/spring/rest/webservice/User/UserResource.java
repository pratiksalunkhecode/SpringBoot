package com.in28minute.rest.webservicess.spring.rest.webservice.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {		
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){	
		return service.findAll();	
	}

	
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id){		
		User userById = service.getUserById(id);
		
		if(userById == null)
		
			throw new UserNotFoundException("id"+id);
		
		EntityModel<User> entityModel = EntityModel.of(userById);
		
	   WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
	
	   entityModel.add(link.withRel("all-users"));
		return entityModel;	
		
		//wrapping the user class and creating the model
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){		
		this.service.deleteById(id);	
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		service.save(user);
		User savedUser = service.save(user);
		
			   URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					          .path("/{id}")
					          .buildAndExpand(savedUser.getId())
					          .toUri();			   
	return	ResponseEntity.created(location).build();
	} 
	
	
	
}
