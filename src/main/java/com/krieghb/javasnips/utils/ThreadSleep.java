package com.krieghb.javasnips.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dk
 */


public class ThreadSleep {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSleep.class);



    public static void sleepForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            LOGGER.error("Thread was interrupted during its slumber.");
        }
    }
}
