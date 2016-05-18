package com.krieghb.javasnips.tutorials.spring.auto_wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestWireApp {
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans/Beans_Wire.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(WireConfig.class);
		
		TextEditor myTE = (TextEditor) context.getBean("textEditorBean");
		
		myTE.spellCheck();
		
		((AbstractApplicationContext) context).close();
	}

}
