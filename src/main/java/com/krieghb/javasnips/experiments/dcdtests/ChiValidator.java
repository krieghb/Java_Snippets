package com.krieghb.javasnips.experiments.dcdtests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by krido02 on 6/7/2016.
 */
public class ChiValidator
{
    private final static String COPYRIGHT = "Copyright (c) 2015-2016 CA Technologies. All rights reserved.";
    Date todaysDate = new Date();
    String DATE_FORMAT = "MM-dd-yy";

    Calendar cal = Calendar.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(ChiValidator.class);


    public int validate(String foundDate)
    {
        String cleanFoundDate = foundDate.replaceAll("[^\\d]", "");
        try
        {

            if (cleanFoundDate.length() == 10){

                String day = cleanFoundDate.substring(0,2);
                String month = cleanFoundDate.substring(2,4);
                int year = Integer.parseInt(cleanFoundDate.substring(4,6));
                if (day.equals("31") && (month.equals("4") || month .equals("6") || month.equals("9") ||
                                        month.equals("11") || month.equals("04") || month .equals("06") ||
                                        month.equals("09"))) {

                    logger.info("Incorrect day for month:  {}", cleanFoundDate);

                    return 0; // only 1,3,5,7,8,10,12 has 31 days
                }
                else if (month.equals("2") || month.equals("02")) {
                    if((year % 4)==0){
                        if(day.equals("30")||day.equals("31")){

                            logger.info("Incorrect day for Feburary Leap:  {}", cleanFoundDate);
                            return 0;
                        }else{
                            logger.info("Correct day for Feburary Leap:  {}", cleanFoundDate);
                            return 1;
                        }
                    }else{
                        if(day.equals("29")||day.equals("30")||day.equals("31")){
                            logger.info("Incorrect day for Feburary non-Leap:  {}", cleanFoundDate);
                            return 0;
                        }else{
                            logger.info("Correct day for Feburary non-Leap:  {}", cleanFoundDate);
                            return 1;
                        }
                    }
                }else{

                    logger.info("Correct day for 30 month:  {}", cleanFoundDate);
                    return 1;
                }
            }

        }catch (Exception e) {
            logger.warn(
                    "Could not parse the date string, it's not a valid date.\n",
                    e);
            return 0;
        }

        logger.info("Not 10 digits:  {}", cleanFoundDate);
        return 0;
    }
}
