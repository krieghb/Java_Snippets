package com.krieghb.javasnips.tutorials.spring.javacodegeeks.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class RunHWProp {
	
	public static void main(String[] args) {
		/**
		 *   Create a new ApplicationContext deriving bean definition from the given annotated class
         *   and automatically refreshing the context.
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(PropAppConfig.class);
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans/Beans_Property.xml");
		
//		HelloWorldProp helloProp = (HelloWorldProp) context.getBean("helloWorldPropBean");
		HelloWorldProp helloProp = (HelloWorldProp) context.getBean(HelloWorldProp.class);
		
		helloProp.communicateHello();
		helloProp.communicateGoodBye();
		
		((AbstractApplicationContext) context).close();
		
		
	}

}
