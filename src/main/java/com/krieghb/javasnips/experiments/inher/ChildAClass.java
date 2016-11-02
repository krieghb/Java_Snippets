package com.krieghb.javasnips.experiments.inher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by krido02 on 11/2/2016.
 *
 */
public class ChildAClass extends ParentClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChildAClass.class);

    private String childNote;
    private boolean isFan;


    public ChildAClass() {

    }
    public ChildAClass(String parentName, int parentAge, double parentDou, String childNote, boolean isFan) {
        this.parentName = parentName;
        this.parentAge = parentAge;
        this.parentDou = parentDou;
        this.childNote = childNote;
        this.isFan = isFan;
    }

    public void sayHi()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("This is Child A saying hi.").append("\n")
                .append("Name:  ").append(parentName).append("\n")
                .append("Age:   ").append(parentAge).append("\n")
                .append("Double:  ").append(parentDou).append("\n")
                .append("Note:    ").append(childNote).append("\n")
                .append("Fan:     ").append(isFan).append("\n")
                ;
        LOGGER.info("{}", sb.toString());
    }


    public String getChildNote() {
        return childNote;
    }

    public void setChildNote(String childNote) {
        this.childNote = childNote;
    }

    public boolean isFan() {
        return isFan;
    }

    public void setFan(boolean fan) {
        isFan = fan;
    }
}
