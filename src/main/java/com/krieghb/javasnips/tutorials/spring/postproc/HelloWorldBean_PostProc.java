package com.krieghb.javasnips.tutorials.spring.postproc;

public class HelloWorldBean_PostProc {
	   private String message;

	   
	   
	   
	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message: " + message);
	   }
	   
	   
	   
	   public void init() {
		   System.out.println("Hello World Bean is getting initialized.");
	   }
	   
	   public void destroy() {
		   System.out.println("Destroying the Hello World Bean.");		   
	   }
	}