package com.krieghb.javasnips.tutorials.spring.javacodegeeks.property;

public class HelloWorldProp {
	
	private String prefixProp;
	private String suffixProp;
	
	
	public void setPrefixProp(String prefixProp) {
		this.prefixProp = prefixProp;
	}
	public String getPrefixProp() {
		return prefixProp;
	}
	
	public void setSuffixProp(String suffixProp) {
		this.suffixProp = suffixProp;
	}
	public String getSuffixProp() {
		return suffixProp;
	}
	
	
	public void communicateHello() {
		System.out.println(prefixProp + "!");
	}
	
	public void communicateGoodBye() {
		System.out.println(suffixProp + "!");
	}
	

}
