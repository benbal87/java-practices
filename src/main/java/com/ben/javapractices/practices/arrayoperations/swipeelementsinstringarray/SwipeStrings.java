package com.ben.javapractices.practices.arrayoperations.swipeelementsinstringarray;

public class SwipeStrings {

    private static String[] swap(String[] arrayToSwap) {
        if (arrayToSwap.length != 2) {
            return null;
        }

        arrayToSwap[0] += arrayToSwap[1];
        arrayToSwap[1] = arrayToSwap[0].replace(arrayToSwap[1], "");
        arrayToSwap[0] = arrayToSwap[0].replace(arrayToSwap[1], "");

        return arrayToSwap;
    }

    private static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("INDEX " + i + ": " + array[i]);
        }
    }

    public static void main(String[] args) {
        String[] arrayToSwap = { "hinnnye", "ejjno" };

        String[] swapped = swap(arrayToSwap);

        if (swapped != null) {
            printArray(swapped);
        }
    }

}
