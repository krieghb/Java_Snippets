package com.krieghb.javasnips.experiments;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by krido02 on 6/7/2016.
 */

public class BDValidator
{

    //   list of formats to pass to the date parser
    private final static String[] formats = { "yyMMdd", "MMddyy", "ddMMyy" };

    private final static int DATE_LENGTH = 6;
    //  list of delimiters
    private final static String SLASH_DELIMITER = "/";
    private final static String SPACE_DELIMITER = " ";
    private final static String HYPHEN_DELIMITER = "-";
    private final static String DOT_DELIMITER = ".";
    // this is used to split the date string based on a dot delimiter;
    // it is necessary because the parameter to the String.split() method
    // is a regular expression: the dot. the dot must be escaped in a regex.
    private final static String DOT_DELIMITER_MOD = "\\.";


    public int validate(String date) {

        int isHit = 0;
        String newDate = "";
        if (date.contains(SLASH_DELIMITER)) {
            newDate = parseDate(date, SLASH_DELIMITER);
        } else if(date.contains(SPACE_DELIMITER)) {
            newDate = parseDate(date, SPACE_DELIMITER);
        } else if(date.contains(HYPHEN_DELIMITER)) {
            newDate = parseDate(date, HYPHEN_DELIMITER);
        } else if (date.contains(DOT_DELIMITER)) {
            newDate = parseDate(date, DOT_DELIMITER_MOD);
        } else {
            // not sure why regex picked out this string, but no delimiters
            // are present, so just skip it
            return isHit;
        }
        if (newDate.length() == 0) {
            return isHit;
        }
        //  remove all delimiters to end up with a six-digit number
        String stripDate = newDate.replaceAll("[^\\d]", "");
        if(stripDate.length() != DATE_LENGTH) {
            return isHit;
        }
        //  Iterate through the list of formats for each date.
        //  When one matches then break out of the loop.
        for (int x = 0; x < formats.length; x++) {
            if (isValid(stripDate, x)) {
                isHit = 1;
                break;
            }
        }

        return isHit;

    }

    private static boolean isValid(String date, int formatIx) {
        boolean isHit = false;
        SimpleDateFormat sdf = new SimpleDateFormat(formats[formatIx]);
        sdf.setLenient(false);
        try {
            // if the date is valid according to the SimpleDateFormat object
            // then control passes here. If the date is invalid then a
            // ParseException is thrown by SimpleDateFormat.
            sdf.parse(date);
            isHit = true;
        } catch (ParseException e) {
            // no need to do anything here, just keep going. The date
            // will be rejected if this exception is caught
        }

        return isHit;
    }

    /*
     *   parseDate() will prefix any single digit with a zero.
     *   that will make the length a consistent 6 digits
     *
     */
    private static String parseDate(String date, String delimiter) {

        String newDate = "";
        String[] parts = date.split(delimiter);
        //  if parts.length < 3, delimiters are not the same, skip it
        //  if parts.length is zero, something is not right, skip it
        if (parts.length < 3 || parts.length == 0) {
            return newDate;
        }
        //  the resulting string with single digits prefixed with zero
        //  will have an extra trailing delimiter. That is ok since the
        //  delimiters will be stripped out in the next step.
        for (int i=0; i < parts.length; i++) {
            if (parts[i].length() == 1) {
                newDate = newDate + "0" + parts[i] + delimiter;
            } else {
                newDate = newDate + parts[i] + delimiter;
            }
        }
        return newDate;
    }

}