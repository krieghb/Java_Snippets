package com.krieghb.javasnips.experiments.tester;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {

//		testBool();
		testSets();
		
		
		printOut("End of line");

	}
	
	public static void printOut(Object object) {
		System.out.println(object.toString());
	}
	
	
	public static void checkit(Object a, Object b)  {
		if (!(a == null && b == null) && ( a == null || b == null || (!a.equals(b)) )) {
			printOut("One might be null");
		}	
	}
		
	public static void testBool() {
		Object one = null;
		Object two = null;
		Object three = new Integer(4);
		Object four = 1l;
		Object five = 1l;
		

		checkit(one, four);
	}
	
	
	public static void testSets() {
		List<Long> mylist = new ArrayList<>();
		Set<Long> mySet = new LinkedHashSet<Long>();
		
		mylist.add(10l);
		mylist.add(11l);
		mylist.add(12l);
		mylist.add(13l);
		mylist.add(14l);
		mylist.add(15l);
		
		mySet.add(10l);
		mySet.add(10l);
		mySet.add(11l);
		mySet.add(12l);
		mySet.add(13l);
		mySet.add(14l);
		mySet.add(15l);
		
		
		for (Long id : mySet) {
			printOut(id);
			
		}
		printOut(mylist.get(0));
		
	}
	
	
}
