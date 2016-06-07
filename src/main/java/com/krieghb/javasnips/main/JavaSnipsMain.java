package com.krieghb.javasnips.main;


import com.krieghb.javasnips.experiments.BDValidator;
import com.krieghb.javasnips.regex.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.krieghb.javasnips.utils.NumberConstants.AVG_LOOP;
import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;
import static com.krieghb.javasnips.utils.StringConstants.NON_CAPTURE_JREG;


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

        testDate();



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
        logger.info("Validated?:  {}", bdValidator.validate(myDate));

    }
}
