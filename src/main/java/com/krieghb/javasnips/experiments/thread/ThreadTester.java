package com.krieghb.javasnips.experiments.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTester {
	private static final Logger logger = LoggerFactory.getLogger(ThreadTester.class);

	public static void main(String[] args) {
		
		runThreader();
	}
	
	
	public static void runThreader() {
		Threader01 test01 = new Threader01();
//		Threader02 test02 = new Threader02();
		
		test01.start();
//		test02.start();

		
		
		

		String filePath = "C:/Users/krido02/Documents/Java/threadtest.txt";
		String data = "Hi everybody!  This is the Main   2.\n";

//		FileUtilityMethods.writeToFile(filePath, data);
	}

}
