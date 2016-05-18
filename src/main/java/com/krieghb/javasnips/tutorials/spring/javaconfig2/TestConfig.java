package com.krieghb.javasnips.tutorials.spring.javaconfig2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;

public class TestConfig {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
		
		TextEditor myTextE = context.getBean(TextEditor.class);
		
		myTextE.spellCheck();
		
		((AbstractApplicationContext) context).close();
		
		
	}

}


