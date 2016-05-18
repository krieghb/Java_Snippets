package com.krieghb.javasnips.tutorials.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class TestHelloWorld {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		
		
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		
		helloWorld.setMessage("Hello World");
		helloWorld.getMessage();
	}

}
