package com.krieghb.javasnips.utilities;

public class UtilityMethods {


    /**
     * 
     *  Method to return the stack trace in the form of a StringBuilder object.
     * 
     * @param e     Exception object to send the stack trace into a string builder object.
     * @return      Returns the StringBuilder object containing the stacktrace.
     */
    public static String stackTraceToStr(Exception e) {
        StringBuilder stackTrace = new StringBuilder();
        stackTrace.append("Message:  ").append(e.toString()).append("\n");
        for (Object stackT : e.getStackTrace()) {
            stackTrace.append("\t\t");
            stackTrace.append(stackT.toString());
            stackTrace.append("\n");
        }
        
        return stackTrace.toString();
    }
}
