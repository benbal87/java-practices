package com.ben.javapractices.practices.stringoperations.stringpatternreplace;

public class StringPatternReplace1 {

    private final char[] patternFrom = new char[] { 'a', 'b', 'c' };

    private final char[] patternTo = new char[] { '@', '&', '#' };

    public static void main(String[] args) {
        String inputString = "XXaXXbXXcXXa";
        StringPatternReplace1 stringPatternReplace1 = new StringPatternReplace1();
        String result = stringPatternReplace1.replace(inputString);
        System.out.println(result);
    }

    private String replace(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);

        for (int i = 0; i < stringBuilder.length(); i++) {
            for (int j = 0; j < patternFrom.length; j++) {
                if (inputString.charAt(i) == patternFrom[j]) {
                    stringBuilder.replace(i, i + 1, Character.toString(patternTo[j]));
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }

}
