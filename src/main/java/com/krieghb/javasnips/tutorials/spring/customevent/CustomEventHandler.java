package com.krieghb.javasnips.tutorials.spring.customevent;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {
	
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event.toString());
	}

}
