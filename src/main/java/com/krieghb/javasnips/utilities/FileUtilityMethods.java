package com.krieghb.javasnips.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class FileUtilityMethods {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtilityMethods.class);
	
	
	public static void writeToFile(String filePath, String dataToWrite) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null; 
        
        try {
            fileWriter = new FileWriter(new File(filePath), true);
            
            bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(dataToWrite);
            
            logger.info("Wrote to file:  {}", dataToWrite);
        }
        catch (FileNotFoundException e) {
            logger.error("[writeToFile]  File not found:\n  {}", UtilityMethods.stackTraceToStr(e).toString());
        }
        catch (NullPointerException e) {
            logger.error("[writeToFile]  Null Pointer:  Path: '{}'.  Response:  '{}'", filePath, dataToWrite);
            logger.error("[writeToFile]  Null Pointer:\n  {}", UtilityMethods.stackTraceToStr(e).toString());
        }
        catch (IOException e) {
            logger.error("[writeToFile]  IO Error:\n  {}", UtilityMethods.stackTraceToStr(e).toString());
        }
        finally {
            SafeClose.safeClose(bufferedWriter);
            SafeClose.safeClose(fileWriter);
        }
    }


    public static String readFromFile(String filePath) {
        StringBuilder outString = new StringBuilder();
        String eachLine;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(new File(filePath));

            bufferedReader = new BufferedReader(fileReader);

            while ((eachLine = bufferedReader.readLine()) != null) {
                outString.append(eachLine);
            }
        }
        catch (FileNotFoundException e) {
            logger.error("File '{}' not found", filePath);
        }
        catch (IOException e) {
            logger.error("IO Exception in readying file '{}'", filePath);
        }



        return outString.toString();
    }
}
