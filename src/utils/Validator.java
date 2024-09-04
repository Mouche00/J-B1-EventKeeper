package utils;

import utils.enums.InputType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Validator {



    public static boolean isEmpty(String str) {
        boolean isEmpty = str.isEmpty();
        if(isEmpty) System.out.println("ERROR: Input string cannot be empty");
        return isEmpty;
    }

    public static boolean isInteger(String str) {
        boolean isInteger = str.matches("^[-+]?\\d+$");
        if(!isInteger) System.out.println("ERROR: Input integer is not valid");
        return isInteger;
    }

    public static boolean isDate(String str) {
        boolean isDate = str.matches("^\\d{4}-\\d{2}-\\d{2}$");
        if(!isDate) System.out.println("ERROR: Input date is not valid");
        return isDate;
    }

    public static boolean isWhithinRange(String option, int min, int max) {
        if(max <= min) return false;

        boolean isWhithinRange = validateInteger(option) >= min && validateInteger(option) <= max;
        if(!isWhithinRange) System.out.println("ERROR: Input option is not valid");
        return isWhithinRange;
    }

    public static int ValidateOption(String str){
        if(isInteger(str)) {
            return Parser.parseInt(str);
        }

        return -1;
    }


    public static int validateInteger(String str) {
        if(isInteger(str)) {
            return Parser.parseInt(str);
        }

        return -1;
    }

    public static String validateInput(String prompt, InputType type, int... range){
        String input;
        do {
            System.out.print("\n" + prompt);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } while(type == InputType.DATE ? !isDate(input)
            : type == InputType.OPTION ? !isWhithinRange(input, range[0], range[1]) || !isInteger(input)
            : type == InputType.INTEGER ? !isInteger(input)
            : isEmpty(input));

        return input;
    }

    public static boolean listIsEmpty(List<?> list) {
        if(list.isEmpty()){
            System.out.println("\nNo data available!\n");
            return true;
        }

        return false;
    }
}
