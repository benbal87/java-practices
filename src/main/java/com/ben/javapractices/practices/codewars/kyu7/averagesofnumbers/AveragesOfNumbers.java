package com.ben.javapractices.practices.codewars.kyu7.averagesofnumbers;

import java.util.Arrays;

public class AveragesOfNumbers {

    private static double[] averages(int[] input) {
        double[] result;

        if (input == null) {
            result = new double[0];
            return result;
        } else if (input.length == 0) {
            result = new double[0];
            return result;
        } else if (input.length == 1) {
            result = new double[0];
            return result;
        } else {
            result = new double[input.length - 1];

            for (int i = 0; i < input.length; i++) {
                if (i + 1 < input.length) {
                    result[i] = (double) (input[i] + input[i + 1]) / 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] numbers = new int[] { 2, 2, 2, 2, 2 }; // { 2, 2, 2, 2 }
        // int[] numbers = new int[] { 2, -2, 2, -2, 2 }; // { 0, 0, 0, 0 }
        int[] numbers = new int[] { 1, 3, 5, 1, -10 }; // { 2, 4, 3, -4.5 }

        double[] result = AveragesOfNumbers.averages(numbers);
        System.out.println(Arrays.toString(result));
    }

}
