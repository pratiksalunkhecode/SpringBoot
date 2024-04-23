package com.in28minute.rest.webservicess.spring.rest.webservice.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.in28minute.rest.webservicess.spring.rest.webservice.jpa.PostRepository;
import com.in28minute.rest.webservicess.spring.rest.webservice.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResourceController {

	private UserDaoService service;
	
	private UserRepository repository;
	
	private PostRepository postRepository;

	public UserJpaResourceController(UserDaoService service, UserRepository repository, PostRepository postRepository) {
		
		this.service = service;
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){	
		return repository.findAll();	
	}

	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id){		
		Optional<User> userById = repository.findById(id);
		
		if(userById.isEmpty())
		
			throw new UserNotFoundException("id"+id);
		
		EntityModel<User> entityModel = EntityModel.of(userById.get());
		
	   WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
	
	   entityModel.add(link.withRel("all-users"));
		return entityModel;	
		
		//wrapping the user class and creating the model
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){		
		repository.deleteById(id);	
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostUser(@PathVariable int id) {

		Optional<User> userById = repository.findById(id);

		if (userById.isEmpty())

			throw new UserNotFoundException("id" + id);
		      
		   return userById.get().getPosts();
		

	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		service.save(user);
		User savedUser = repository.save(user);
		
			   URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					          .path("/{id}")
					          .buildAndExpand(savedUser.getId())
					          .toUri();			   
	return	ResponseEntity.created(location).build();
	} 
	
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostUser(@PathVariable int id, @Valid @RequestBody Post post ) {

		Optional<User> userById = repository.findById(id);

		if (userById.isEmpty())

			throw new UserNotFoundException("id" + id);
		      
		   post.setUser(userById.get());
		
		 Post savedPost =  postRepository.save(post);
		   
		   URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			          .path("/{id}")
			          .buildAndExpand(savedPost.getId())
			          .toUri();			   
return	ResponseEntity.created(location).build();
		

	}
	
	
}
