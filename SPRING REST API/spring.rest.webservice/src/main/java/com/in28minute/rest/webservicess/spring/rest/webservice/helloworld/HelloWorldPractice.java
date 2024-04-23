package com.in28minute.rest.webservicess.spring.rest.webservice.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldPractice {
	
	@GetMapping(path = "/helloo")
	public String beann() {
		return "Hello World Practice";
	}
	
	@RequestMapping(path = "/hello/hello-bean", method = RequestMethod.GET)
	public helloBeanPractice beanP() {
		return new helloBeanPractice("hello bean Practice");
	}
	
	@RequestMapping(path = "/hello/hello-bean/{name}", method = RequestMethod.GET)
	public helloBeanPractice beanP(@PathVariable String name) {
		return new helloBeanPractice(String.format("hello bean Practice " + name));
	}
	
	
	
}
