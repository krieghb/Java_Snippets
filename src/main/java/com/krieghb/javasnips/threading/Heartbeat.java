package com.krieghb.javasnips.threading;

import com.krieghb.javasnips.utils.ThreadSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dk
 */
public class Heartbeat {


    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);

    private Thread heartbeat1 = null;
    private Thread heartbeat2 = null;

    private boolean heartbeat1Active = true;
    private boolean heartbeat2Active = true;

    private static final int HEARTBEAT_1_SLEEP = 10;
    private static final int HEARTBEAT_2_SLEEP = 20;

    private static final int FAIL_SAFE = 100;




    private void createHeartBeat1() {
        heartbeat1 = new Thread() {
            public void run() {
                int index = 0;
                while(heartbeat1Active && index < FAIL_SAFE) {
                    index++;

                    LOGGER.info("[Heartbeat 1] - Sending heartbeat then sleeping for {} seconds . . . ", HEARTBEAT_1_SLEEP);
                    ThreadSleep.sleepForSeconds(HEARTBEAT_1_SLEEP);
                }
                LOGGER.info("[Heartbeat 1] - Shutting down");
            }
        };
    }

    private void createHeartBeat2() {
        heartbeat2 = new Thread() {
            public void run() {
                int index = 0;
                while(heartbeat2Active && index < FAIL_SAFE) {
                    index++;

                    LOGGER.info("[Heartbeat 2] - Sending heartbeat then sleeping for {} seconds . . . ", HEARTBEAT_2_SLEEP);
                    ThreadSleep.sleepForSeconds(HEARTBEAT_2_SLEEP);
                }
                LOGGER.info("[Heartbeat 2] - Shutting down");
            }
        };
    }

    public void runHeartbeats() {
        if (heartbeat1 == null) {
            createHeartBeat1();
        }
        if (heartbeat2 == null) {
            createHeartBeat2();
        }


        heartbeat1.start();
        heartbeat2.start();
    }


    public void setHeartbeat1Active(boolean active) {
        this.heartbeat1Active = active;
    }

    public void setHeartbeat2Active(boolean active) {
        this.heartbeat2Active = active;
    }

    public boolean isHeartbeat1Active() {
        return this.heartbeat1Active;
    }
    public boolean isHeartbeat2Active() {
        return this.heartbeat2Active;
    }

}
