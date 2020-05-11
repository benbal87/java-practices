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
 *
 *
 * INPUT ARRAY
 * [ a ] [ b ] [ c ] [ d ] [ e ]
 *
 * RESULT ARRAY
 * [ a ] [ b ] [ c ] [ d ] [ e ]
 * [ b ] [ c ] [ d ] [ e ] [ a ]
 * [ c ] [ d ] [ e ] [ a ] [ b ]
 * [ d ] [ e ] [ a ] [ b ] [ c ]
 * [ e ] [ a ] [ b ] [ c ] [ d ]
 *
 * [0.0] [0.1] [0.2] [0.3] [0.4]
 * 				 |
 * 				 V
 * [0.0] [0.1] [0.2] [0.3] [0.4]
 * [0.1] [0.2] [0.3] [0.4] [0.0]
 * [0.2] [0.3] [0.4] [0.1] [0.2]
 * [0.3] [0.4] [0.1] [0.2] [0.3]
 * [0.4] [0.1] [0.2] [0.3] [0.4]
 */

package com.ben.javapractices.practices.arrayoperations.stringsorttoarray;

import java.util.Arrays;

public class StringSortArray1 {

    public static void main(String[] args) {
        String inputText = "arg nAo�fn[doiwqXndo�]Ciqwn�q[egn";
        StringSortArray1 stringSortArray1 = new StringSortArray1();
        char[][] resultArray = stringSortArray1.generateArray(inputText);
        for (char[] row : resultArray) {
            System.out.println(Arrays.toString(row));
        }
    }

    public String sortStringAlphabetically(String inputText) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();

        String alphabet = "a�bcde�fghi�jklmno���pqrstu���vwxyzA�BCDE�FGHI�JKLMNO���PQRSTU���VWXYZ";

        for (int i = 0; i < alphabet.length(); i++) {
            char actualChar = alphabet.charAt(i);
            String actualCharString = String.valueOf(actualChar);

            if (inputText.contains(actualCharString)) {
                stringBuilder.append(alphabet.charAt(i));
            }
        }

        result = stringBuilder.toString();
        return result;
    }

    public char[][] generateArray(String inputText) {
        inputText = sortStringAlphabetically(inputText);
        char[] inputTextCharArray = inputText.toCharArray();
        char[][] result = new char[inputText.length()][inputText.length()];

        int i = 0;
        result[i] = inputTextCharArray;

        for (i = 1; i < result.length; i++) {
            char[] previousLine = result[i - 1];
            char[] actualLine = new char[previousLine.length];
            char firstChar = previousLine[0];

            for (int j = 0; j < actualLine.length - 1; j++) {
                actualLine[j] = previousLine[j + 1];
            }

            actualLine[actualLine.length - 1] = firstChar;

            result[i] = actualLine;
        }

        return result;
    }

}
