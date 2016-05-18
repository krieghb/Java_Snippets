package com.krieghb.javasnips.experiments.thread;

import com.krieghb.snippets.utilities.SafeClose;

import java.io.*;

//import com.krieghb.snippets.utilities.UtilityMethods;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.krieghb.snippets.utilities.FileUtilityMethods;
//import com.krieghb.snippets.utilities.UtilityMethods;

public class Threader01 extends Thread  {
	
//	private static final Logger logger = LoggerFactory.getLogger(Threader01.class);
	
	String filePath = "C:/Users/krido02/Documents/Java/threadtest.txt";
	String data = "Hi everybody!  This is Thread01.\n";
	
	public void run() {
		System.out.println("In Threader01 and running it.");
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
//		FileUtilityMethods.writeToFile(filePath, data);
		
		
		FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null; 
        
        try {

        	File file = new File(filePath);
        	if (file.canWrite()) {
//        		logger.info("[Threader01] - YOU CAN WRITE IT!");
        		System.out.println("[Threader01] - YOU CAN WRITE IT!");
        	}
        	else {
//        		logger.info("[Threader01] - YOU CAN NOT WRITE IT SO STOP!");
        		System.out.println("[Threader01] - YOU CAN NOT WRITE IT SO STOP!");
        	}
        	
            fileWriter = new FileWriter(file);
            
            bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(data);
        }
        catch (FileNotFoundException e) {
//            logger.error("[Threader01]  File not found:\n  {}", UtilityMethods.stackTraceToStr(e).toString());
            System.out.println("[Threader01]  - File not found");
        }
        catch (NullPointerException e) {
//            logger.error("[Threader01]  Null Pointer:  Path: '{}'.  Response:  '{}'", filePath, data);
//            logger.error("[Threader01]  Null Pointer:\n  {}", UtilityMethods.stackTraceToStr(e));
            System.out.println("[Threader01]  - Null Pointer");
        }
        catch (IOException e) {
//            logger.error("[Threader01]  IO Error:\n  {}", UtilityMethods.stackTraceToStr(e));
            System.out.println("[Threader01]  - IO Error");
        }
        finally {
        	try {
        		Thread.sleep(1000);
        	}
        	catch (InterruptedException e) {
//                logger.error("[Threader01]  InterruptedException:\n  {}", UtilityMethods.stackTraceToStr(e));
                System.out.println("[Threader01]  - InterruptedException while sleeping");
        	}
            SafeClose.safeClose(bufferedWriter);
            SafeClose.safeClose(fileWriter);
        }
		
		System.out.println("In Threader01 and leaving it.");
		
	}


}
