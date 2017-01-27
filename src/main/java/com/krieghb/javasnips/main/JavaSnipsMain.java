package com.krieghb.javasnips.main;


import com.krieghb.javasnips.experiments.classes.ClassA;
import com.krieghb.javasnips.experiments.classes.MyClass;
import com.krieghb.javasnips.experiments.dcdtests.BDValidator;
import com.krieghb.javasnips.experiments.dcdtests.ChiValidator;
import com.krieghb.javasnips.experiments.dcdtests.ChiValidatorFixed;
import com.krieghb.javasnips.experiments.dcdtests.ChiValidatorFixed2;
import com.krieghb.javasnips.experiments.inher.ChildAClass;
import com.krieghb.javasnips.experiments.inher.ChildBClass;
import com.krieghb.javasnips.experiments.inher.ParentClass;
import com.krieghb.javasnips.regex.*;

import com.krieghb.javasnips.threading.Heartbeat;
import com.krieghb.javasnips.threading.HeartbeatExecutor;
import com.krieghb.javasnips.threading.ThreadTest;
import com.krieghb.javasnips.utils.ThreadSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.*;

import static com.krieghb.javasnips.utils.NumberConstants.AVG_LOOP;
import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;


/**
 * Created by krido02 on 5/5/2016.
 * 
 * 
 */
public class JavaSnipsMain {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(JavaSnipsMain.class);
    
    
    public static void main (String[] args) {


//        RegexParen regexParen = new RegexParen();
//        regexParen.testParanthesis();

//        RegexMain regexMain = new RegexMain();
//        regexMain.testReg();
//        regexMain.testLookaheads();
//        regexMain.testLoop();

//        LOGGER.info("\n\n\n");
//        LOGGER.info(Randomness.getRandomChar("hi") + "");
//        LOGGER.info("\n\n\n");

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

//        testClassdate();


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
//            LOGGER.info("Found the match:  '{}'", matcher.group(0));
//        }
//        else {
//            LOGGER.info("Did NOT find the match");
//        }


//        testStringFormat();


//        String foo = "Hi %s";
//        String bar = "there!";
//
//        String foobar = String.format(foo, bar);
//
//        LOGGER.info("Foo:  {}", foo);
//        LOGGER.info("Bar:  {}", bar);
//        LOGGER.info("Foobar:  {}", foobar);

//
//        for (int i = 0; i < 10; i++)
//        LOGGER.info("Random:  {}", (long) (Math.random() * 1000) + 3000 );

//        testThreadTest();

//        testArr();


//        testStrReplace();



//        testUtilDate();

//        testListEqual();
        testStringCompare();

    }

    public static void testStringCompare() {

        String str1 = "Hi!";
        String str2 = "!iH";
        String str3 = "Hi!";

        LOGGER.info("COMPARE:  {}", str1.equals(str2));
        LOGGER.info("COMPARE:  {}", str1.equals(str3));
    }

    public static void testListEqual() {

        List<ClassA> list1 = new ArrayList<>();
        List<ClassA> list2 = new ArrayList<>();

        ClassA c1 = new ClassA("Class 1", 1, new MyClass(1,11));
        ClassA c2 = new ClassA("Class 2", 22, new MyClass(222,2222));

        ClassA c3 = new ClassA("Class 1", 1, new MyClass(1,11));
        ClassA c4 = new ClassA("Class 2", 22, new MyClass(222,2222));
        list1.add(c1);
        list1.add(c2);
        list2.add(c4);
        list2.add(c3);

        LOGGER.info("List1:  {}", list1);
        LOGGER.info("List2:  {}", list2);

        if (list1.equals(list2)) {
            LOGGER.info("Lists are equal");
        }
        else {
            LOGGER.info("Lists are NOTNOTNOT equal");
        }

        boolean isEqual = true;
        for (ClassA ca : list1) {
            if (!list2.contains(ca)) {
                isEqual = false;
                break;
            }
        }
        for (ClassA ca : list2) {
            if (!list1.contains(ca)) {
                isEqual = false;
                break;
            }
        }
        if (isEqual) {
            LOGGER.info("Contains Lists are equal");
        }
        else {
            LOGGER.info("Contains Lists are NOTNOTNOT equal");
        }

    }




    public static void testUtilDate() {

        Timestamp ts = new Timestamp(10);
        Timestamp ts2 = new Timestamp(1482334602);

        LOGGER.info("1 before 2:  {}", ts.before(ts2));
        LOGGER.info("TS2:  {}", ts2);

    }


    public static void testStrReplace() {
        String foo = "This is a test of the network broadcasting system.";
        String bar = ",This, is, also, a,, test , ,of, the,,,, network.,";
        String foobar;

        foobar = bar.replaceAll("^,", "");
        LOGGER.info("Before:  {}", bar);
        LOGGER.info("After:   {}", foobar);



    }



    public static void testArr() {
        byte[] testA = new byte[4];
        byte[] testB = new byte[6];
        testA[0] = 2;

        if (Arrays.equals(testA, testB)) {
            LOGGER.info("Arrays.equals are equal.");
        }
        else {
            LOGGER.info("Arrays are not equal:  '{}' vs '{}'", testA, testB);
        }
    }


    public static void testInher() {
        ParentClass pc = new ParentClass("Parent", 40, 99.9);
        ParentClass pcA;
        ParentClass pcB;
        ChildAClass cA = new ChildAClass("Child A", 8, 11.1, "Be child A", true);
        ChildBClass cB = new ChildBClass("Child B", 9, 12.2, "child B", false);


        pcA = new ChildAClass("PA", 22, 33.3, "This is child A parent", false);
        pcB = new ChildBClass("Par B", 38, 98.6, "This is Parent B", true);

        pc.sayHi();
        cA.sayHi();
        cB.sayHi();
        pcA.sayHi();
        pcB.sayHi();


    }




    public static void testThreadTest() {
//        ThreadTest threadTest = new ThreadTest();
//
//        threadTest.runThreadTest();

        Heartbeat heartbeat = new Heartbeat();
        HeartbeatExecutor heartbeatExecutor = new HeartbeatExecutor();

        heartbeat.runHeartbeats();
//        heartbeatExecutor.createExecutor();

        LOGGER.info("Created Threads, continuing on.");

//        ThreadSleep.sleepForSeconds(30);
//        LOGGER.info("Slept, now attempting to stop heartbeat1");
//        heartbeatExecutor.setHeartbeat1Active(false);
//        ThreadSleep.sleepForSeconds(15);
//        LOGGER.info("Slept, now attempting to stop heartbeat2");
//        heartbeatExecutor.setHeartbeat2Active(false);

        ThreadSleep.sleepForSeconds(30);
        LOGGER.info("Attempting to stop Heartbeat1");
        heartbeat.setHeartbeat1Active(false);
        ThreadSleep.sleepForSeconds(15);
        LOGGER.info("Attempting to stop Heartbeat2");
        heartbeat.setHeartbeat2Active(false);

        LOGGER.info("Done with Threads");

        LOGGER.info("Main complete.");

    }


    public static void testStringFormat() {


        final String REPLACE1 = "<Replace1>";
        final String REPLACE2 = "<Replace2>";

        String rep1 = "test";
        String rep2 = "broadcasting";

        String foo = "This is a %s of the network %s system.";
        String bar = "This is a <Replace1> of the network <Replace2> system.";
        String foobar = "";


        final int LOOP = 100000000;

        Long loopStart1, loopEnd1, loopStart2, loopEnd2;
        Long loopStartA, loopStartB, loopEndA, loopEndB;
        Long loopTotalA = 0L;
        Long loopTotalB = 0L;

        loopStart1 = System.currentTimeMillis();
        for (int i = 0; i < LOOP; i++)
        {
            loopStartA = System.nanoTime();
            foobar = bar.replace(REPLACE1, rep1).replace(REPLACE2, rep2);
            loopEndA = System.nanoTime();
            loopTotalA += (loopEndA - loopStartA);
        }
        loopEnd1 = System.currentTimeMillis();
        LOGGER.info("Replace:  {}", foobar);
        LOGGER.info("Loop Total Timing:   {} ms", loopEnd1 - loopStart1);
        LOGGER.info("Average:  ({}) ns", loopTotalA/LOOP);




        loopStart2 = System.currentTimeMillis();
        for (int i = 0; i < LOOP; i++)
        {
            loopStartB = System.nanoTime();
            foobar = String.format(foo, rep1, rep2);
            loopEndB = System.nanoTime();
            loopTotalB += (loopEndB - loopStartB);
        }
        loopEnd2 = System.currentTimeMillis();
        LOGGER.info("Format:  {}", foobar);
        LOGGER.info("Loop Total Timing:   {} ms", loopEnd2 - loopStart2);
        LOGGER.info("Average:  ({}) ns", loopTotalB/LOOP);
    }

    public static void testRegs() {
        Map<String, Long> regexPat;
        Map<String, Long> jregexPat;



        LoopyReg loopyReg = new LoopyReg();
        regexPat = loopyReg.loopTheRegex();

        JregexMain jregexMain = new JregexMain();
        jregexPat = jregexMain.JRegLoopy();


        LOGGER.info("Number of Loops:  {};   Avg Loop #:  {}", LOOPY, AVG_LOOP);
        LOGGER.info("Average time of RegEx for each pattern type:  ");
        for (Map.Entry<String, Long> patPair : regexPat.entrySet()) {
            LOGGER.info("Pattern:    {};     Avg Time(ms):  {}", patPair.getKey(), (patPair.getValue() / AVG_LOOP));
        }

        LOGGER.info("");

        LOGGER.info("Average time of JRegex for each pattern type:  ");
        for (Map.Entry<String, Long> jPatPair : jregexPat.entrySet()) {
            LOGGER.info("Pattern:    {};     Avg Time(ms):  {}", jPatPair.getKey(), (jPatPair.getValue() / AVG_LOOP));
        }
    }

    public static void testJ() {
        jregex.Pattern jPat = new jregex.Pattern("([0-9]{3}({ssn_delim}[ .|-]?)[0-9]{2}{\\ssn_delim}[0-9]{4})");
        jregex.Matcher jMat;
        String foo = "123|45|6789";
        jMat = jPat.matcher(foo);

        if (jMat.find()) {
            LOGGER.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            LOGGER.info("No matched pattern.");
        }

    }



    public static void testDate() {
        BDValidator bdValidator = new BDValidator();
        String myDate = "2/0/12";
        LOGGER.info("Is '{}' a valid?  {}", myDate, bdValidator.validate(myDate) == 0 ? "yes" : "no");

    }

    public static void testSSNCanada() {
        String ssnPat = "(\\d{3}[-?]\\d{3}[-?]\\d{3}|\\d{3}[\\s?]\\d{3}[\\s?]\\d{3}|\\d{3}[.?]\\d{3}[.?]\\d{3})";
        String toSearch = "123123123";
        jregex.Pattern jPat = new jregex.Pattern(ssnPat);
        jregex.Matcher jMat = jPat.matcher(toSearch);

        if (jMat.find()) {
            LOGGER.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            LOGGER.info("No matched pattern.");
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
            LOGGER.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            LOGGER.info("No matched pattern.");
        }
        int Val1 = chiValidator.validate(chiSearch);
        int Val2 = chiValidatorFixed.validate(chiSearch);
        int Val3 = chiValidatorFixed2.validate(chiSearch);
        LOGGER.info("Valide CHI?  {}", Val1);
//        LOGGER.info("Validated Fixed1 CHI?  {}", Val2);
//        LOGGER.info("Val1:  Is it Valid?  {}", Val2 == 0 ? "Yes": "NO");
        LOGGER.info("Val3:  {}",  Val3);
    }


    public static void testStreet(){
        String strPat = "(\\d{1,4} [a-zA-z\\s]{1,20}(?:AVENUE|Avenue|BOULEVARD|Boulevard|BLVD|Blvd|BYPASS|Bypass|BYP|Byp|CENTER|Center|CTR|Ctr|COURT|Court|CRESCENT|Crescent|CRECENT|Crecent|CRES|Cres|CREST|Crest|CRST|Crst|CROSSING|Crossing|XING|Xing|CROSSROAD|Crossroad|XRD|Xrd|DRIVE|Drive|FREEWAY|Freeway|FWY|Fwy|GATEWAY|Gateway|GTWY|Gtwy|HIGHWAY|Highway|HWY|Hwy|JUNCTION|Junction|JCT|Jct|KNOLL|Knoll|KNL|Knl|LANE|Lane|LN|Ln|MANOR|Manor|MNR|Mnr|MOTORWAY|Motorway|MTWY|Mtwy|PARKWAY|Parkway|PKWY|Pkwy|PARKWY|Parkwy|PLAZA|Plaza|PLZ|Plz|ROAD|Road|ROUTE|Route|RTE|Rte|RUE|Rue|SQUARE|Square|SQ|Sq|SQR|Sqr|STREET|Street|STR|Str|STRT|Strt|STREETS|Streets|STS|Sts|SUMMIT|Summit|SMT|Smt|VALLEY|Valley|VLY|Vly)\\W?(?=\\s|$))";
        String toSearch = "One Center Center";

        jregex.Pattern jPat = new jregex.Pattern(strPat);
        jregex.Matcher jMat = jPat.matcher(toSearch);

        if (jMat.find()) {
            LOGGER.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            LOGGER.info("No matched pattern.");
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
            LOGGER.info("Found pattern:  {}", jMat.group(0));
        }
        else {
            LOGGER.info("No matched pattern.");
        }


    }
}
