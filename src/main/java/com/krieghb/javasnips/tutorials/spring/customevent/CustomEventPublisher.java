package com.krieghb.javasnips.tutorials.spring.customevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;
	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public void publish() {
		CustomEvent myCustomEvent = new CustomEvent(this);
		publisher.publishEvent(myCustomEvent);
	}
	

}
