package com.ben.javapractices.practices.arrayoperations.trianglearray;

import java.util.Arrays;

public class TriangleArray1 {

    public static void main(String[] args) {
        String text = "COLLECTOR";
        TriangleArray1 triangleArray1 = new TriangleArray1();
        triangleArray1.displayTriangle(text);
    }

    public char[][] generateTriangle(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        // creating the string triangle
        for (int i = input.length() - 1; i >= 0; i--) {
            for (int x = input.length() - 1; x >= i; x--) {
                stringBuilder.append(input.charAt(x));
            }
            stringBuilder.append("\n");
        }
        for (int i = input.length() - 1; i >= 1; i--) {
            for (int x = input.length() - 1; x >= input.length() - i; x--) {
                stringBuilder.append(input.charAt(x));
            }
            stringBuilder.append("\n");
        }

        String[] lines = stringBuilder.toString().split("\n");

        char[][] charArray = new char[input.length() * 2 - 1][];

        // inserting the characters from the string array to the char array
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            charArray[i] = line.toCharArray();
        }

        return charArray;
    }

    public void displayTriangle(String input) {
        char[][] charArray = generateTriangle(input);

        for (char[] row : charArray) {
            System.out.println(Arrays.toString(row));
        }

    }

    /*
     * [L]
     * [L, O]
     * [L, O, O]
     * [L, O, O, C]
     * [L, O, O, C, E]
     * [L, O, O, C, E, D]
     * [L, O, O, C, E, D, O]
     * [L, O, O, C, E, D, O, C]
     * [L, O, O, C, E, D, O]
     * [L, O, O, C, E, D]
     * [L, O, O, C, E]
     * [L, O, O, C]
     * [L, O, O]
     * [L, O]
     * [L]
     */
}
