package com.krieghb.javasnips.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.krieghb.javasnips.utils.NumberConstants.AVG_LOOP;
import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;
import static com.krieghb.javasnips.utils.StringConstants.*;

/**
 * Created by krido02 on 5/26/2016.
 *
 *
 */
public class ReadShakes {

    private static Logger logger = LoggerFactory.getLogger(ReadShakes.class);



    private int matchCount = 0;
    private int nomatchCount = 0;



//    private String shakespearPath = "C:\\Users\\krido02\\Documents\\Complete Wks Shakespear pg100.txt";
    private StringBuilder shakespearText = new StringBuilder();

    private String phNum = "((?:(?<![\\d-])(?:\\+?\\d{1,3}[-\\.\\s*]?)?(?:\\(?\\d{3}\\)?[-\\.\\s*]?)?\\d{3}[-\\.\\s*]?\\d{4}(?![\\d-]))|(?:(?<![\\d-])(?:(?:\\(\\+?\\d{2}\\))|(?:\\+?\\d{2}))\\s*\\d{2}\\s*\\d{3}\\s*\\d{4}(?![\\d-])))";

    String austDLOrig = "(?i)(?=.{2}\\d{2})(?=(?:.*\\d){4})(?=(?:(?:[^a-z]*[a-z][^a-z]*){0,2}|\\d+))[a-z0-9]{4,9}";
    private String coloradoPatt = "((\\d{2}({dash}[-]?)((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6])){\\dash}\\d{4})|([a-zA-Z]\\d{6}))";
    private String coloradoPatt2 = "((\\d{2}(?<dash>[-]?)((00[1-9])|(0[1-9][0-9])|([1-2][0-9][0-9])|(3[0-5][0-9])|(36[0-6]))\\k<dash>\\d{4})|([a-zA-Z]\\d{6}))";


    String austPPN = "(?i)(?:(?![IOQS])[A-Z]){1}[0-9]{7}";
    String austPPN2 = "(?i)(?![IOQS])[A-Z][0-9]{7}";

    String donate = "The Complete";

    private jregex.Pattern pattern = new jregex.Pattern(donate);
    private jregex.Matcher matcher;
//    private Matcher matcher;
    private Matcher matcherReg;
    private Pattern patt2 = Pattern.compile(donate);
    private Matcher match;

    //
    long begin;
    long end;
    long deltaTime;



    public ReadShakes() {
        getText();
    }



    public void getText() {
        int regCounter = 0;
        int jCounter = 0;

        StringBuilder outString = new StringBuilder();
        String eachLine;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;






        Map<String, Long> patternsCount = new HashMap<>();

        getRegexMap().forEach((key,val) -> {
            patternsCount.put(key, 0L);
        });
//        patternsCount.put(STRING_REGEX_LONG, 0L);
//        patternsCount.put(STRING_REGEX_ORD, 0L);
//        patternsCount.put(STRING_REGEX_MULT, 0L);
//        patternsCount.put(STRING_REGEX_PRIM_OPT, 0L);
//        patternsCount.put(STRING_REGEX_PRIM_ORIG, 0L);
//        patternsCount.put(STRING_REGEX_PRIM_OPT_LONG, 0L);
//        patternsCount.put(STRING_REGEX_PRIM_ORIG_LONG, 0L);

//        logger.info("REGEXes:  {}", getRegexMap());

        boolean foundit;
        for (Map.Entry<String, ArrayList<String>> regexPatterns : getRegexMap().entrySet()) {
            long begin, beginMain;
            long end, endMain;
            long deltaTime, deltaTimeMain;

            logger.info("New J-Regex:  {}", regexPatterns.getKey());

            //  Looping to get an average time for each
            for (int j = 0; j < AVG_LOOP; j++) {
                if (j % 1000 == 0) {
                    logger.info("Loop: {}/{},  Current # of matches:  {}", j + 1, AVG_LOOP, getMatch());
                }

                beginMain = System.currentTimeMillis();

                for (String filePath : SHAKESPEAR_LIST) {
                    foundit = false;
//                    logger.info("File:  {}", filePath);

                    try {

                        begin = System.currentTimeMillis();
                        for (String newPattern : regexPatterns.getValue()) {
                            if (foundit) {
                                break;
                            }
                              jregex.Pattern loopPattern = new jregex.Pattern(newPattern);
//                            Pattern loopPattern = Pattern.compile(newPattern);
//                            logger.info("Pattern:  {}", newPattern);

                            fileReader = new FileReader(new File(filePath));

                            bufferedReader = new BufferedReader(fileReader);
                            eachLine = bufferedReader.readLine();
                            while (eachLine != null) {
                                matcher = loopPattern.matcher(eachLine);
                                eachLine = bufferedReader.readLine();

                                if (matcher.find()) {
//                                        logger.info("J Found match:  '{}'   using:  '{}'", matcher.group(0), loopPattern);
                                    incrementMatch();
                                    foundit = true;
                                    eachLine = null;
                                }
                            }
                        }

                        end = System.currentTimeMillis();
                        deltaTime = end - begin;

                        patternsCount.replace(regexPatterns.getKey(), patternsCount.get(regexPatterns.getKey()) + deltaTime);

                    } catch (FileNotFoundException e) {
                        logger.error("File '{}' not found", filePath);
                    } catch (IOException e) {
                        logger.error("IO Exception in readying file '{}'", filePath);
                    }
                }

                endMain = System.currentTimeMillis();
                deltaTimeMain = endMain - beginMain;
//                    logger.info("Main loop #{};  Time:  {}", j, deltaTimeMain);

//                patternsCount.replace(regexPatterns.getKey(), patternsCount.get(regexPatterns.getKey()) + deltaTimeMain);

            }

            logger.info("For {};  Matches:  {};   No Match:  {}", regexPatterns.getKey(), getMatch(), getNoMatch());
            resetMatch();
            resetNoMatch();


            logger.info("End J-Regex\n\n");


        }


        logger.info("Looped {} times.", AVG_LOOP);
        patternsCount.forEach((pat, cnt) -> {
            logger.info("Pattern:  {};  Count:  {} ms;  AVG Time {} ms", pat, cnt, cnt / AVG_LOOP);
        });


//        try {
//            fileReader = new FileReader(new File(filePath));
//
//            bufferedReader = new BufferedReader(fileReader);
//
//
//            begin = System.currentTimeMillis();
//            while ((eachLine = bufferedReader.readLine()) != null) {
//                matcher = pattern.matcher(eachLine);
//
//                if (matcher.find()) {
////                    for (int j = 0; j < matcher.groupCount(); j++) {
//                    logger.info("J Found match:  {}", matcher.group(0));
//                }
////                    break;
////                }
//
//            }
//
//            end = System.currentTimeMillis();
//            deltaTime = end - begin;
//            logger.info("J Time:  {} ms", deltaTime);
//
//
//
//            fileReader = new FileReader(new File(filePath));
//            bufferedReader = new BufferedReader(fileReader);
//            begin = System.currentTimeMillis();
//            while ((eachLine = bufferedReader.readLine()) != null) {
//                match = patt2.matcher(eachLine);
//
//                if (match.find()) {
////                    for (int j = 0; j < matcher.groupCount(); j++) {
//                    logger.info("Reg Found match:  {}", match.group(0));
//                }
////                    break;
////                }
//
//            }
//
//            end = System.currentTimeMillis();
//            deltaTime = end - begin;
//            logger.info("Reg Time:  {} ms", deltaTime);
//        }
//        catch (FileNotFoundException e) {
//            logger.error("File '{}' not found", filePath);
//        }
//        catch (IOException e) {
//            logger.error("IO Exception in readying file '{}'", filePath);
//        }
//
//        String shakespearTextStr = FileUtilityMethods.readFromFile(shakespearPath);
//
//        int loopit = 1;
//
//        begin = System.currentTimeMillis();
//        for (int j = 0 ; j < loopit; j++) {
//            matcher = pattern.matcher(shakespearTextStr);
//            logger.info("J Start: {}", matcher.start());
//            if (matcher.find())
//            logger.info("J ugh:  {}", matcher.toString());
//            while (matcher.find()) {
//                logger.info("Found Match in J full string:  {}", matcher.group(0));
//                jCounter += 1;
//            }
//        }
//        end = System.currentTimeMillis();
//        deltaTime = end - begin;
//        logger.info("J Full String Time:  {} ms;   Counts: {}", deltaTime, jCounter);
//
//
//
//        begin = System.currentTimeMillis();
//        for (int j = 0 ; j < loopit; j++) {
//            match = patt2.matcher(shakespearTextStr);
////            logger.info("Reg Start: {}", match.start());
//            while (match.find()) {
//                logger.info("Found Match in Regex full string:  {}", match.group(0));
//                regCounter += 1;
//            }
//        }
//        end = System.currentTimeMillis();
//        deltaTime = end - begin;
//        logger.info("Reg Full String Time:  {} ms;  Counts:  {}", deltaTime, regCounter);

        logger.info("Exiting getText");

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
