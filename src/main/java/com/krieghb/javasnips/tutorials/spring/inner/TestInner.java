package com.krieghb.javasnips.tutorials.spring.inner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInner {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans/Beans_Inner.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("/resources/beans/Beans_Inner.xml");
		
		TextEditor myEditor = (TextEditor) context.getBean("textEditor");
		
		myEditor.spellCheck();
	}

}
