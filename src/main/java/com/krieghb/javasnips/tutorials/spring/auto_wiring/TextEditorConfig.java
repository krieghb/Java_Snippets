package com.krieghb.javasnips.tutorials.spring.auto_wiring;

import org.springframework.context.annotation.Bean;

public class TextEditorConfig {
	
	@Bean(name = "textEditorBean")
	public TextEditor textEditor() {
		return new TextEditor();
	}
	
	

}
