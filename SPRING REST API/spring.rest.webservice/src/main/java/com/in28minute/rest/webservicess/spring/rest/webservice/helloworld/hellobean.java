package com.in28minute.rest.webservicess.spring.rest.webservice.helloworld;

public class hellobean {

	private String message;

	public hellobean(String message) {		
		this.message = message;		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "hellobean [message=" + message + "]";
	}
	
	
	

}
