package com.krieghb.javasnips.tutorials.spring.log4j;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainLogApp { 
	
	static Logger log = Logger.getLogger(MainLogApp.class.getName());
	
	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans/Beans_Log4j.xml");
		
		log.info("Going to create HelloWorld Obj");
		
		HelloWorldLog obj = (HelloWorldLog) context.getBean("HelloLogger");
	
		obj.getMessage();
		
		log.info("Exiting the program");
		
		((AbstractApplicationContext) context).close();
		
	}

}
