package com.krieghb.javasnips.experiments.methodparam;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */

public class CallTest2 implements Callable {

    @Override
    public void call(String msg) {
        System.out.println( "My Second Message:  " + msg);
    }

}
