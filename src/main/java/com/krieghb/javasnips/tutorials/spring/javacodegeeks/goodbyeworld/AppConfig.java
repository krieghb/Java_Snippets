package com.krieghb.javasnips.tutorials.spring.javacodegeeks.goodbyeworld;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HelloConfig.class, GoodByeConfig.class})
public class AppConfig { 

}
