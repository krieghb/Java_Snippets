package com.krieghb.javasnips.utils;

import java.util.*;

/**
 * Created by krido02 on 5/17/2016.
 *
 */
public class StringConstants {

    public static final String STRING_REGEX_LONG = "Regex Long";
    public static final String STRING_REGEX_ORD = "Regex ORd";
    public static final String STRING_REGEX_MULT = "Regex Mult";
    public static final String STRING_REGEX_PRIM_OPT = "Credit Card Co";
    public static final String STRING_REGEX_PRIM_COMB = "Credit Card Combined";
    public static final String STRING_REGEX_PRIM_ORIG = "Credit Card Original";
    public static final String STRING_REGEX_PRIM_OPT_REG = "Credit Card Optimized REG";
    public static final String STRING_REGEX_PRIM_OPT_LONG = "Credit Card Optimized LONG";
    public static final String STRING_REGEX_PRIM_COMB_LONG = "Credit Card Combined LONG";
    public static final String STRING_REGEX_PRIM_ORIG_LONG = "Credit Card Original LONG";
    public static final String STRING_REGEX_PRIM_OPT_REG_LONG = "Credit Card Optimized REG LONG";





    public static final String REGEX_ONE_LONG = "(([abc]|[ghi]|[xyz])[0-9]{2}[def]{3})";  //abc or ghi or xzy followed by 00 follwed by def x 3 ex;  a11def
    public static final String REGEX_ORD = "(([abc][0-9]{2}[def]{3})|([ghi][0-9]{2}[def]{3})|([xyz][0-9]{2}[def]{3}))";
    public static final String REGEX_MULT_1 = "([abc][0-9]{2}[def]{3})";
    public static final String REGEX_MULT_2 = "([ghi][0-9]{2}[def]{3})";
    public static final String REGEX_MULT_3 = "([xyz][0-9]{2}[def]{3})";



    public static Map<String, ArrayList<String>> regexMap = new HashMap<>();

    public static final String FILE_PATH = "C:\\Users\\krido02\\Documents\\";
    public static final String SHAKESPEEAR_NONE = "Complete Wks Shakespear - None.txt";
    public static final String SHAKESPEEAR_BEGIN = "Complete Wks Shakespear - Begin.txt";
    public static final String SHAKESPEEAR_MID = "Complete Wks Shakespear - Mid.txt";
    public static final String SHAKESPEEAR_END = "Complete Wks Shakespear - End.txt";

    public static final ArrayList<String> SHAKESPEAR_LIST = new ArrayList<>(Arrays.asList(FILE_PATH + SHAKESPEEAR_NONE, FILE_PATH + SHAKESPEEAR_BEGIN, FILE_PATH + SHAKESPEEAR_MID, FILE_PATH + SHAKESPEEAR_END));


    private static final String STRING_MID_1 = "c798654456 6b54 6a54 654 654 a55eee  ase6v54 ea98c a68e df48e de84 g68e4jk";
    private static final String STRING_MID_2 = "c798654456 6b54 6a54 654 654 g91ddd  ase6v54 ea98c a68e df48e de84 g68e4jk";
    private static final String STRING_MID_3 = "c798654456 6b54 6a54 654 654 x05efd  ase6v54 ea98c a68e df48e de84 g68e4jk";
    private static final String STRING_BEG_1 = "a12def Hi There Everybody, this is a basic example beginning of the String and thats it.  g1234568 a12";
    private static final String STRING_BEG_2 = "g34fed Hi There Everybody, this is a basic example beginning of the String and thats it.  g1234568 a12";
    private static final String STRING_BEG_3 = "x56eef Hi There Everybody, this is a basic example beginning of the String and thats it.  g1234568 a12";
    private static final String STRING_END_1 = "Hi There Everybody, this is a basic example beginning of the String and thats it.  g1234568 a12 b98def";
    private static final String STRING_END_2 = "Hi There Everybody, this is a basic example beginning of the String and thats it.  g1234568 a12 h76fed";
    private static final String STRING_END_3 = "Hi There Everybody, this is a basic example beginning of the String and thats it.  g1234568 a12 y54eef";
    private static final String STRING_NONE_1 = "z12de9 Hi There Everybody, this is a basic example z12de6 beginning of the String and thats it.  g1234568 a12 zztop";
    private static final String STRING_NONE_2 = "z12de6 Hi There Everybody, this is a basic example z12de6 beginning of the String and thats it.  g1234568 a12 zztop";
    private static final String STRING_NONE_3 = "z12de2 Hi There Everybody, this is a basic example z12de6 beginning of the String and thats it.  g1234568 a12 zztop";



    private static final String PRIM_CARD_OPT_1 = "(4[0-9]{12}([0-9]{3})?)";
    private static final String PRIM_CARD_OPT_2 = "(4[0-9]{3}({prim_delim1}[ -]?)[0-9]{4}{\\prim_delim1}[0-9]{4}{\\prim_delim1}[0-9]{4})";
    private static final String PRIM_CARD_OPT_3 = "(5[1-5][0-9]{2}({prim_delim2}[ -]?)[0-9]{4}{\\prim_delim2}[0-9]{4}{\\prim_delim2}[0-9]{4})";
    private static final String PRIM_CARD_OPT_4 = "(3[47][0-9]{2}({prim_delim3}[ -]?)[0-9]{6}{\\prim_delim3}[0-9]{5})";
    private static final String PRIM_CARD_OPT_5 = "(3(0[0-5]|[68][0-9])[0-9]{11})";
    private static final String PRIM_CARD_OPT_6 = "(6(011|5[0-9]{2}|4[4-9][0-9])({prim_delim4}[ -]?)[0-9]{4}{\\prim_delim4}[0-9]{4}{\\prim_delim4}[0-9]{4})";
    private static final String PRIM_CARD_OPT_7 = "(35[0-9]{2}({prim_delim5}[ -]?)[0-9]{4}{\\prim_delim5}[0-9]{4}{\\prim_delim5}[0-9]{4})";
    private static final String PRIM_CARD_OPT_8 = "((2131|1800|35[0-9]{3})[0-9]{11})";

    private static final String PRIM_CARD_COMB_1 = "(4[0-9]{12}(?:[0-9]{3})?)";
    private static final String PRIM_CARD_COMB_2 = "(4[0-9]{3}({prim_delim1}[ -]?)[0-9]{4}{\\prim_delim1}[0-9]{4}{\\prim_delim1}[0-9]{4})";
    private static final String PRIM_CARD_COMB_3 = "(5[1-5][0-9]{2}({prim_delim2}[ -]?)[0-9]{4}\\k<primDelim2>[0-9]{4}\\k<primDelim2>[0-9]{4})";
    private static final String PRIM_CARD_COMB_4 = "(3[47][0-9]{2}({prim_delim3}[ -]?)[0-9]{6}\\k<primDelim3>[0-9]{5})";
    private static final String PRIM_CARD_COMB_5 = "(3(?:0[0-5]|[68][0-9])[0-9]{11})";
    private static final String PRIM_CARD_COMB_6 = "(6(?:011|5[0-9]{2}|4[4-9][0-9])({prim_delim4}[ -]?)[0-9]{4}{\\prim_delim4}[0-9]{4}{\\prim_delim4}[0-9]{4})";
    private static final String PRIM_CARD_COMB_7 = "(35[0-9]{2}({prim_delim5}[ -]?)[0-9]{4}{\\prim_delim5}[0-9]{4}{\\prim_delim5}[0-9]{4})";
    private static final String PRIM_CARD_COMB_8 =  "((?:2131|1800|35[0-9]{3})[0-9]{11})";

    private static final String PRIM_CARD_OPT_REG_1 = "(4[0-9]{12}([0-9]{3})?)";
    private static final String PRIM_CARD_OPT_REG_2 = "(4[0-9]{3}(?<primDelim1>[ -]?)[0-9]{4}\\k<primDelim1>[0-9]{4}\\k<primDelim1>[0-9]{4})";
    private static final String PRIM_CARD_OPT_REG_3 = "(5[1-5][0-9]{2}(?<primDelim2>[ -]?)[0-9]{4}\\k<primDelim2>[0-9]{4}\\k<primDelim2>[0-9]{4})";
    private static final String PRIM_CARD_OPT_REG_4 = "(3[47][0-9]{2}(?<primDelim3>[ -]?)[0-9]{6}\\k<primDelim3>[0-9]{5})";
    private static final String PRIM_CARD_OPT_REG_5 = "(3(0[0-5]|[68][0-9])[0-9]{11})";
    private static final String PRIM_CARD_OPT_REG_6 = "(6(011|5[0-9]{2}|4[4-9][0-9])(?<primDelim4>[ -]?)[0-9]{4}\\k<primDelim4>[0-9]{4}\\k<primDelim4>[0-9]{4})";
    private static final String PRIM_CARD_OPT_REG_7 = "(35[0-9]{2}(?<primDelim5>[ -]?)[0-9]{4}\\k<primDelim5>[0-9]{4}\\k<primDelim5>[0-9]{4})";
    private static final String PRIM_CARD_OPT_REG_8 = "((2131|1800|35[0-9]{3})[0-9]{11})";

    private static final String PRIM_CARD_ORIG_1 = "(4[0-9]{12}(?:[0-9]{3})?)";
    private static final String PRIM_CARD_ORIG_2 = "(5[1-5][0-9]{14})";
    private static final String PRIM_CARD_ORIG_3 = "(3[47][0-9]{13})";
    private static final String PRIM_CARD_ORIG_4 = "(3(?:0[0-5]|[68][0-9])[0-9]{11})";
    private static final String PRIM_CARD_ORIG_5 = "(6(?:011|5[0-9]{2}|4[4-9][0-9])[0-9]{12})";
    private static final String PRIM_CARD_ORIG_6 = "((?:2131|1800|35[0-9]{3})[0-9]{11})";
    private static final String PRIM_CARD_ORIG_7 = "(4[0-9]{3}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})";
    private static final String PRIM_CARD_ORIG_8 = "(5[1-5][0-9]{2}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})";
    private static final String PRIM_CARD_ORIG_9 = "(3[47][0-9]{2}[-][0-9]{6}[-][0-9]{5})";
    private static final String PRIM_CARD_ORIG_10 = "(6(?:011|5[0-9]{2}|4[4-9][0-9])[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})";
    private static final String PRIM_CARD_ORIG_11 = "(35[0-9]{2}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4})";
    private static final String PRIM_CARD_ORIG_12 = "(4[0-9]{3} [0-9]{4} [0-9]{4} [0-9]{4})";
    private static final String PRIM_CARD_ORIG_13 = "(5[1-5][0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4})";
    private static final String PRIM_CARD_ORIG_14 = "(3[47][0-9]{2} [0-9]{6} [0-9]{5})";
    private static final String PRIM_CARD_ORIG_15 = "(6(?:011|5[0-9]{2}|4[4-9][0-9]) [0-9]{4} [0-9]{4} [0-9]{4})";
    private static final String PRIM_CARD_ORIG_16 = "(35[0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4})";



    public static final String STRING_REGEX_SSN_ORIG = "SSN Original";
    public static final String STRING_REGEX_SSN_OPT = "SSN Optimized";
    public static final String STRING_REGEX_SSN_OPT2 = "SSN Optimized2";

    private static final String SSN_ORIG_01 = "([0-9]{9})";
    private static final String SSN_ORIG_02 = "([0-9]{3} [0-9]{2} [0-9]{4})";
    private static final String SSN_ORIG_03 = "([0-9]{3}[\\.|-][0-9]{2}[\\.|-][0-9]{4})";

    private static final String SSN_OPT = "([0-9]{3}({ssn_delim}[ .|-]?)[0-9]{2}{\\ssn_delim}[0-9]{4})";
    private static final String SSN_OPT2 = "(?:(?:[0-9]{3})({ssn_delim}[ .|-]?)(?:[0-9]{2}){\\ssn_delim}[0-9]{4})";

    private static final String CO_DL_O1 = "(?:\\d{2}-(?:(?:00[1-9])|(?:0[1-9][0-9])|(?:[1-2][0-9][0-9])|(?:3[0-5][0-9])|(?:36[0-6]))-\\d{4})";
    private static final String CO_DL_O2 = "(?:\\d{2}(?:(?:00[1-9])|(?:0[1-9][0-9])|(?:[1-2][0-9][0-9])|(?:3[0-5][0-9])|(?:36[0-6]))\\d{4})";
    private static final String CO_DL_COM = "(?:\\d{2}({co_delim}[ -]?)(?:(?:00[1-9])|(?:0[1-9][0-9])|(?:[1-2][0-9][0-9])|(?:3[0-5][0-9])|(?:36[0-6])){\\co_delim}\\d{4})";


    private static final String STRING_SSN_OPT_NON = "Non capturing";
    private static final String STRING_SSN_OPT_ON = "Capturing";
    private static final String SSN_OPT_NON = "(?:(?:[0-9]{3})({ssn_delim}[ .|-]?)(?:[0-9]{2}){\\ssn_delim}(?:[0-9]{4}))";
    private static final String SSN_OPT_ON = "(([0-9]{3})({ssn_delim}[ .|-]?)([0-9]{2}){\\ssn_delim}([0-9]{4}))";
    private static final ArrayList<String> SSN_OPT_NON_LIST = new ArrayList<>(Collections.singletonList(SSN_OPT_NON));
    private static final ArrayList<String> SSN_OPT_ON_LIST = new ArrayList<>(Collections.singletonList(SSN_OPT_ON));

    public static final String PAREN_ONLY_JREG = "((((\\d)([a-z])(\\d))|((\\d)([A-Z])(\\d)))((\\d{2})|([*-]))(11))";
    public static final String NON_CAPTURE_JREG = "(?:(?:(?:(?:\\d)(?:[a-z])(?:\\d))|(?:(?:\\d)(?:[A-Z])(?:\\d)))(?:(?:\\d{2})|(?:[*-]))(?:11))";
    private static final String STRING_PAREN_ONLY_JREG = "Parenthesis Only Jreg";
    private static final String STRING_NON_CAPTURE_JREG = "Non-Capturing Jreg";
    public static final String PAREN_ONLY_REG = "((((\\d)([a-z])(\\d))|((\\d)([A-Z])(\\d)))((\\d{2})|([*-]))(11))";
    public static final String NON_CAPTURE_REG = "(?:(?:(?:(?:\\d)(?:[a-z])(?:\\d))|(?:(?:\\d)(?:[A-Z])(?:\\d)))(?:(?:\\d{2})|(?:[*-]))(?:11))";
    private static final String STRING_PAREN_ONLY_REG = "Parenthesis Only Reg";
    private static final String STRING_NON_CAPTURE_REG = "Non-Capturing Reg";



    private static ArrayList<String> ssnOrignal = new ArrayList<>();
    private static ArrayList<String> ssnOptimized = new ArrayList<>();
    private static ArrayList<String> ssnOptimized2 = new ArrayList<>();

    public static void buildSSNs() {
        if (ssnOrignal.isEmpty()) {
            ssnOrignal.add(SSN_ORIG_01);
            ssnOrignal.add(SSN_ORIG_02);
            ssnOrignal.add(SSN_ORIG_03);
        }
        if (ssnOptimized.isEmpty()) {
            ssnOptimized.add(SSN_OPT);
        }
        if (ssnOptimized2.isEmpty()) {
            ssnOptimized2.add(SSN_OPT2);
        }
    }
    public static ArrayList<String> getSsnOrignal() {
        if (ssnOrignal.isEmpty()) {
            buildSSNs();
        }
        return ssnOrignal;
    }
    public static ArrayList<String> getSsnOptimized() {
        if (ssnOptimized.isEmpty()) {
            buildSSNs();
        }
        return ssnOptimized;
    }
    public static ArrayList<String> getSsnOptimized2() {
        if (ssnOptimized2.isEmpty()) {
            buildSSNs();
        }
        return ssnOptimized2;
    }




    private static ArrayList<String> primaryCardOptReg = new ArrayList<>();
    private static ArrayList<String> primaryCardOptRegLong = new ArrayList<>();
    private static ArrayList<String> primaryCardOpt = new ArrayList<>();
    private static ArrayList<String> primaryCardOrig = new ArrayList<>();
    private static ArrayList<String> primaryCardOptLong = new ArrayList<>();
    private static ArrayList<String> primaryCardOrigLong = new ArrayList<>();
    private static ArrayList<String> primaryCardComb = new ArrayList<>();
    private static ArrayList<String> primaryCardCombLong = new ArrayList<>();



    private static void buildPrimaryCardComb() {
        primaryCardComb.add(PRIM_CARD_COMB_1);
        primaryCardComb.add(PRIM_CARD_COMB_2);
        primaryCardComb.add(PRIM_CARD_COMB_3);
        primaryCardComb.add(PRIM_CARD_COMB_4);
        primaryCardComb.add(PRIM_CARD_COMB_5);
        primaryCardComb.add(PRIM_CARD_COMB_6);
        primaryCardComb.add(PRIM_CARD_COMB_7);
        primaryCardComb.add(PRIM_CARD_COMB_8);
    }
    private static ArrayList<String> getPrimaryCardComb() {
        if (primaryCardComb.isEmpty()) {
            buildPrimaryCardComb();
        }
        return primaryCardComb;
    }

    private static void buildPrimaryCardOpt() {
        primaryCardOpt.add(PRIM_CARD_OPT_1);
        primaryCardOpt.add(PRIM_CARD_OPT_2);
        primaryCardOpt.add(PRIM_CARD_OPT_3);
        primaryCardOpt.add(PRIM_CARD_OPT_4);
        primaryCardOpt.add(PRIM_CARD_OPT_5);
        primaryCardOpt.add(PRIM_CARD_OPT_6);
        primaryCardOpt.add(PRIM_CARD_OPT_7);
        primaryCardOpt.add(PRIM_CARD_OPT_8);
    }
    public static ArrayList<String> getPrimaryCardOpt() {
        if (primaryCardOpt.isEmpty()) {
            buildPrimaryCardOpt();
        }
        return primaryCardOpt;
    }

    private static void buildPrimaryCardOptReg() {
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_1);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_2);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_3);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_4);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_5);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_6);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_7);
        primaryCardOptReg.add(PRIM_CARD_OPT_REG_8);
    }
    public static ArrayList<String> getPrimaryCardOptReg() {
        if (primaryCardOptReg.isEmpty()) {
            buildPrimaryCardOptReg();
        }
        return primaryCardOptReg;
    }

    private static void buildPrimaryCardOrig() {
        primaryCardOrig.add(PRIM_CARD_ORIG_1);
        primaryCardOrig.add(PRIM_CARD_ORIG_2);
        primaryCardOrig.add(PRIM_CARD_ORIG_3);
        primaryCardOrig.add(PRIM_CARD_ORIG_4);
        primaryCardOrig.add(PRIM_CARD_ORIG_5);
        primaryCardOrig.add(PRIM_CARD_ORIG_6);
        primaryCardOrig.add(PRIM_CARD_ORIG_7);
        primaryCardOrig.add(PRIM_CARD_ORIG_8);
        primaryCardOrig.add(PRIM_CARD_ORIG_9);
        primaryCardOrig.add(PRIM_CARD_ORIG_10);
        primaryCardOrig.add(PRIM_CARD_ORIG_11);
        primaryCardOrig.add(PRIM_CARD_ORIG_12);
        primaryCardOrig.add(PRIM_CARD_ORIG_13);
        primaryCardOrig.add(PRIM_CARD_ORIG_14);
        primaryCardOrig.add(PRIM_CARD_ORIG_15);
        primaryCardOrig.add(PRIM_CARD_ORIG_16);
    }
    public static ArrayList<String> getPrimaryCardOrig() {
        if (primaryCardOrig.isEmpty()) {
            buildPrimaryCardOrig();
        }
        return primaryCardOrig;
    }

    private static void buildPrimaryCardLong() {
        if (primaryCardOpt.isEmpty())
            buildPrimaryCardOptReg();
        StringBuilder buildit = new StringBuilder();
        for (int j = 0; j < primaryCardOpt.size(); j++) {

            buildit.append("(").append(primaryCardOpt.get(j)).append(")");
            if (j < (primaryCardOpt.size() - 1)) {
                buildit.append("|");
            }
        }
        primaryCardOptLong.add(buildit.toString());

    }

    public static ArrayList<String> getPrimaryCardOptLong() {
        if (primaryCardOptLong.isEmpty())
            buildPrimaryCardLong();

        return primaryCardOptLong;
    }

    private static void buildPrimaryCardOrigLong() {
        if (primaryCardOrig.isEmpty())
            buildPrimaryCardOptReg();
        StringBuilder buildit = new StringBuilder();
        for (int j = 0; j < primaryCardOrig.size(); j++) {

            buildit.append("(").append(primaryCardOrig.get(j)).append(")");
            if (j < (primaryCardOrig.size() - 1)) {
                buildit.append("|");
            }
        }
        primaryCardOrigLong.add(buildit.toString());

    }
    public static ArrayList<String> getPrimaryCardOrigLong() {
        if (primaryCardOrigLong.isEmpty())
            buildPrimaryCardOrigLong();

        return primaryCardOrigLong;
    }





    private static void buildPrimaryCardCombLong() {
        if (primaryCardComb.isEmpty())
            buildPrimaryCardComb();
        StringBuilder buildit = new StringBuilder();
        for (int j = 0; j < primaryCardComb.size(); j++) {

            buildit.append("(").append(primaryCardComb.get(j)).append(")");
            if (j < (primaryCardComb.size() - 1)) {
                buildit.append("|");
            }
        }
        primaryCardCombLong.add(buildit.toString());

    }
    public static ArrayList<String> getPrimaryCardCombLong() {
        if (primaryCardCombLong.isEmpty())
            buildPrimaryCardCombLong();

        return primaryCardCombLong;
    }

    public static final String VARIOUS_PARAGRAPH = "This is going to be a very long paragraph with various random 12345 characters.  It could have a Colorado Driver's License of A1234687 or on of 12326.\n" +
            "But 1212-1234 it may have Addresses such as 123 First street, Nowhere, AL.   It's also a good place to just search for 525252 digits here and 123121234 there.  There could could " +
            "also be an invalid phone number like -1-123-1234- or like _-(-12-)-122_-1 or a good one like  Or what I am seraching for today:   1-(630)123.1234    53.004-085-616";































    private static ArrayList<String> virtualDoc = new ArrayList<>();

    private static void buildVirtualDoc() {
        virtualDoc.add(STRING_MID_1);
        virtualDoc.add(STRING_MID_2);
        virtualDoc.add(STRING_MID_3);
        virtualDoc.add(STRING_BEG_1);
        virtualDoc.add(STRING_BEG_2);
        virtualDoc.add(STRING_BEG_3);
        virtualDoc.add(STRING_END_1);
        virtualDoc.add(STRING_END_2);
        virtualDoc.add(STRING_END_3);
        virtualDoc.add(STRING_NONE_1);
        virtualDoc.add(STRING_NONE_2);
        virtualDoc.add(STRING_NONE_3);
    }












    public static ArrayList<String> getVirtualDoc() {
        if (virtualDoc.isEmpty()) {
            buildVirtualDoc();
        }

        return virtualDoc;
    }




    private static void buildRegexMap() {
        System.out.println("BUILDING MAP");
//        regexMap.put(STRING_REGEX_LONG, new ArrayList<>(Collections.singletonList(REGEX_ONE_LONG)));
//        regexMap.put(STRING_REGEX_ORD, new ArrayList<>(Collections.singletonList(REGEX_ORD)));
//        regexMap.put(STRING_REGEX_MULT, new ArrayList<>(Arrays.asList(REGEX_MULT_1, REGEX_MULT_2, REGEX_MULT_3)));

//        regexMap.put(STRING_REGEX_PRIM_ORIG, new ArrayList<>(getPrimaryCardOrig()));
//        regexMap.put(STRING_REGEX_PRIM_ORIG_LONG, new ArrayList<>(getPrimaryCardOrigLong()));
//        regexMap.put(STRING_REGEX_PRIM_OPT, new ArrayList<>(getPrimaryCardOpt()));
//        regexMap.put(STRING_REGEX_PRIM_OPT_LONG, new ArrayList<>(getPrimaryCardOptLong()));
//        regexMap.put(STRING_REGEX_PRIM_COMB, new ArrayList<>(getPrimaryCardComb()));
//        regexMap.put(STRING_REGEX_PRIM_COMB_LONG, new ArrayList<>(getPrimaryCardCombLong()));


//        regexMap.put(STRING_REGEX_SSN_OPT, new ArrayList<>(getSsnOptimized()));
//        regexMap.put(STRING_REGEX_SSN_OPT2, new ArrayList<>(getSsnOptimized2()));
//        regexMap.put(STRING_REGEX_SSN_ORIG, new ArrayList<>(getSsnOrignal()));

        // Capturing vs non capturing
//        regexMap.put(STRING_SSN_OPT_NON, SSN_OPT_NON_LIST);
//        regexMap.put(STRING_SSN_OPT_ON, SSN_OPT_ON_LIST);
//        regexMap.put(STRING_PAREN_ONLY_JREG, new ArrayList<>(Collections.singletonList(PAREN_ONLY_JREG)));
//        regexMap.put(STRING_NON_CAPTURE_JREG, new ArrayList<>(Collections.singletonList(NON_CAPTURE_JREG)));

        regexMap.put(STRING_PAREN_ONLY_REG, new ArrayList<>(Collections.singletonList(PAREN_ONLY_REG)));
        regexMap.put(STRING_NON_CAPTURE_REG, new ArrayList<>(Collections.singletonList(NON_CAPTURE_REG)));


        System.out.println("BUILT MAP:   " + regexMap);
    }

    public static Map<String, ArrayList<String>> getRegexMap() {
        if (regexMap.isEmpty()) {
            buildRegexMap();
        }
        return regexMap;
    }



}
