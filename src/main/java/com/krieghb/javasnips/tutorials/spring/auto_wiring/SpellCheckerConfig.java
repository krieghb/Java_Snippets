package com.krieghb.javasnips.tutorials.spring.auto_wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpellCheckerConfig {
	
	@Bean(name = "spellCheckerBean")
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
	
	

}
