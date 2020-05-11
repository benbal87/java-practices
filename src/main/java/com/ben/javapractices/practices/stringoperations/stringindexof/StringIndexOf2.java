package com.ben.javapractices.practices.stringoperations.stringindexof;

public class StringIndexOf2 {

    public static int indexOf(String inputString, char character) {
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == character) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(String inputString, char character, int searchFrom) {
        for (int i = searchFrom; i < inputString.length(); i++) {
            if (inputString.charAt(i) == character) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 0123456789
        String inputString = "aaXaaaaXaa";

        System.out.println(StringIndexOf2.indexOf(inputString, 'X')); // 2
        System.out.println(StringIndexOf2.indexOf(inputString, 'X', 3)); // 7
    }

}
