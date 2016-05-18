package com.krieghb.javasnips.tutorials.spring.customevent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCustomEvent {
	
	public static void main(String[] args) {
		
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans/Beans_CustomEvent.xml");
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_CustomEvent.xml");
		
		CustomEventPublisher myPublisher = (CustomEventPublisher) context.getBean("customEventPublisher");

		myPublisher.publish();
		myPublisher.publish();
		
		context.close();
	}

}
