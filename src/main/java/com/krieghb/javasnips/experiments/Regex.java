package com.krieghb.javasnips.experiments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
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



    public void testSsnReg() {

        ArrayList<String> validStrings = new ArrayList<>(Arrays.asList("123-45-6789", "123-12-0001", "111.11.1112", "812|11|1234", "123\\98\\123"));
        ArrayList<String> inValidStrings = new ArrayList<>(Arrays.asList("000-00-0000", "111111111", "123.55.0000", "000|88|6548", "123-00-0192", "666-12-1234", "999-12-9391"));

        String ssnValid = "123-45-6789";
        String ssnValid2 = "123-12-0001";
        String ssnValid3 = "111.11.1112";
        String ssnInvalid = "000-00-0000";
        String ssnInvalid2 = "123-01-0000";
        String ssnInvalid3 = "111111111";
        String myPattern = "(?!({rep}\\d){\\rep}{8})(\\d{9})";
        String myPattern2 = "(?!({rep}\\d){\\rep}{2}({ssn_delim}[ .|-]?){\\rep}{2}{\\ssn_delim}{\\rep}{3})(\\d{3}{\\ssn_delim}\\d{2}{\\ssn_delim}\\d{4})";
        String myPattern3 = "(\\d{3}({ssn_delim_a}[ .|-]?)\\d{2}{\\ssn_delim_a}\\d{4})";
        String myPattern4 = "(?!({rep}\\d){\\rep}{2}({ssn_delim_n}[ .|-]?){\\rep}{2}{\\ssn_delim_n}{\\rep}{4})(\\d{9})([0-9]{3}({ssn_delim}[ .|-]?)[0-9]{2}{\\ssn_delim}[0-9]{4})";
        String myPattern1 = "(?!({rep}\\d){\\rep}{2}({delim}[ .]?){\\rep}{2}{\\delim}{\\rep}{4})(\\d{3}({ssn_delim}[ .|-]?)\\d{2}{\\ssn_delim}\\d{4})";
        String myPattern5 = "(?!({rep}\\d){\\rep}{2}({delim}[ .|-]?){\\rep}{2}{\\delim}{\\rep}{4})(?!000|666|9[0-9]{2})[0-9]{3}({ssn_delim}[ .|-]?)(?!00)[0-9]{2}{\\ssn_delim}(?!0000)[0-9]{4}";

        String ssnPattern = "((?!\\b(\\d)\\3+-(\\d)\\3+-(\\d)\\2+\\b)(?!000|666|9[0-9]{2})[0-9]{3}({ssn_delim}[ .|-]?)(?!00)[0-9]{2}{\\ssn_delim}(?!0000)[0-9]{4})";

        String ssnGoodPattern = "(?!({rep}\\d){\\rep}{2}({rep_delim}[ .|-]?){\\rep}{2}{\\rep_delim}{\\rep}{4})(?!000|666|9[0-9]{2})[0-9]{3}({ssn_delim}[ .|-]?)(?!00)[0-9]{2}{\\ssn_delim}(?!0000)[0-9]{4}";

        String anotherPatter = "([0-9]{3}[\\.|-][0-9]{2}[\\.|-][0-9]{4})";

        jregex.Pattern jPat = new jregex.Pattern(ssnGoodPattern);
        jregex.Matcher matcher;

        // For invalid
        for (String invalid : inValidStrings) {
            matcher = jPat.matcher(invalid);
            if (matcher.find()) {
                logger.info("Incorrectly Found match for invalid . . .:  {}", matcher.group(0));
            }
            else {
                logger.info("Correctly did not find match for invalid string: {}", invalid);
            }
        }


        //  For valid
        for (String valid : validStrings) {
            matcher = jPat.matcher(valid);

            if (matcher.find()) {
                logger.info("Correctly Found match for Valid . . .:  {}", matcher.group(0));
            } else {
                logger.info("Incorrectly did not find match for valid string: {}", valid);
            }
        }





    }

}
