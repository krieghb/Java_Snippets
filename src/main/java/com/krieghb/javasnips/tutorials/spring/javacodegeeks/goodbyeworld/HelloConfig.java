package com.krieghb.javasnips.tutorials.spring.javacodegeeks.goodbyeworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

	@Bean(name = "helloWorldAgainBean")
	public HelloWorldAgain helloWorldService() {
		return new HelloWorldAgain();
	}
	
}
