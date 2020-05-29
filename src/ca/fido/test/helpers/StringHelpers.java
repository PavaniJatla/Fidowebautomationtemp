package ca.fido.test.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class StringHelpers {
	
	/**
	 * This will extract the numbers from string
	 * @param strMatch complete string to be matched
	 * @return String number
	 */
	public static String getNumbersFromString(String strMatch) {
		Pattern pattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
        Matcher match = pattern.matcher(strMatch);  
        match.find();
        return match.group();
	}

}
