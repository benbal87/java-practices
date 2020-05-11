package com.ben.javapractices.practices.arrayoperations.stringsorttoarray;

import java.util.Arrays;

/*
 * take the letters from a string
 * sort them aplhabetical
 * take them into character array
 * generate a return like the following
 * ['a', 'b', 'c', 'A', 'B']
 * ['b', 'c', 'A', 'B', 'a']
 * ['c', 'A', 'B', 'a', 'b']
 * ['A', 'B', 'a', 'b', 'c']
 * ['B', 'a', 'b', 'c', 'A']
 */

public class StringSortArray2 {

    public static void main(String[] args) {
        String inputText = "arg nAo�fn[doiwqXndo�]Ciqwn�q[egn";

        StringSortArray2 stringSortArray2 = new StringSortArray2();
        char[][] resultArray = stringSortArray2.generateArray(inputText);

        for (char[] row : resultArray) {
            System.out.println(Arrays.toString(row));
        }
    }

    public String sortStringAlphabetically(String inputText) {
        StringBuilder stringBuilder = new StringBuilder();
        String alphabet = "a�bcde�fghi�jklmno���pqrstu���vwxyzA�BCDE�FGHI�JKLMNO���PQRSTU���VWXYZ";

        for (int i = 0; i < alphabet.length(); i++) {
            char actualChar = alphabet.charAt(i);
            String actualCharString = String.valueOf(actualChar);

            if (inputText.contains(actualCharString)) {
                stringBuilder.append(alphabet.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public char[][] generateArray(String inputText) {
        inputText = sortStringAlphabetically(inputText);
        char[] inputTextCharArray = inputText.toCharArray();
        char[][] result = new char[inputText.length()][inputText.length()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = inputTextCharArray[(j + i) % result[i].length];
            }
        }

        return result;
    }

}
