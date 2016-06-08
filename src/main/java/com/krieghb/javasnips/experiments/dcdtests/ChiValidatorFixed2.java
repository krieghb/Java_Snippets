package com.krieghb.javasnips.experiments.dcdtests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by krido02 on 6/7/2016.
 *
 */
@SuppressWarnings("Duplicates")
public class ChiValidatorFixed2 {
    Date todaysDate = new Date();
    String DATE_FORMAT = "MM-dd-yy";

    Calendar cal = Calendar.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(ChiValidatorFixed2.class);


    public int validate(String foundDate)
    {
        int validateReturn = 0;
        String cleanFoundDate = foundDate.replaceAll("[^\\d]", "");

        if (cleanFoundDate.length() == 10) {
            try {

                int dayInt = Integer.parseInt(cleanFoundDate.substring(0, 2));
                logger.info("Day:  {}", dayInt);

                int monthInt = Integer.parseInt(cleanFoundDate.substring(2, 4));
                logger.info("Month: {}", monthInt);

                int year = Integer.parseInt(cleanFoundDate.substring(4, 6));
                logger.info("Year: {}", year);

                if (monthInt > 12 || monthInt < 1 || dayInt > 31 || dayInt < 1) {

                    logger.info("Incorrect month or day:  {}", cleanFoundDate);

                    validateReturn = 0;
                }
                else if ((dayInt > 30) && (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11)) {

                    logger.info("Incorrect day for month:  {}", cleanFoundDate);

                    validateReturn = 0; // only 1,3,5,7,8,10,12 has 31 days
                }
                else if (monthInt == 2) {
                    if ((year % 4) == 0) {
                        if (dayInt > 29) {

                            logger.info("Incorrect day for Feburary Leap:  {}", cleanFoundDate);
                            validateReturn = 0;
                        } else {
                            logger.info("Correct day for Feburary Leap:  {}", cleanFoundDate);
                            validateReturn = 1;
                        }
                    } else {
                        if (dayInt > 28) {
                            logger.info("Incorrect day for Feburary non-Leap:  {}", cleanFoundDate);
                            validateReturn = 0;
                        } else {
                            logger.info("Correct day for Feburary non-Leap:  {}", cleanFoundDate);
                            validateReturn = 1;
                        }
                    }
                } else {

                    logger.info("Correct day for 30 month:  {}", cleanFoundDate);
                    validateReturn = 1;
                }
            } catch (Exception e) {
                logger.warn(
                        "Could not parse the date string, it's not a valid date.\n",
                        e);
                validateReturn = 0;
            }
        }

        else {
        logger.info("Not 10 digits:  {}", cleanFoundDate);
    }

        return validateReturn;
    }
}
