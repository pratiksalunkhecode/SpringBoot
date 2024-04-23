package com.in28minute.rest.webservicess.spring.rest.webservice.helloworld;

public class hellobean2 {

	private String message;

	public hellobean2(String message) {
		super();
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
		return "hellobean2 [message=" + message + "]";
	}
	
	
	

}
