package com.ben.javapractices.practices.stringoperations.stringindexof;

public class StringIndexOf1 {

    public static int indexOf(String inputString, char character) {
        inputString = inputString.toLowerCase();
        character = Character.toLowerCase(character);

        for (int i = 0; i < inputString.length(); i++) {
            char actualChar = Character.toLowerCase(inputString.charAt(i));
            if (character == actualChar) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(String inputString, char character, int indexFrom) {
        inputString = inputString.toLowerCase();
        character = Character.toLowerCase(character);

        for (int i = indexFrom; i < inputString.length(); i++) {
            char actualChar = Character.toLowerCase(inputString.charAt(i));
            if (character == actualChar) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 0123456789
        String inputString = "axXaaaaxaa";

        System.out.println(StringIndexOf1.indexOf(inputString, 'X')); // 1
        System.out.println(StringIndexOf1.indexOf(inputString, 'X', 3)); // 7
    }

}
