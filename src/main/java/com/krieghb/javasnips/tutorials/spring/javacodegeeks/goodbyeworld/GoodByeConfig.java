package com.krieghb.javasnips.tutorials.spring.javacodegeeks.goodbyeworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoodByeConfig {
	
	@Bean(name = "goodByeBean")
	public GoodByeWorld goodByeWorld() {
		return new GoodByeWorld();
	}

}
