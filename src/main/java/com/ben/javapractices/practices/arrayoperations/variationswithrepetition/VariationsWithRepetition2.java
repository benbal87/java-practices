package com.ben.javapractices.practices.arrayoperations.variationswithrepetition;

public class VariationsWithRepetition2 {

    private static char[] SET_OF_VALUES = new char[] { 'a', 'b', 'c' };

    private static String[] enumerateVariations(int passwordLength) {
        String[] result = new String[(int) Math.pow(SET_OF_VALUES.length, passwordLength)];
        int[] actualVariation = new int[passwordLength];
        for (int j = 0; j < result.length; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index : actualVariation) {
                stringBuilder.append(SET_OF_VALUES[index]);
            }
            result[j] = stringBuilder.toString();
            for (int i = actualVariation.length - 1; i >= 0; i--) {
                actualVariation[i]++;
                if (actualVariation[i] != SET_OF_VALUES.length) {
                    break;
                }
                actualVariation[i] = 0;
            }
        }
        return result;
    }

    public static boolean isLast(int[] actualVariation) {
        for (int index : actualVariation) {
            if (SET_OF_VALUES[index] != SET_OF_VALUES[SET_OF_VALUES.length - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] result = enumerateVariations(4);
        for (String string : result) {
            System.out.println(string);
        }
    }

}
