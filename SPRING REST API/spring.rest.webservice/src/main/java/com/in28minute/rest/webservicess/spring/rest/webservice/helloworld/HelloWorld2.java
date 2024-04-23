package com.in28minute.rest.webservicess.spring.rest.webservice.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.Path;


@RestController
public class HelloWorld2 {
	
	private MessageSource messageSource;

	public HelloWorld2(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	
	@GetMapping(path="/hello2")
	public String hello2(){
		return "hello world";
	}

	
	@GetMapping(path="/hello2-bean")
	public hellobean2 hello2b(){
		return new hellobean2("hello world2");
	}
	
	@GetMapping(path="/hello2-bean/{name}")
	public hellobean2 helloPathVariable(@PathVariable String name){
		return new hellobean2(String.format("hello world2, %s",name));
	}
}
