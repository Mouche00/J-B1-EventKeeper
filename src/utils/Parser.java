package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Parser {
    public static LocalDate parseDate(String str){
        try {
            return LocalDate.parse(str);
        } catch (DateTimeParseException e) {
            System.out.println("\nERROR: Date parsing failed\n");
        }
        return LocalDate.now();
    }

    public static int parseInt(String str){
        try{
            return Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println("\nERROR: Integer parsing failed\n");
        }
        return -1;
    }
}
