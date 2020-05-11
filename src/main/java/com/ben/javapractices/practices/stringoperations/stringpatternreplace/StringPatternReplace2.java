package com.ben.javapractices.practices.stringoperations.stringpatternreplace;

public class StringPatternReplace2 {

    private final char[] patternFrom = new char[] { 'a', 'b', 'c' };

    private final char[] patternTo = new char[] { '@', '&', '#' };

    public static void main(String[] args) {
        String inputString = "XXaXXbXXcXXa";
        StringPatternReplace2 stringPatternReplace = new StringPatternReplace2();
        String result = stringPatternReplace.replace(inputString);
        System.out.println(result);
    }

    private String replace(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char actualChar = inputString.charAt(i);
            for (int j = 0; j < patternFrom.length; j++) {
                if (inputString.charAt(i) == patternFrom[j]) {
                    actualChar = patternTo[j];
                    break;
                }
            }
            stringBuilder.append(actualChar);
        }

        return stringBuilder.toString();
    }

}
