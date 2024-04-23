package com.restapilastpractice.restApi.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versionController {	
	
	@GetMapping("/v1/versionOne")
	public nameVersion1 getfirstversion() {		
		return new nameVersion1("pratik salunkhe");		
	}
	
	@GetMapping("/v2/versionTwo")
	public nameVersion2 getSecoundVersion() {
		return new nameVersion2(new Name("Pratik", "salunkhe"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public nameVersion1 getfirstversionUsingrequestparam() {		
		return new nameVersion1("pratik salunkhe");		
	}
	
	@GetMapping(path = "person2", params = "version=2")
	public nameVersion2 getSecoundVersionRequestparam() {
		
		return new nameVersion2(new Name("Pratik", "salunkhe"));
		
	}
	

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public nameVersion1 getFirstVersionOfPersonRequestHeader() {
		return new nameVersion1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public nameVersion2 getSecoundVersionPersonRequestHeader() {
		
		return new nameVersion2(new Name("Pratik", "salunkhe"));
		
	}
	

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public nameVersion1 getFirstVersionOfPersonAcceptHeader() {
		return new nameVersion1("Bob Charlie");
	}
	
	
	@GetMapping(path = "/person/accept", produces  = "application/vnd.company.app-v2+json")
	public nameVersion2 getSecoundVersionPersonAcceptHeader() {
		
		return new nameVersion2(new Name("Pratik", "salunkhe"));
		
	}

}
