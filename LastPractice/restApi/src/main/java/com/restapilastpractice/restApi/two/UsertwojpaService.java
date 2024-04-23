package com.restapilastpractice.restApi.two;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapilastpractice.restApi.jpa.UserTwoRepository;
import com.restapilastpractice.restApi.user.UserNotFoundException;

@RestController
public class UsertwojpaService {

	private UsertwoDaoRepository service;
	
	private UserTwoRepository repo;

	public UsertwojpaService(UsertwoDaoRepository service, UserTwoRepository repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/jpa/usertwo")
	public List<Usertwo> retriveALl() {
		return repo.findAll();
	}

	// @GetMapping("/usertwo/{id}")
    // for Hatoas
	
	// Entity Model 
	// webmvclinkbuilder
	
	@GetMapping("/jpa/usertwo/{id}")
	public EntityModel<Usertwo> retriveALl(@PathVariable int id) {
		
		Usertwo user = service.findOne(id);
		
		if(user == null)
		
			throw new UserNotFoundException("id"+id);
		
		EntityModel<Usertwo> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveALl());
	
		entityModel.add(link.withRel("all-users"));
	
			return entityModel;
		
		
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Usertwo> createUser(@Validated @RequestBody Usertwo user) {
		
		Usertwo savedUser = service.saveUsertwo(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/usertwo/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}

}
