package com.krieghb.javasnips.threading;

import com.krieghb.javasnips.utils.ThreadSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dk
 */

public class HeartbeatExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatExecutor.class);

    private boolean heartbeat1Active = true;
    private boolean heartbeat2Active = true;

    private static final int HEARTBEAT_1_SLEEP = 10;
    private static final int HEARTBEAT_2_SLEEP = 20;

    private static final int FAIL_SAFE = 5;

    public void createExecutor() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Heartbeat1());
        executorService.submit(new Heartbeat2());

        executorService.shutdown();

        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            LOGGER.error("Executor was interrupted during its slumber.");
        }

        LOGGER.info("[createExecutor] - complete");

    }



    public class Heartbeat1 implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            int index = 0;
            while (isHeartbeat1Active() && index++ < FAIL_SAFE) {

                LOGGER.info("[Heartbeat 1] - Sending heartbeat then sleeping for {} seconds . . . ", HEARTBEAT_1_SLEEP);
                ThreadSleep.sleepForSeconds(HEARTBEAT_1_SLEEP);
            }
            LOGGER.info("[Heartbeat 1] - Shutting down");

            return null;
        }
    }

    public class Heartbeat2 implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            int index = 0;
            while (isHeartbeat1Active() && index++ < FAIL_SAFE) {

                LOGGER.info("[Heartbeat 2] - Sending heartbeat then sleeping for {} seconds . . . ", HEARTBEAT_2_SLEEP);
                ThreadSleep.sleepForSeconds(HEARTBEAT_2_SLEEP);
            }
            LOGGER.info("[Heartbeat 2] - Shutting down");

            return null;
        }
    }

    public boolean isHeartbeat1Active() {
        return heartbeat1Active;
    }

    public void setHeartbeat1Active(boolean heartbeat1Active) {
        this.heartbeat1Active = heartbeat1Active;
    }

    public boolean isHeartbeat2Active() {
        return heartbeat2Active;
    }

    public void setHeartbeat2Active(boolean heartbeat2Active) {
        this.heartbeat2Active = heartbeat2Active;
    }
}
