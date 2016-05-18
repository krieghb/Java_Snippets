package com.krieghb.javasnips.tutorials.spring.javacodegeeks.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:configuration/constants.properties")
@PropertySource("classpath:configuration/mynew.properties")
public class PropAppConfig { 
	
	
	@Value( "${constant.prefix}" )
	private String prefix;
	@Value( "${constant.suffix}" )
	private String suffix;
	
	@Bean(name = "helloWorldPropBean")
	public HelloWorldProp helloWorldProp() {
		
		HelloWorldProp myProp = new HelloWorldProp();
		
		myProp.setPrefixProp(prefix);
		myProp.setSuffixProp(suffix);
		
		return myProp;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	   }

	

}
