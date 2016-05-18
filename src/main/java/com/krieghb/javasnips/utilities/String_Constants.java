package com.krieghb.javasnips.utilities;

public final class String_Constants {


	public static final String STAR_SEPERATOR = "************************************************************";
    public static final String EOL = "End of Line";



    public static final String END_OF_LINE = "\n\n" + STAR_SEPERATOR + STAR_SEPERATOR +
    										 "\n" + String.format("%" + (STAR_SEPERATOR.length() + (EOL.length() / 2 ) ) + "s", EOL) + "\n" + STAR_SEPERATOR + STAR_SEPERATOR + "\n\n";

    
    
}
