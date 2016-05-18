package com.krieghb.javasnips.utils;

/**
 * Created by krido02 on 5/18/2016.
 *
 */
public class Incrementer {

    private int matchCount;
    private int noMatchCount;

    public Incrementer() {
        this.matchCount = 0;
        this.noMatchCount = 0;
    }


    public void incrementMatch() {
        this.matchCount += 1;
    }
    public int getMatchCount() {
        return this.matchCount;
    }

    public void incrementNoMatch() {
        this.noMatchCount += 1;
    }
    public int getNoMatchCount() {
        return this.noMatchCount;
    }
}
