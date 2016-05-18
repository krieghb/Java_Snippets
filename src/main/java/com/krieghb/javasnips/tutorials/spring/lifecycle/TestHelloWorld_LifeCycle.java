package com.krieghb.javasnips.tutorials.spring.lifecycle;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class TestHelloWorld_LifeCycle {

	public static void main(String[] args) {
//		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("/resources/Beans/Beans_LifeCycle.xml");
		 AbstractApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_LifeCycle.xml");

	      HelloWorldBean_LifeCycle objA = (HelloWorldBean_LifeCycle) context.getBean("helloWorld");
	      objA.getMessage();
	      
	      context.registerShutdownHook();

	}

}
