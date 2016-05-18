package com.krieghb.javasnips.tutorials.spring.postproc;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestHelloWorld_PostProc {

	public static void main(String[] args) {
		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans/Beans_PostProc.xml");
//		 AbstractApplicationContext context = new FileSystemXmlApplicationContext("beans/Beans_PostProc.xml");

	      HelloWorldBean_PostProc objA = (HelloWorldBean_PostProc) context.getBean("helloWorld");
	      objA.getMessage();
	      
	      context.registerShutdownHook();

	}

}
