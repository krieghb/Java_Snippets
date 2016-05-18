package com.krieghb.javasnips.utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by barsc09 on 10/23/2015.
 */
public class SafeClose {

    private static final Logger logger = LoggerFactory.getLogger(SafeClose.class);

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error("[safeClose] - Failed to Close InputStream: {}", e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public static void safeClose(BufferedWriter bufferedWriter) {
        if (bufferedWriter != null) {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                logger.error("[safeClose] - Failed to Close BufferedWriter: {}", e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void safeClose(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                logger.error("[safeClose] - Failed to Close BufferedReader: {}", e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void safeClose(FileWriter fileWriter) {
        if (fileWriter != null) {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                logger.error("[safeClose] - Failed to Close FileWriter: {}", e.getMessage());
                e.printStackTrace();
            }
        }
    }

    
    public static void safeClose(Stream<Path> path) {
        if (path != null) {
            try {
                path.close();
            }
            catch (Exception e) {
                logger.error("[safeClose] - Failed to Close Stream<Path>: {}", e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    public static void safeClose(ApplicationContext context) {
        if (context != null) {
            if (context instanceof  AnnotationConfigApplicationContext) {
                ((AnnotationConfigApplicationContext) context).close();
            }
            else {
                logger.info("[safeClose ApplicationContext] - Undefined Context type, did not close context. ");
            }
        }
    }
}
