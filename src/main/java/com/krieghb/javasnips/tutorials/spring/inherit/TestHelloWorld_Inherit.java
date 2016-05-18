package com.krieghb.javasnips.tutorials.spring.inherit;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class TestHelloWorld_Inherit {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans/Beans_Inherit.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_Inherit.xml");

	      HelloWorldBean_Inherit objA = (HelloWorldBean_Inherit) context.getBean("helloWorld");
	      objA.getMessage1();
	      objA.getMessage2();
	      
	      HelloIllinois objB = (HelloIllinois) context.getBean("helloIllinois");
	      objB.getMessage1();
	      objB.getMessage2();
	      objB.getMessage3();
	      
	      
	}

}
