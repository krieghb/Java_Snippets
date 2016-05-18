package com.krieghb.javasnips.experiments;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public enum EStrings {

    OY("Oy"),
    STAR_SEPERATOR("**************************************************");

    private final String stringVal;

    private EStrings(String myString) {
        this.stringVal = myString;

    }

    public String value() {
        return this.stringVal;
    }

}
