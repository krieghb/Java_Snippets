package com.krieghb.javasnips.experiments.methodparam;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public class CallTestTester {

    public static void main(String[] args) {
        Callable cmd = new CallTest();
        Callable cmd2 = new CallTest2();

        invoke(cmd, "Hi There!");
        invoke(cmd2, "Hi There From the second one!");

    }

    public static void invoke (Callable callable, String msg) {
        callable.call(msg);
    }

}
