package com.krieghb.javasnips.regex;


import com.krieghb.javasnips.utils.Incrementer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static com.krieghb.javasnips.utils.NumberConstants.AVG_LOOP;
import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;
import static com.krieghb.javasnips.utils.StringConstants.VARIOUS_PARAGRAPH;

/**
 * Created by krido02 on 5/18/2016.
 *
 */
public class RegexParen {

    private static Logger logger = LoggerFactory.getLogger(RegexParen.class);



    public void testParanthesis() {
        logger.info("");
        //
        long begin;
        long end;
        long deltaTime;

        Incrementer incrementer = new Incrementer();

        String oneParen = "([AB]|[CD]|[DE]|[FG])\\d{3}";
        String mulParen = "(([AB])|([CD])|([DE])|([FG]))(\\d{3})";
        String basicParn = "([ABCDEFG]{2}\\d{3})";
        String lookPatt = "";

        String blah = "(?i)(?:(?![IOQS])[A-Z]){1}[0-9]{7}";
        String blah2 = "(?i)(?![IOQS])[A-Z][0-9]{7}";
        String blah3 = "(?i)(?:(?![IOQS])[A-Z])[0-9]{7}";
        String blah4 = "(?i)(?![IOQS])[A-Z]{1}[0-9]{7}";
        String blahString = "A1234567";

        String austDLOrig = "(?i)(?=.{2}\\d{2})(?=(?:.*\\d){4})(?=(?:(?:[^a-z]*[a-z][^a-z]*){0,2}|\\d+))[a-z0-9]{4,9}";
        String austDL = "(?i)(?=.{2}\\d{2})(?:.*\\d){4}(?:(?:[^a-z]*[a-z][^a-z]*){0,2}|\\d+)";
        String austStr = "aaaa1aaaa2aaaa3aaaa4A1234AaA";
        String hmm = "ab(?=.{1}\\d{1})\\$a1";

        Pattern p = Pattern.compile(austDL);

        String abn = "\\d{2}(\\s|-|.)?\\d{3}(\\s|-|.)?\\d{3}(\\s|-|.)?\\d{3}";
        String abn2 = "\\d{2}[\\s.-]?\\d{3}[\\s.-]\\d{3}[\\s.-]?\\d{3}";
        String abn3 = "\\d{2}({abnDelim}[\\s.-]?)\\d{3}{\\abnDelim}\\d{3}{\\abnDelim}\\d{3}";
        String abnString = "53.004-085-616";


        String phoneNumOrig = "((?:(?<![\\d-])(?:\\+?\\d{1,3}[-\\.\\s*]?)?(?:\\(?\\d{3}\\)?[-\\.\\s*]?)?\\d{3}[-\\.\\s*]?\\d{4}(?![\\d-]))|(?:(?<![\\d-])(?:(?:\\(\\+?\\d{2}\\))|(?:\\+?\\d{2}))\\s*\\d{2}\\s*\\d{3}\\s*\\d{4}(?![\\d-])))";
        String phoneNumStr = "(+60) 12 123 1234";
        String phNumStr = "1993-1199";
        String phoneNumStr2 = "abc defghij223-123abc happy birthday to you (123)123123) hava a merry christmas(+60) 12 123 1234";

        String phoneNum1   = "(?<![\\d-])(?:\\+?\\d{1,3}[-\\.\\s*]?)?(?:\\(?\\d{3}\\)?[-\\.\\s*]?)?\\d{3}[-\\.\\s*]?\\d{4}(?![\\d-])";
        String phoneNum2 =   "(?<![\\d-])(?:(?:\\(\\+?\\d{2}\\))|(?:\\+?\\d{2}))\\s*\\d{2}\\s*\\d{3}\\s*\\d{4}(?![\\d-])";
        String phoneNumEd1 = "(?<![\\d-])(\\+?\\d{1,3}[-\\.\\s*]?)?(\\(?\\d{3}\\)?[-\\.\\s*]?)?\\d{3}[-\\.\\s*]?\\d{4}(?![\\d-])";
        String phoneNumEd2 = "(?<![\\d-])(\\(\\+?\\d{2}\\))|(\\+?\\d{2})\\s*\\d{2}\\s*\\d{3}\\s*\\d{4}(?![\\d-])";

        jregex.Pattern paa = new jregex.Pattern(phoneNumOrig);
        jregex.Matcher match = paa.matcher(phNumStr);

        if (match.find()) {
            logger.info("YUP!");
            logger.info("Matched:  {}", match.group(0));
            for (int i = 0; i < match.groupCount(); i++) {
//            while (match.find())
                logger.info("Matched group:  {}", match.group(i));
            }
        }

        String parenString = "A123";

        Map<String, String> patMap = new HashMap<>();
        Map<String, Long> mapCount = new HashMap<>();
        String oneString = "One Parenthesis";
        String multString = "Multiple Parentheses";
        String basicString = "Basic Simple (no Ors)";
        String phoneOrig = "Phone Original Long";
        String phoneOrig1 = "Phone Original 1";
        String phoneOrig2 = "Phone Original 2";
        String phoneEdit1 = "Phone Edited 1";
        String phoneEdit2 = "Phone Edited 2";

//        patMap.put(oneString, oneParen);
//        patMap.put(multString, mulParen);
//        patMap.put(basicString, basicParn);
//        patMap.put(phoneOrig, phoneNumOrig);
//        patMap.put(phoneOrig1, phoneNum1);
//        patMap.put(phoneOrig2, phoneNum2);
//        patMap.put(phoneEdit1, phoneNumEd1);
//        patMap.put(phoneEdit2, phoneNumEd2);
//        patMap.put("Blah1", blah);
//        patMap.put("Blah2", blah2);
//        patMap.put("Blah3", blah3);
//        patMap.put("Blah4", blah4);

//        patMap.put("ABN Orig", abn);
//        patMap.put("ABN Brack", abn2);
//        patMap.put("ABN Group", abn3);



//        mapCount.put(oneString, 0L);
//        mapCount.put(multString, 0L);
//        mapCount.put(basicString, 0L);
//        mapCount.put(phoneOrig, 0L);
//        mapCount.put(phoneOrig1, 0L);
//        mapCount.put(phoneOrig2, 0L);
//        mapCount.put(phoneEdit1, 0L);
//        mapCount.put(phoneEdit2, 0L);
        mapCount.put("Blah1", 0L);
        mapCount.put("Blah2", 0L);
        mapCount.put("Blah3", 0L);
        mapCount.put("Blah4", 0L);

//        mapCount.put("ABN Orig", 0L);
//        mapCount.put("ABN Brack", 0L);
//        mapCount.put("ABN Group", 0L);


        for (Map.Entry<String, String> eachMap : patMap.entrySet()) {

            for (int j = 0; j < AVG_LOOP; j++) {
                logger.info("Looping for '{}' Loop #{}", eachMap.getKey(), j + 1);



                begin = System.currentTimeMillis();

                for (int i = 0; i < LOOPY; i++) {

//                    Pattern pattern = Pattern.compile(eachMap.getValue());
//                    Matcher matcher = pattern.matcher(VARIOUS_PARAGRAPH);
                    jregex.Pattern pattern = new jregex.Pattern(eachMap.getValue());
                    jregex.Matcher matcher = pattern.matcher(VARIOUS_PARAGRAPH);



                    if (matcher.find()) {
                        incrementer.incrementMatch();
                    } else {
                        incrementer.incrementNoMatch();
                    }
                }

                end = System.currentTimeMillis();

                deltaTime = end - begin;
                mapCount.replace(eachMap.getKey(), mapCount.get(eachMap.getKey()) + deltaTime);

                logger.info("Matched:  {};    UnMatched:  {}", incrementer.getMatchCount(), incrementer.getNoMatchCount());
                incrementer = new Incrementer();

            }

        }


        logger.info("");
        logger.info("Average of {} times, with {} loops of a single String to search.", AVG_LOOP, LOOPY);
        for (Map.Entry<String, Long> counts : mapCount.entrySet()) {
            logger.info("Average time for '{}'  ==>  Value:  {} ms", counts.getKey(), counts.getValue() / AVG_LOOP);
        }

        logger.info("");
    }


    public void optimizeRegex() {
        String[] primaryNumOrig = {
                "(4[0-9]{12}(?:[0-9]{3})?)",
                "(5[1-5][0-9]{14})",
                "(3[47][0-9]{13})",
                "(3(?:0[0-5]|[68][0-9])[0-9]{11})",
                "(6(?:011|5[0-9]{2}|4[4-9][0-9])[0-9]{12})",
                "((?:2131|1800|35[0-9]{3})[0-9]{11})",
                "(4[0-9]{3}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})",
                "(5[1-5][0-9]{2}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})",
                "(3[47][0-9]{2}[-][0-9]{6}[-][0-9]{5})",
                "(6(?:011|5[0-9]{2}|4[4-9][0-9])[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})",
                "(35[0-9]{2}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})",
                "(4[0-9]{3} [0-9]{4} [0-9]{4} [0-9]{4})",
                "(5[1-5][0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4})",
                "(3[47][0-9]{2} [0-9]{6} [0-9]{5})",
                "(6(?:011|5[0-9]{2}|4[4-9][0-9]) [0-9]{4} [0-9]{4} [0-9]{4})",
                "(35[0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4})"
        };
        String[] primaryNumOri2g = {
                "((?:2131|1800|35[0-9]{3})[0-9]{11})",
        };

        String[] primaryNumNew = {
                "(4[0-9]{12}([0-9]{3})?)",
                "(4[0-9]{3}({prim_delim}[ -]?)[0-9]{4}{\\prim_delim}[0-9]{4}{\\prim_delim}[0-9]{4})",
                "(5[1-5][0-9]{2}({prim_delim}[ -]?)[0-9]{4}{\\prim_delim}[0-9]{4}{\\prim_delim}[0-9]{4})",
                "(3[47][0-9]{2}({prim_delim}[ -]?)[0-9]{6}{\\prim_delim}[0-9]{5})",
                "(3(0[0-5]|[68][0-9])[0-9]{11})",
                "(6(011|5[0-9]{2}|4[4-9][0-9])({prim_delim}[ -]?)[0-9]{4}{\\prim_delim}[0-9]{4}{\\prim_delim}[0-9]{4})",
                "(35[0-9]{2}[-][0-9]{4}({prim_delim}[ -]?)[0-9]{4}{\\prim_delim}[0-9]{4})",
                "((2131|1800|35[0-9]{3})[0-9]{11})"
        };

        String[] pim = {
                "(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})[=D][0-9]{4}"
        };

        String prim = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})[=D][0-9]{4}";


        Pattern foo = Pattern.compile(prim);
    }
}
