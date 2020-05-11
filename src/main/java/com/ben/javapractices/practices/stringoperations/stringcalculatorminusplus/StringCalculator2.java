package com.ben.javapractices.practices.stringoperations.stringcalculatorminusplus;

import java.util.StringTokenizer;

public class StringCalculator2 {

    public static void main(String[] args) {
        try {
            StringCalculator2 stringCalculator = new StringCalculator2();
            int result = stringCalculator.calculate("-1 - 20    +3"); // -18
            System.out.println(result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    int calculate(String inputString) throws Exception {
        if (inputString == null || inputString.equals("")) {
            throw new Exception("invalid input");
        }
        String formed = inputString.replaceAll(" ", "").replaceAll("\t", "");
        StringTokenizer stringTokenizer = new StringTokenizer(formed, "+-", true);
        int result = 0;
        int factor = 1;
        while (stringTokenizer.hasMoreTokens()) {
            String string = stringTokenizer.nextToken();
            if (string.equals("-")) {
                factor = -1;
            } else if (string.equals("+")) {
                factor = 1;
            } else {
                result += factor * Integer.parseInt(string);
            }
        }
        return result;
    }

}
