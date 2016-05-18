package com.krieghb.javasnips.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.krieghb.javasnips.utils.NumberConstants.AVG_LOOP;
import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;
import static com.krieghb.javasnips.utils.StringConstants.*;

/**
 * Created by krido02 on 5/11/2016.
 * 
 */
public class LoopyReg {


    private Logger logger = LoggerFactory.getLogger(LoopyReg.class);


    private int matchCount = 0;
    private int nomatchCount = 0;
    
    public Map<String, Long> loopTheRegex() {

        //
        long begin;
        long end;
        long deltaTime;
        
        // Create a Pattern object
        Map<String, Long> patternsCount = new HashMap<>();

        patternsCount.put(STRING_REGEX_LONG, 0L);
        patternsCount.put(STRING_REGEX_ORD, 0L);
        patternsCount.put(STRING_REGEX_MULT, 0L);



        for (Map.Entry<String, ArrayList<String>> regexPatterns : getRegexMap().entrySet()) {

            logger.info("New Regex:  {}", regexPatterns.getKey());

            //  Looping to get an average time for each
            for (int j = 0; j < AVG_LOOP; j++) {
                begin = System.currentTimeMillis();

                //  Looping n number of times to simulate full data set.
                for (int i = 0; i < LOOPY; i++) {

                    //  Looping through each pattern type
                    getVirtualDoc().forEach(eachString -> {
                        //  Looping through each patterns internals
                        for (String newPattern : regexPatterns.getValue()) {
                            Pattern pattern = Pattern.compile(newPattern);
                            Matcher myMatch = pattern.matcher(eachString);
                            if (myMatch.find()) {
                                incrementMatch();
                                break;
                            } else {
                                incrementNoMatch();
                            }
                        }
                    });
                }

                end = System.currentTimeMillis();
                deltaTime = end - begin;
                logger.info("Avg loop #{};  Time:  {}", j, deltaTime);

                patternsCount.replace(regexPatterns.getKey(), patternsCount.get(regexPatterns.getKey()) + deltaTime);
            }

            logger.info("For {};  Matches:  {};   No Match:  {}", regexPatterns.getKey(), getMatch(), getNoMatch());
            resetMatch();
            resetNoMatch();
            logger.info("End Regex\n\n");
        }

        return patternsCount;
    }


    private void incrementMatch() {
        this.matchCount++;
    }
    private void incrementNoMatch() {
        this.nomatchCount++;
    }
    
    private int getMatch() {
        return this.matchCount;
    }
    private int getNoMatch() {
        return this.nomatchCount;
    }
    private void resetMatch() {
        this.matchCount = 0;
    }
    private void resetNoMatch() {
        this.nomatchCount = 0;
    }



}
