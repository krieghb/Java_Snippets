package com.krieghb.javasnips.tutorials.spring.customevent;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
	
	public CustomEvent(Object source) {
		super(source);
	}
	
	public String toString() {
		return "My Custom Event.";
	}

}
