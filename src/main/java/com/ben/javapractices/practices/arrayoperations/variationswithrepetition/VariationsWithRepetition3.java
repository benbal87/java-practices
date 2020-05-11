package com.ben.javapractices.practices.arrayoperations.variationswithrepetition;

/*
 * This variation algorithm increases the length of the possible password if it checked all possible variations for the
 * given password length and than checking them again.
 */

public class VariationsWithRepetition3 {

    private final char[] SET_OF_VALUES = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z'
    };

    private final String PASSWORD = "codecool";

    public static void main(String[] args) {
        VariationsWithRepetition3 crack = new VariationsWithRepetition3();

        long[] workingTimes = new long[20];
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            crack.enumerateVariations();
            long stop = System.currentTimeMillis();
            workingTimes[i] = stop - start;
        }

        long averageTime = 0;
        for (long time : workingTimes) {
            averageTime += time;
        }
        averageTime /= workingTimes.length;

        System.out.println(averageTime);
    }

    public void enumerateVariations() {
        for (int i = 1; i <= 10; i++) {
            int[] actualVariation = new int[i];
            while (!matchFound(actualVariation)) {
                for (int j = 0; j < actualVariation.length; j++) {
                    actualVariation[j]++;
                    if (actualVariation[j] != SET_OF_VALUES.length) {
                        break;
                    }
                    actualVariation[j] = 0;
                }
                if (isLastVariation(actualVariation)) {
                    break;
                }

                for (int index : actualVariation) {
                    System.out.print(SET_OF_VALUES[index]);
                }
                System.out.println();

            }
            if (matchFound(actualVariation)) {
                break;
            }
        }
    }

    public boolean isLastVariation(int[] actualVariation) {
        for (int index : actualVariation) {
            if (SET_OF_VALUES[index] != SET_OF_VALUES[SET_OF_VALUES.length - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean matchFound(int[] actualVariation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index : actualVariation) {
            stringBuilder.append(SET_OF_VALUES[index]);
        }
        if (PASSWORD.equals(stringBuilder.toString())) {
            return true;
        }
        return false;
    }

}
