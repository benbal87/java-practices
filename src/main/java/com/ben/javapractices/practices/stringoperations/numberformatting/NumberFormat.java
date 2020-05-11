/*
 * The formatNumber function gets a number as a String and
 * rounds it and formats the number and returns a string.
 */

package com.ben.javapractices.practices.stringoperations.numberformatting;

import java.text.DecimalFormat;

public class NumberFormat {

    private static final int THOUSAND_SEPARATOR = 3;

    public static String formatNumber(String inputString) {
        double convertedString = Double.parseDouble(inputString);
        DecimalFormat decimalFormat = new DecimalFormat("0");
        String roundedString = decimalFormat.format(convertedString);

        String reversedRoundedString = new StringBuilder(roundedString).reverse().toString();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < reversedRoundedString.length(); i++) {
            if (i % THOUSAND_SEPARATOR == 0 && i != 0) {
                stringBuilder.append(' ');
            }
            char actualChar = reversedRoundedString.charAt(i);
            stringBuilder.append(actualChar);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String[] inputString = { "12.5678", "12.3456", "123.567", "1234.5678", "18941984984651.234242343" };

        for (int i = 0; i < inputString.length; i++) {
            String formmatedString = NumberFormat.formatNumber(inputString[i]);
            System.out.println(formmatedString);
        }
    }

}
