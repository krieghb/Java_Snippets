package com.krieghb.javasnips.tutorials.spring.lifecycle;

public class HelloWorldBean_LifeCycle {
	   private String message;

	   
	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
	   
	   
	   
	   public void init() {
		   System.out.println("Hello World Bean (Life Cycle) is getting initialized.");
	   }
	   
	   public void destroy() {
		   System.out.println("Destroying the Hello World Bean (Life Cycle).");		   
	   }
	}