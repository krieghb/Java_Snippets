package com.krieghb.javasnips.tutorials.spring.inner;



public class TextEditor {

	private SpellChecker spellChecker;
	
	//  a setter method to inject the dependency.
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside the setSpellChecker method.");
		this.spellChecker = spellChecker;
	}
	
	//  a getter method to return spellChecker.
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	
}
