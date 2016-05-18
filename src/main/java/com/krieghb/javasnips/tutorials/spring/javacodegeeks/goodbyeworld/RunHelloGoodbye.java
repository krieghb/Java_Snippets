package com.krieghb.javasnips.tutorials.spring.javacodegeeks.goodbyeworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class RunHelloGoodbye {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
//		HelloWorldAgain helloAgain = (HelloWorldAgain) context.getBean("helloWorldAgainBean");
		HelloWorldAgain helloAgain = (HelloWorldAgain) context.getBean(HelloWorldAgain.class);
		helloAgain.speakHello("I'm Saying hello from the main file!");
		
//		GoodByeWorld goodBye = (GoodByeWorld) context.getBean("goodByeBean");
		GoodByeWorld goodBye = (GoodByeWorld) context.getBean(GoodByeWorld.class);
		goodBye.sayGoodbye("OY!");
		
		
		((AbstractApplicationContext) context).close();
		
	}

}
