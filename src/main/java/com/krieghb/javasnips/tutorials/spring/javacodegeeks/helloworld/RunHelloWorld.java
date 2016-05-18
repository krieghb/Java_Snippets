package com.krieghb.javasnips.tutorials.spring.javacodegeeks.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class RunHelloWorld {
	
	public static void main (String[] args) {
		
		/**
		 *   Create a new ApplicationContext deriving bean definition from the given annotated class
         *   and automatically refreshing the context.
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		/**
		 *   Return an instance, which may be shared or independent, of the specified bean.
		 */
		HelloWorldService obj = (HelloWorldService)context.getBean("helloWorldBean");
		
		obj.setName("Java Code Geeks are stupid");   // not needed according to java code geeks
		obj.sayHello("yaaaa");
		
		
		((AbstractApplicationContext) context).close();
	}

}
