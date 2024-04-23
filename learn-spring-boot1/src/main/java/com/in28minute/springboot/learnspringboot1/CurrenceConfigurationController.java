package com.in28minute.springboot.learnspringboot1;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrenceConfigurationController {
	
	@Autowired
	private CurrenceServiceConfiguration configuration;
	
	
	@RequestMapping("currency-configuration")
    public CurrenceServiceConfiguration retriveCourse(){
    	
    	return configuration;
    			
    		
    			
    	
    }

}
