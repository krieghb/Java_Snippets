package com.krieghb.javasnips.tutorials.spring.javaconfig;

public class HelloWorld {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void getMessage() {
		System.out.println("The Message:  " + message);
	}

}
