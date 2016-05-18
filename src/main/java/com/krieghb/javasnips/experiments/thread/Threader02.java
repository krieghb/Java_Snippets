package com.krieghb.javasnips.experiments.thread;

import com.krieghb.javasnips.utilities.SafeClose;
import com.krieghb.javasnips.utilities.UtilityMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Threader02 extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(Threader02.class);

	String filePath = "C:/Users/krido02/Documents/Java/threadtest.txt";
	String data = "Hi everybody!  This is Thread02.\n";
	
	
	
	
	public void run() {
		System.out.println("In Threader02 and running it.");
		try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

		
		
		FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null; 
        
        try {

        	File file = new File(filePath);
        	if (file.canWrite()) {
        		logger.info("[Threader02] - YOU CAN WRITE IT!");
        	}
        	else {
        		logger.info("[Threader02] - YOU CAN NOT WRITE IT SO STOP!");
        	}
        	
            fileWriter = new FileWriter(file);
            
            bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(data);
        }
        catch (FileNotFoundException e) {
            logger.error("[Threader02]  File not found:\n  {}", UtilityMethods.stackTraceToStr(e).toString());
        }
        catch (NullPointerException e) {
            logger.error("[Threader02]  Null Pointer:  Path: '{}'.  Response:  '{}'", filePath, data);
            logger.error("[Threader02]  Null Pointer:\n  {}", UtilityMethods.stackTraceToStr(e));
        }
        catch (IOException e) {
            logger.error("[Threader02]  IO Error:\n  {}", UtilityMethods.stackTraceToStr(e));
        }
        finally {
            SafeClose.safeClose(fileWriter);
            SafeClose.safeClose(bufferedWriter);
        }
		
		
		System.out.println("In Threader02 and leaving it.");
		
	}
}
