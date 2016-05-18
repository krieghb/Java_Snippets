package com.krieghb.javasnips.utils;

/**
 * Created by krido02 on 5/12/2016.
 * 
 *  Tools for Randomness
 *  
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Randomness {

    private static Logger logger = LoggerFactory.getLogger(Randomness.class);
    
    
    private Randomness() {
        //  Making constructor private.
    }
    
    
    /**
     *      To get a random character from a given set of characters (in the form of a String).
     * @param randomPool        String containing all characters to be chosen from
     * @return                  The randomized letter.
     */
    @SuppressWarnings("WeakerAccess")
    public static char getRandomChar(String randomPool) {
        char randomChar;
        int poolLength = randomPool.length();
        Random r = new Random();

        randomChar = randomPool.charAt(r.nextInt(poolLength));
        
        return randomChar;
    }
    /**
     *      To get a random character by calling the parameter versions with the default value.
     * @return                  The randomized letter.
     */
    public static char getRandomChar() {

        String randomPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        
        return getRandomChar(randomPool);
    }
    
}
