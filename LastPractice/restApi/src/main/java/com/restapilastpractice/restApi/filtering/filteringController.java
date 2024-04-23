package com.restapilastpractice.restApi.filtering;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filteringController {
	
	@GetMapping("/filtering")
	public SomeBean filter() {
	  return new SomeBean("field1","field2","field3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filterList() {
	  return Arrays.asList(new SomeBean("field1","field2","field3"),
			  new SomeBean("field1","field2","field3")); 
	}
	
}
