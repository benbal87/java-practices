package com.ben.javapractices.practices.arrayoperations.variationswithrepetition;

public class VariationsWithRepetition1 {

    private char[] SET_OF_VALUES = new char[] { 'a', 'b', 'c' };

    public static void main(String[] args) {
        VariationsWithRepetition1 variationsWithRepetition = new VariationsWithRepetition1();
        variationsWithRepetition.enumerateVariations(4);
    }

    private void enumerateVariations(int passwordLength) {
        int[] actualVariation = new int[passwordLength];
        while (!isLastVariation(actualVariation)) {
            for (int i = actualVariation.length - 1; i >= 0; i--) {
                actualVariation[i]++;
                if (actualVariation[i] != SET_OF_VALUES.length) {
                    break;
                }
                actualVariation[i] = 0;
            }
            for (int index : actualVariation) {
                System.out.print(SET_OF_VALUES[index]);
            }
            System.out.println();
        }
    }

    private boolean isLastVariation(int[] actualVariation) {
        for (int index : actualVariation) {
            if (SET_OF_VALUES[index] != SET_OF_VALUES[SET_OF_VALUES.length - 1]) {
                return false;
            }
        }
        return true;
    }

}
