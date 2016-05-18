package com.krieghb.javasnips.tutorials.spring.inherit;

public class HelloWorldBean_Inherit {
	   private String message1;
	   private String message2;

	   
	   
	   
	   public void setMessage1(String message){
	      this.message1  = message;
	   }
	   
	   public void setMessage2(String message){
		      this.message2  = message;
		   }


	   public void getMessage1(){
	      System.out.println("Your Message: " + message1);
	   }
	   public void getMessage2(){
		      System.out.println("Your Message: " + message2);
		   }
	   
	   
	   
	   public void init() {
		   System.out.println("Hello World Bean is getting initialized.");
	   }
	   
	   public void destroy() {
		   System.out.println("Destroying the Hello World Bean.");		   
	   }
	}