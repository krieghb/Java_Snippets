package com.krieghb.javasnips.main;


import com.krieghb.javasnips.regex.LoopyReg;

import com.krieghb.javasnips.regex.JregexMain;
import com.krieghb.javasnips.regex.RegexMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krieghb.javasnips.utils.Randomness;

import java.util.Map;

import static com.krieghb.javasnips.utils.NumberConstants.AVG_LOOP;
import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;


/**
 * Created by krido02 on 5/5/2016.
 * 
 * 
 */
public class JavaSnipsMain {
    
    private static Logger logger = LoggerFactory.getLogger(JavaSnipsMain.class);
    
    
    public static void main (String[] args) {


        RegexMain regexMain = new RegexMain();
//        regexMain.testReg();
        regexMain.testLookaheads();
//        regexMain.testLoop();

//        logger.info("\n\n\n");
//        logger.info(Randomness.getRandomChar("hi") + "");
//        logger.info("\n\n\n");

//        testRegs();
        
    }

    public static void testRegs() {
        Map<String, Long> regexPat;
        Map<String, Long> jregexPat;



        LoopyReg loopyReg = new LoopyReg();
        regexPat = loopyReg.loopTheRegex();

        JregexMain jregexMain = new JregexMain();
        jregexPat = jregexMain.JRegLoopy();


        logger.info("Number of Loops:  {};   Avg Loop #:  {}", LOOPY, AVG_LOOP);
        logger.info("Average time of RegEx for each pattern type:  ");
        for (Map.Entry<String, Long> patPair : regexPat.entrySet()) {
            logger.info("Pattern:    {};     Avg Time(ms):  {}", patPair.getKey(), (patPair.getValue() / AVG_LOOP));
        }

        logger.info("");

        logger.info("Average time of JRegex for each pattern type:  ");
        for (Map.Entry<String, Long> jPatPair : jregexPat.entrySet()) {
            logger.info("Pattern:    {};     Avg Time(ms):  {}", jPatPair.getKey(), (jPatPair.getValue() / AVG_LOOP));
        }
    }
    
}
