package com.krieghb.javasnips.regex;


import com.krieghb.javasnips.utils.Incrementer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static com.krieghb.javasnips.utils.NumberConstants.LOOPY;

/**
 * Created by krido02 on 5/18/2016.
 *
 */
public class RegexParen {

    Logger logger = LoggerFactory.getLogger(RegexParen.class);


    public void testParanthesis() {
        //
        long begin;
        long end;
        long deltaTime;

        Incrementer incrementer = new Incrementer();

        String oneParen = "([AB]|[CD]|[DE]|[FG])\\d{3}";
        String mulParen = "(([AB])|([CD])|([DE])|([FG]))(\\d{3})";


        String parenString = "A123";



        begin = System.currentTimeMillis();
        for (int i = 0; i < LOOPY; i++) {

            Pattern pattern = Pattern.compile(mulParen);
            Matcher matcher = pattern.matcher(parenString);


            if (matcher.find()) {
//                logger.info("Found match:  {}", matcher.group(0));
                incrementer.incrementMatch();
            }
            else {
//                logger.info("Did NOT find match for patter:  {}", pattern);
                incrementer.incrementNoMatch();
            }
        }

        end = System.currentTimeMillis();

        deltaTime = end - begin;

        logger.info("Time to loop {}:  {}", LOOPY, deltaTime);



    }
}
