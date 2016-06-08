package com.krieghb.javasnips.experiments.dcdtests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by krido02 on 6/7/2016.
 *
 */
public class ChiValidatorFixed {
    private Date todaysDate = new Date();
    private String DATE_FORMAT = "ddMMyy";
    private SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

    private static final Logger logger = LoggerFactory.getLogger(ChiValidatorFixed.class);


    public int validate(String foundDate) {
        int returnVal;
        String cleanFoundDate = foundDate.replaceAll("[^\\d]", "");
        if (cleanFoundDate.length() == 10) {

            cleanFoundDate = cleanFoundDate.substring(0,6);
            try {

                // Forcing a valid date, if it can't parse it, it is an invalid date.
                formatter.setLenient(false);
                formatter.parse(cleanFoundDate);
                returnVal = 0;
            }
            catch (ParseException e) {
                logger.error("Invalid parsing of date IE not a valid date:  {}", cleanFoundDate);

                returnVal = 1;
            }
            catch (Exception e) {
                logger.warn("Error getting date, most likely not a valid date.\n", e);
                returnVal = 1;
            }
        }
        else {

            logger.info("Not 10 digits:  {}", cleanFoundDate);
            returnVal = 1;
        }

        return returnVal;
    }
}
