package com.in28minute.rest.webservicess.spring.rest.webservice.helloworld;

public class helloBeanPractice {
	
	private String message;

	public helloBeanPractice(String message) {
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
		return "helloBeanPractice [message=" + message + "]";
	}
	
	

}
