package com.krieghb.javasnips.experiments.strings;

import static com.krieghb.snippets.utilities.String_Constants.*;
import static com.krieghb.snippets.utilities.String_Constants.STAR_SEPERATOR;

public class String_Basic {
	
	String stringA;
	
	public String_Basic() {
		
		stringA = "String A";
		
		
	}

	
	
	public void print_String() {
		
		System.out.println("String:  " + stringA); // Display the string.
		System.out.println("Length of String:  " + string_Length());
		System.out.println("\n");

	}
	
	
	public int string_Length() {
		int stringLength;
		
		stringLength = stringA.length();
		
		return stringLength;
	}
	
	
	
	public void executeBasicTest() {
		System.out.println(STAR_SEPERATOR);
		System.out.println("Executing String Test");
		System.out.println(STAR_SEPERATOR);

		
		print_String();
		
	}
}
