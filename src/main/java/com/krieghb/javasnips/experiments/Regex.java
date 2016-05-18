package com.krieghb.javasnips.experiments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public class Regex {

    Logger logger = LoggerFactory.getLogger(Regex.class);

    public boolean testReg() {
        boolean isPresent = false;

        String search2 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO 8009188365123400654";
        String search3 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO 09141998H0001579826200000239";
        String search4 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO L09141998H0002579826200000239";
        String search5 = "0050981Pond          Melody      456 Doctors Ave          Denver     CO 09141998H0002479826200000239";


        String ctPattern = "((0[1-9])|(1[0-9])|(2[0-4]))[0-9]{7}";
        String coPattern1 = "(\\d{2}-?((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6]))-?\\d{4})";
        String coPattern2 = "([a-zA-Z]\\d{3,6})";
        String wbPattern = "\b80[0-9]|81[0-6][0-9]{2}\b|\b80[0-9]|81[0-6][0-9]{2}[0-9]{4}\b";

        String anotherTest = "(123[0-2]|456[4-6][8-9]{2})";
        String anotherWord = "123088";

        String boundaryTest = "\\b\\d[ab]{2}|[cd]\\d\\b";
        String boundaryWord = "5ab";



        String word_test = "\\b((80[0-9])|(81[0-6]))[0-9]{2}\\b";
        String word_test2 = "\\b80[0-9]|81[0-6][0-9]{2}\\b";
        String word_test3 = "\\b((80[0-9])|(81[0-6]))[0-9]{2}\\b";
        String noParanPat= "\\b527|6[01][0-9]|62[3-9]|634[0-9]{2}\\b";
        String withParanPat= "(\\b(((527)|(6[01][0-9])|(62[3-9])|(634))[0-9]{2})\\b)";

        String wordPost = "PRE63445";
        String wordPre = "52712POST";
        String wordMid1 = "PRE60111POST";
        String wordMid2 = "PRE6234555555POST";


        // Create a Pattern object
        Pattern regPattern = Pattern.compile(noParanPat);

        // Now create matcher object.
        Matcher regMatcher = regPattern.matcher(wordPost);


        logger.info("Group Count:  " + regMatcher.groupCount());
        if (regMatcher.find( )) {
            isPresent = true;

            for (int i = 0; i <= regMatcher.groupCount(); i++) {
                logger.info("FOUND MATCH:  '{}';   in group #{}", regMatcher.group(i), i );
            }
        }
        else {
            logger.info("NO MATCH to '{}'", regPattern.pattern());
        }
        return isPresent;
    }

}
