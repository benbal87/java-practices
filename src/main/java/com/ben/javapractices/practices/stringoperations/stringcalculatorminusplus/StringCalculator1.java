package com.ben.javapractices.practices.stringoperations.stringcalculatorminusplus;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator1 {

    public static void main(String[] args) {
        try {
            StringCalculator1 stringCalculator = new StringCalculator1();
            int result = stringCalculator.calculate("-1 - 20    +3"); // -18
            System.out.println(result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    int calculate(String inputString) {
        String formed = inputString.replaceAll(" ", "").replaceAll("\t", "");
        char[] delimiters = { '+', '-' };
        String[] splitted = split(formed, delimiters);
        int result = 0;
        int factor = 1;
        for (String string : splitted) {
            if (string.equals("-")) {
                factor = -1;
            } else if (string.equals("+")) {
                factor = 1;
            } else {
                int value = Integer.parseInt(string);
                result += factor * value;
            }
        }
        return result;
    }

    public String[] split(String inputString, char[] delimiterArray) {
        String[] splittedStringArray;
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char actualChar = inputString.charAt(i);
            if (isDelimiter(delimiterArray, actualChar)) {
                if (stringBuilder.length() > 0) {
                    stringList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
                stringList.add(String.valueOf(actualChar));
            } else {
                stringBuilder.append(actualChar);
            }
        }
        if (stringBuilder.length() > 0) {
            stringList.add(stringBuilder.toString());
        }
        splittedStringArray = stringList.toArray(new String[stringList.size()]);
        return splittedStringArray;
    }

    private boolean isDelimiter(char[] delimiterArray, char character) {
        for (char delimiter : delimiterArray) {
            if (character == delimiter) {
                return true;
            }
        }
        return false;
    }

}
