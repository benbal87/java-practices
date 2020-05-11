package com.ben.javapractices.practices.stringoperations.phonepad2;

import java.util.HashMap;

public class PhonePad {

    private final static HashMap<Integer, char[]> keypad = new HashMap<>();

    static {
        keypad.put(2, new char[] { 'A', 'B', 'C' });
        keypad.put(3, new char[] { 'D', 'E', 'F' });
        keypad.put(4, new char[] { 'G', 'H', 'I' });
        keypad.put(5, new char[] { 'J', 'K', 'L' });
        keypad.put(6, new char[] { 'M', 'N', 'O' });
        keypad.put(7, new char[] { 'P', 'Q', 'R', 'S' });
        keypad.put(8, new char[] { 'T', 'U', 'V' });
        keypad.put(9, new char[] { 'W', 'X', 'Y', 'Z' });
        keypad.put(0, new char[] { ' ' });
    }

    public static void main(String[] args) {
        PhonePad phonePad = new PhonePad();

        String keyString1 = "22222266631332226661666555";
        String keyString2 = "3";
        String keyString3 = "999666880887777331308666022212555155506330666166022233555155574466616633";
        String keyString4 = "5555666444444660866608443303277755077774443133";
        String keyString5 = "02212222224567";

        System.out.println(phonePad.keypadReader(keyString1)); // "CODECOOL"
        System.out.println(phonePad.keypadReader(keyString2)); // "D"
        System.out.println(phonePad.keypadReader(keyString3)); // "YOU USED TO CALL ME ON CELLPHONE"
        System.out.println(phonePad.keypadReader(keyString4)); // "JOIN TO THE DARK SIDE"
        System.out.println(phonePad.keypadReader(keyString5)); // " BCGJMP"
    }

    private String keypadReader(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Character previousChar = null;
        int arrayIndex = 0;
        Character charToAppend = null;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int keypadNum = Character.getNumericValue(currentChar);
            char[] CurrentValues = keypad.get(keypadNum);
            if (previousChar == null) {
                charToAppend = CurrentValues[0];
                previousChar = currentChar;
            } else if (previousChar == currentChar && keypadNum != 1) {
                arrayIndex = (arrayIndex + 1) % CurrentValues.length;
                charToAppend = CurrentValues[arrayIndex];
            } else {
                arrayIndex = 0;
                stringBuilder.append(charToAppend);
                if (keypadNum == 1) {
                    charToAppend = 0;
                } else {
                    charToAppend = CurrentValues[arrayIndex];
                }
                previousChar = currentChar;
            }
            if (i == input.length() - 1) {
                stringBuilder.append(charToAppend);
            }
        }
        return stringBuilder.toString();
    }

}
