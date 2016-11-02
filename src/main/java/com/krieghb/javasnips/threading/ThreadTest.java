package com.krieghb.javasnips.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dk
 */


public class ThreadTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);
    private int foo = 1000;

    private Thread thread1 = null;
    private Thread thread2 = null;



    public class ThreadTest1 implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < foo; i++) {
                LOGGER.info("ThreadTest1 - foo:  {}", i);
            }
        }
    }

    public class ThreadTest2 implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < foo; i++) {
                LOGGER.info("ThreadTest2 - foo:  {}", i);
            }
        }
    }

    private void createThreads() {
        thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < foo; i++) {
                    LOGGER.info("ThreadTest1 - foo:  {}", i);
                }
            }
        };
        thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < foo; i++) {
                    LOGGER.info("ThreadTest2 - foo:  {}", i);
                }
            }
        };

    }

    private void runThreads() {
        if (thread1 != null && thread2 != null) {
            thread1.start();
            thread2.start();
        }
        LOGGER.info("*****  Both Threads started  *****");
    }

    public void runThreadTest() {

//        ThreadTest1 threadTest1 = new ThreadTest1();
//        ThreadTest2 threadTest2 = new ThreadTest2();
//        threadTest1.run();
//        threadTest2.run();
        createThreads();
        runThreads();

    }
}
