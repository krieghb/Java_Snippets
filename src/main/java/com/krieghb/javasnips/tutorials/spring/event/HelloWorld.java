package com.krieghb.javasnips.tutorials.spring.event;

public class HelloWorld {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage()  {
		
		System.out.println("The message:  " + message);
		return message;
		
	}

}
