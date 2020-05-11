package com.ben.javapractices.practices.arrayoperations.shufflearray;

import java.util.Arrays;

public class ShuffleArray {

    private static void shuffleArray(char[] inputCharArray, int indexStart, int indexEnd) {
        char[] originalArray = new char[inputCharArray.length];

        System.arraycopy(inputCharArray, 0, originalArray, 0, originalArray.length);

        while (!checkIfChanged(inputCharArray, originalArray)) {
            for (int i = indexEnd; i > indexStart; i--) {
                int randomIndex = (int) (Math.random() * (indexEnd + 1 - indexStart)) + indexStart;
                char temp = inputCharArray[randomIndex];
                inputCharArray[randomIndex] = inputCharArray[i];
                inputCharArray[i] = temp;
            }
        }
    }

    private static boolean checkIfChanged(char[] inputCharArray, char[] originalArray) {
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != inputCharArray[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[] array = new char[] { '1', '2' };
        ShuffleArray.shuffleArray(array, 0, 1);
        System.out.println(Arrays.toString(array));
    }

}
