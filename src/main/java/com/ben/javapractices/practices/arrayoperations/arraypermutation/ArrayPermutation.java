package com.ben.javapractices.practices.arrayoperations.arraypermutation;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayPermutation {

    private int[] inputArray;

    private ArrayPermutation(int[] inputArray) {
        this.inputArray = inputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[] { 1, 2, 3, 4 };
        // int[] inputArray = new int[] {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2,
        // 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4,
        // 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ArrayPermutation arrayPermutation = new ArrayPermutation(inputArray);
        arrayPermutation.permutate();
    }

    private BigInteger calculatePermutationNumber() {
        BigInteger bigInteger = new BigInteger("1");

        for (int i = 0; i < inputArray.length; i++) {
            String index = Integer.toString(i + 1);
            BigInteger bigInteger1 = new BigInteger(index);
            bigInteger = bigInteger.multiply(bigInteger1);
        }

        return bigInteger;
    }

    private void permutate() {
        BigInteger bigInteger = calculatePermutationNumber();
        long n = bigInteger.longValue();

        int count = 1;
        while (count <= n) {
            for (int i = 0; i < inputArray.length - 1; i++) {
                swap(i, i + 1);
                // getSumOfYAxisDistance();
                System.out.println(count + "\t" + Arrays.toString(inputArray));
                count++;
            }
        }
    }

    public int getSumOfYAxisDistance() {
        int sumOfYAxisDistance = 1;

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < inputArray[i - 1]) {
                sumOfYAxisDistance++;
            } else {
                for (int j = i - 2; j <= 0; j++) {
                    if (inputArray[i] < inputArray[j]) {
                        sumOfYAxisDistance += i - j;
                        break;
                    }
                }
                sumOfYAxisDistance += i;
            }
        }

        return sumOfYAxisDistance;
    }

    private void swap(int index1, int index2) {
        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

}
