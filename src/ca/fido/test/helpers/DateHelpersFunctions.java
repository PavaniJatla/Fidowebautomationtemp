package ca.fido.test.helpers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateHelpersFunctions {

    public  static boolean isValidDAte(String strDate){
        Locale locale=Locale.CANADA;;
        String datePattern = "MMM d, yyyy";
        ZoneId defaultZoneId = ZoneId.systemDefault();
        if(System.getProperty("Language").toString().equals("en"))
        {
            locale =Locale.CANADA;
            datePattern = "MMM d, yyyy";
        }else if(System.getProperty("Language").toString().equals("fr")){
            locale =Locale.CANADA_FRENCH;
            datePattern = "dd MMM yyyy";
        }

        try
        {
            DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(datePattern).toFormatter().withLocale(locale);
            LocalDate date = LocalDate.parse(strDate, dateFormatter);
        }
        /* Date format is invalid */
        catch (DateTimeParseException e)
        {
            return false;
        }
        /* Return true if date format is valid */
        return true;
    }
}
