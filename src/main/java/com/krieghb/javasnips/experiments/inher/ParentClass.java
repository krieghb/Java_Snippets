package com.krieghb.javasnips.experiments.inher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by krido02 on 11/2/2016.
 *
 *
 *
 */
public class ParentClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentClass.class);

    protected String parentName;
    protected int parentAge;
    protected double parentDou;


    public void sayHi() {
        LOGGER.info("Saying hi from parent.");
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getParentAge() {
        return parentAge;
    }

    public void setParentAge(int parentAge) {
        this.parentAge = parentAge;
    }

    public double getParentDou() {
        return parentDou;
    }

    public void setParentDou(double parentDou) {
        this.parentDou = parentDou;
    }
}
