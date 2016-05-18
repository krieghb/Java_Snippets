package com.krieghb.javasnips.tutorials.spring.auto_wiring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({TextEditorConfig.class, SpellCheckerConfig.class})
public class WireConfig {
	
	

}
