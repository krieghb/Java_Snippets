package com.krieghb.javasnips.main;


import com.krieghb.javasnips.experiments.dcdtests.BDValidator;
import com.krieghb.javasnips.experiments.dcdtests.ChiValidator;
import com.krieghb.javasnips.experiments.dcdtests.ChiValidatorFixed;
import com.krieghb.javasnips.experiments.dcdtests.ChiValidatorFixed2;
import com.krieghb.javasnips.regex.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


//        RegexParen regexParen = new RegexParen();
//        regexParen.testParanthesis();

//        RegexMain regexMain = new RegexMain();
//        regexMain.testReg();
//        regexMain.testLookaheads();
//        regexMain.testLoop();

//        logger.info("\n\n\n");
//        logger.info(Randomness.getRandomChar("hi") + "");
//        logger.info("\n\n\n");

//        testRegs();


//        ReadShakes readShakes = new ReadShakes();
//        readShakes();


//        Regex regex = new Regex();
//        regex.testSsnReg();

//        testJ();

//        testDate();

//        testSSNCanada();
//        testCHI();
//
//        testStreet();

        testClassdate();


//        String classTest = "[\\a]";
//        String ssnTest = "(?!({rep}\\d){\\rep}{2}({rep_delim}[ .|-]){\\rep}{2}{\\rep_delim}{\\rep}{4})(?!078({ssn_delim1}[ .|-])05{\\ssn_delim1}1120)(?!219({ssn_delim2}[ .|-])09{\\ssn_delim2}9999)(?!000|666|9[0-9]{2})[0-9]{3}({ssn_delim}[ .|-])(?!00)[0-9]{2}{\\ssn_delim}(?!0000)[0-9]{4}";
//        String austTest = "((?i)(?=.{2}\\d{2})(?=(?:.*\\d){4})(?=(?:(?:[^a-z]*[a-z][^a-z]*){0,2}|\\d+))[a-z0-9]{4,9})";
//
//
//        String anotherOne = "\\b34\\b";
////        Pattern pattern = Pattern.compile(coOne);
////        Matcher matcher = pattern.matcher("12-123-1234");
//        jregex.Pattern pattern = new jregex.Pattern(austTest);
////        jregex.Matcher matcher = pattern.matcher("00500321Turnpike     Lam    \\     P22W490 Highway -#34# #      Daytona    FL03091T651-545-81-071-0046870  0780.51.1201");
//        jregex.Matcher matcher = pattern.matcher("F23DD6D789");
//
//        if (matcher.find()) {
//            logger.info("Found the match:  '{}'", matcher.group(0));
//        }
//        else {
//            logger.info("Did NOT find the match");
//        }

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

    public static void testJ() {
        jregex.Pattern jPat = new jregex.Pattern("([0-9]{3}({ssn_delim}[ .|-]?)[0-9]{2}{\\ssn_delim}[0-9]{4})");
        jregex.Matcher jMat;
        String foo = "123|45|6789";
        jMat = jPat.matcher(foo);

        if (jMat.find()) {
            logger.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            logger.info("No matched pattern.");
        }

    }



    public static void testDate() {
        BDValidator bdValidator = new BDValidator();
        String myDate = "2/0/12";
        logger.info("Is '{}' a valid?  {}", myDate, bdValidator.validate(myDate) == 0 ? "yes" : "no");

    }

    public static void testSSNCanada() {
        String ssnPat = "(\\d{3}[-?]\\d{3}[-?]\\d{3}|\\d{3}[\\s?]\\d{3}[\\s?]\\d{3}|\\d{3}[.?]\\d{3}[.?]\\d{3})";
        String toSearch = "123123123";
        jregex.Pattern jPat = new jregex.Pattern(ssnPat);
        jregex.Matcher jMat = jPat.matcher(toSearch);

        if (jMat.find()) {
            logger.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            logger.info("No matched pattern.");
        }
    }

    public static void testCHI() {
        String chiPat = "((0[1-9]|[1-2][0-9]|30|31)(0[1-9]|10|11|12)([1-9][0-9])(.|-|\\s)?([0-9][0-9][0-9][0-9]))";
//        String chiSearch = "310480-1234";
        String chiSearch = "999999-1234";

        ChiValidator chiValidator = new ChiValidator();
        ChiValidatorFixed chiValidatorFixed = new ChiValidatorFixed();
        ChiValidatorFixed2 chiValidatorFixed2 = new ChiValidatorFixed2();

        jregex.Pattern jPat = new jregex.Pattern(chiPat);
        jregex.Matcher jMat = jPat.matcher(chiSearch);

        if (jMat.find()) {
            logger.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            logger.info("No matched pattern.");
        }
        int Val1 = chiValidator.validate(chiSearch);
        int Val2 = chiValidatorFixed.validate(chiSearch);
        int Val3 = chiValidatorFixed2.validate(chiSearch);
        logger.info("Valide CHI?  {}", Val1);
//        logger.info("Validated Fixed1 CHI?  {}", Val2);
//        logger.info("Val1:  Is it Valid?  {}", Val2 == 0 ? "Yes": "NO");
        logger.info("Val3:  {}",  Val3);
    }


    public static void testStreet(){
        String strPat = "(\\d{1,4} [a-zA-z\\s]{1,20}(?:AVENUE|Avenue|BOULEVARD|Boulevard|BLVD|Blvd|BYPASS|Bypass|BYP|Byp|CENTER|Center|CTR|Ctr|COURT|Court|CRESCENT|Crescent|CRECENT|Crecent|CRES|Cres|CREST|Crest|CRST|Crst|CROSSING|Crossing|XING|Xing|CROSSROAD|Crossroad|XRD|Xrd|DRIVE|Drive|FREEWAY|Freeway|FWY|Fwy|GATEWAY|Gateway|GTWY|Gtwy|HIGHWAY|Highway|HWY|Hwy|JUNCTION|Junction|JCT|Jct|KNOLL|Knoll|KNL|Knl|LANE|Lane|LN|Ln|MANOR|Manor|MNR|Mnr|MOTORWAY|Motorway|MTWY|Mtwy|PARKWAY|Parkway|PKWY|Pkwy|PARKWY|Parkwy|PLAZA|Plaza|PLZ|Plz|ROAD|Road|ROUTE|Route|RTE|Rte|RUE|Rue|SQUARE|Square|SQ|Sq|SQR|Sqr|STREET|Street|STR|Str|STRT|Strt|STREETS|Streets|STS|Sts|SUMMIT|Summit|SMT|Smt|VALLEY|Valley|VLY|Vly)\\W?(?=\\s|$))";
        String toSearch = "One Center Center";

        jregex.Pattern jPat = new jregex.Pattern(strPat);
        jregex.Matcher jMat = jPat.matcher(toSearch);

        if (jMat.find()) {
            logger.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            logger.info("No matched pattern.");
        }


    }


    public static void testClassdate() {
        String datePat = "((?:(?<!\\:)(?<!\\:\\d)[0-3]?\\d(?:st|nd|rd|th)?\\s+(?:of\\s+)?(?:jan\\.?|january\\.?|JAN\\.?|JANUARY\\.?|January|feb\\.?|february\\.?|FEB\\.?|FEBRUARY\\.?|February|mar\\.?|march\\.?|MAR\\.?|MARCH\\.?|March|apr\\.?|april\\.?|APR\\.?|APRIL\\.?|April|may\\.?|May\\.?|MAY|jun\\.?|june\\.?|JUNE\\.?|JUN\\.?|June|jul\\.?|july\\.?|JUL\\.?|JULY\\.?|July|aug\\.?|august\\.?|AUG\\.?|AUGUST\\.?|August|sep\\.?|september\\.?|SEPTEMBER\\.?|SEPT\\.?|September|oct\\.?|october\\.?|OCT\\.?|OCTOBER\\.?|October|nov\\.?|november\\.?|November\\.?|NOV\\.?|NOVEMBER|dec\\.?|december\\.?|DEC\\.?|DECEMBER\\.?|December)|(?:jan\\.?|january\\.?|JAN\\.?|JANUARY\\.?|January|feb\\.?|february\\.?|FEB\\.?|FEBRUARY\\.?|February|mar\\.?|march\\.?|MAR\\.?|MARCH\\.?|March|apr\\.?|april\\.?|APR\\.?|APRIL\\.?|April|may\\.?|May\\.?|MAY|jun\\.?|june\\.?|JUNE\\.?|JUN\\.?|June|jul\\.?|july\\.?|JUL\\.?|JULY\\.?|July|aug\\.?|august\\.?|AUG\\.?|AUGUST\\.?|August|sep\\.?|september\\.?|SEPTEMBER\\.?|SEPT\\.?|September|oct\\.?|october\\.?|OCT\\.?|OCTOBER\\.?|October|nov\\.?|november\\.?|November\\.?|NOV\\.?|NOVEMBER|dec\\.?|december\\.?|DEC\\.?|DECEMBER\\.?|December)" +
                                                                                                                                                                                                                                                                                "\\s+(?<!\\:)(?<!\\:\\d)[0-3]?\\d(?:st|nd|rd|th)?)(?:\\,)?\\s*(?:\\d{4})?|[0-3]?\\d[-\\./][0-3]?\\d[-\\./]\\d{2,4})";
        String newPat = "(?i)(?:(?:(?:0[1-9]|[12][0-9]|3[01])(?:st|nd|rd|th)?\\s+(?:of\\s+)?(?:jan[.]?|january|feb[.]?|february|mar[.]?|march|apr[.]?|april|may|jun[.]?|june|jul[.]?|july|aug[.]?|august|sep[.]?|september|oct[.]?|october|nov[.]?|november|dec[.]?|december)\\s+(?:0[1-9]|[12][0-9]|3[01])(?:st|nd|rd|th)?\\s+,?\\s*(?:\\d{4}))|(?:0[1-9]|1[12]({date_delim1}[/.-])0[1-9]|1[0-9]|2[0-9]|3[01]{\\date_delim1}(\\d{2}|\\d{4})))";
        String toSearch = "33rd of JAN, 20";

        jregex.Pattern jPat = new jregex.Pattern(newPat);
        jregex.Matcher jMat = jPat.matcher(toSearch);

        if (jMat.find()) {
            logger.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            logger.info("No matched pattern.");
        }


    }
}
