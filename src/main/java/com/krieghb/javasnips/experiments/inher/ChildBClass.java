package com.krieghb.javasnips.experiments.inher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by krido02 on 11/2/2016.
 *
 */
public class ChildBClass extends ParentClass{

    private static final Logger LOGGER = LoggerFactory.getLogger(ChildBClass.class);

    private String childNotice;
    private boolean isLazy;


    public ChildBClass() {

    }
    public ChildBClass(String parentName, int parentAge, double parentDou, String childNotice, boolean isLazy) {
        this.parentName = parentName;
        this.parentAge = parentAge;
        this.parentDou = parentDou;
        this.childNotice = childNotice;
        this.isLazy = isLazy;
    }



    public void sayHi()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("This is Child B saying hi.").append("\n")
                .append("Name:      ").append(parentName).append("\n")
                .append("Age:       ").append(parentAge).append("\n")
                .append("Double:    ").append(parentDou).append("\n")
                .append("Notice:    ").append(childNotice).append("\n")
                .append("Lazy:      ").append(isLazy).append("\n")
        ;
        LOGGER.info("{}", sb.toString());
    }


    public String getChildNotice() {
        return childNotice;
    }

    public void setChildNotice(String childNotice) {
        this.childNotice = childNotice;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
