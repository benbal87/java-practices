package com.ben.javapractices.practices.stringoperations.parenthesisvalidator;

public class ParenthesisValidator {

    private static final String[] BRACKETS = new String[] { "()", "[]", "{}", "<>" };

    public static void main(String[] args) {
        String inputString = "(<<([[({())])>)]";
        String inputString2 = "(([<[({()})]>]))";
        String inputString3 = "(([[({<()})]>]))";
        ParenthesisValidator parenthesisValidator = new ParenthesisValidator();
        boolean result = parenthesisValidator.isValid(inputString);
        boolean result2 = parenthesisValidator.isValid(inputString2);
        boolean result3 = parenthesisValidator.isValid(inputString3);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }

    public boolean isValid(String inputString) {
        String string = new String(inputString);
        while (containsAnyBrackets(string)) {
            for (String bracket : BRACKETS) {
                string = string.replace(bracket, "");
            }
        }
        return string.length() == 0;
    }

    public boolean containsAnyBrackets(String inputString) {
        for (String string : BRACKETS) {
            if (inputString.contains(string)) {
                return true;
            }
        }
        return false;
    }

}
