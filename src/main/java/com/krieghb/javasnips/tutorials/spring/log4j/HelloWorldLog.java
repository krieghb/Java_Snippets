package com.krieghb.javasnips.tutorials.spring.log4j;

public class HelloWorldLog {
	
	private String message;
	
	public void setMessage (String message) {
		this.message = message;
	}
	
	public void getMessage() {
		System.out.println("Your message:  " + message);
	}

}
