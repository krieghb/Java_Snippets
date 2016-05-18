package com.krieghb.javasnips.tutorials.spring.javacodegeeks.helloworld;

public class HelloWorldService {
	
	private String name;
	
	public void sayHello(String name) {
		
		System.out.println("Hello from Java Configuration:  '" + name + "'.");
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	/**
	 * From Java code geeks this is all they say you need (no variable, or setter):
	 *   But obviously this will cause errors . . .  (Think they left off argument)
	 * 
	 * public String sayHello() {
	 *     System.out.println("Hello from Java Configuration:  '" + name + "'.");
	 * }
	 */

}
