package com.in28minute.rest.webservicess.spring.rest.webservice.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorld {
	
	private MessageSource messageSource;
	
	public HelloWorld(MessageSource messageSource)
	{
		this.messageSource = messageSource;                           
	}
	
	@GetMapping(path="/hello")
	public String hello() {		
		return "Hello World";       		
	}
	
	
	@GetMapping(path="/hello-world-bean")
	public hellobean hellobean() {		
		return new hellobean("Hello World");		
	}
	
	
	@GetMapping(path="/hello-world/path-variable/{name}") 
	public hellobean helloworldpathvariable(@PathVariable String name) {		
		return new hellobean(String.format("Hello World, %s", name));		
	}
	
	@GetMapping(path="/hello-world-internationalize")
	public String hellointernationalize() {
		Locale Locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", Locale);
		//return "Hello World v2";       		
	}
	

}
