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




    public static final String REGEX_ONE_LONG = "(([abc]|[ghi]|[xyz])([0-9]{2}[def]{3}))";
    public static final String REGEX_ORD = "(([abc][0-9]{2}[def]{3})|([ghi][0-9]{2}[def]{3})|([xyz][0-9]{2}[def]{3}))";
    public static final String REGEX_MULT_1 = "([abc][0-9]{2}[def]{3})";
    public static final String REGEX_MULT_2 = "([ghi][0-9]{2}[def]{3})";
    public static final String REGEX_MULT_3 = "([xyz][0-9]{2}[def]{3})";


    public static Map<String, ArrayList<String>> regexMap = new HashMap<>();


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
        regexMap.put(STRING_REGEX_LONG, new ArrayList<>(Collections.singletonList(REGEX_ONE_LONG)));
        regexMap.put(STRING_REGEX_ORD, new ArrayList<>(Collections.singletonList(REGEX_ORD)));
        regexMap.put(STRING_REGEX_MULT, new ArrayList<>(Arrays.asList(REGEX_MULT_1, REGEX_MULT_2, REGEX_MULT_3)));
    }

    public static Map<String, ArrayList<String>> getRegexMap() {
        if (regexMap.isEmpty()) {
            buildRegexMap();
        }
        return regexMap;
    }



}
