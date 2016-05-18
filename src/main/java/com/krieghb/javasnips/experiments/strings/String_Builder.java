package com.krieghb.javasnips.experiments.strings;

import static com.krieghb.javasnips.utilities.String_Constants.STAR_SEPERATOR;

public class String_Builder {
	
	public StringBuilder myStringBuilder;
	
	public String_Builder() {
		
		
		
		 myStringBuilder = new StringBuilder("Hi There Everybody!");
		
	}
	
	public void change_String(StringBuilder changeString) {
		
		changeString.replace(0, changeString.length(), "The string was changed");
		
	}
	
	// Printing String builder information
	public void class_Printer() {

		System.out.println("String Builder:  " + myStringBuilder.toString());
		System.out.println("Size of String Builder:  " + myStringBuilder.length());
		System.out.println("Capacity of String Builder:  " + myStringBuilder.capacity());
		System.out.println();
	}
	
	

	public void executeSBTest() {
		System.out.println(STAR_SEPERATOR);
		System.out.println("Executing String Builder Test");
		System.out.println(STAR_SEPERATOR);
		
		
		class_Printer();

		change_String(myStringBuilder);
		
		class_Printer();
	}

}
