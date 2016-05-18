package com.krieghb.javasnips.tutorials.spring.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestEventHandler {
	
	public static void main(String[] args) {
		
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans/Beans_Event.xml");
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_Event.xml");
		
		
		//  Raising a start event.
		context.start();
		
		HelloWorld helloObject = (HelloWorld) context.getBean("helloWorld");
		
		helloObject.getMessage();
		
		//  Raising a stop event.
		context.stop();
		
		context.close();
		
	}

}
