package com.ben.javapractices.practices.stringoperations.stringcalculatorminusplus;

class StringCalculator3 {

    int calculate(String inputString) {
        int result = 0;
        int counter = 0;
        char operation = '+';

        for (int i = 0; i < inputString.length(); i++) {
            operation = inputString.charAt(i) == '+' ? '+' : inputString.charAt(i) == '-' ? '-' : operation;

            int number = 0;

            if (Character.isDigit(inputString.charAt(i))) {
                counter++;
                if (i == inputString.length() - 1) {
                    number = Integer.valueOf(inputString.substring(i - counter + 1));
                }
            } else if (counter > 0) {
                number = Integer.valueOf(inputString.substring(i - counter, i));
                counter = 0;
            }
            result = operation == '+' ? result + number : result - number;
        }
        return result;
    }

}
