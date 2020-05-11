package com.ben.javapractices.practices.arrayoperations.insertcharsequenceintochararray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertCharsIntoArray {

    public static void main(String[] args) {
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.add('d');

        char[] charArray = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        System.out.println(Arrays.toString(charArray));

        int startIndex = 2;
        int endIndex = 5;

        int count = 0;
        for (int m = startIndex; m <= endIndex; m++) {
            for (int n = count; n <= count; n++) {
                charArray[m] = charList.get(n);
            }
            count++;
        }

        System.out.println(Arrays.toString(charArray));
    }

}
