/*
 * Write a program what can collect the neighbours of an element in a given 2d array without list;
 */

package com.ben.javapractices.practices.arrayoperations.arrayindexneighbours;

import java.util.Arrays;

public class ArrayIndexNeighbours2 {

    public final int[][] DIRECTIONS = new int[][] {
        { -1, 0 },
        { -1, 1 },
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 },
        { 0, -1 },
        { -1, -1 }
    };

    public static void main(String[] args) {
        int[][] inputArray = new int[][] {
            { 1, 2, 3 },
            { 4, 5 },
            { 7, 8, 9 }
        };

        ArrayIndexNeighbours2 arrayIndexNeighboursV2 = new ArrayIndexNeighbours2();

        int[] result1 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 0, 0);
        int[] result2 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 0, 1);
        int[] result3 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 0, 2);
        int[] result4 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 1, 0);
        int[] result5 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 1, 1);
        // int[] result6 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 1, 2); exception
        int[] result7 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 2, 0);
        int[] result8 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 2, 1);
        int[] result9 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 2, 2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
        System.out.println(Arrays.toString(result5));
        // System.out.println(Arrays.toString(result6)); exception
        System.out.println(Arrays.toString(result7));
        System.out.println(Arrays.toString(result8));
        System.out.println(Arrays.toString(result9));

        /*	whole Array
         *	[2, 5, 4]
         *	[3, 6, 5, 4, 1]
         *	[6, 5, 2]
         *	[1, 2, 5, 8, 7]
         *	[2, 3, 6, 9, 8, 7, 4, 1]
         *	[3, 9, 8, 5, 2]
         *	[4, 5, 8]
         *	[5, 6, 9, 7, 4]
         *	[6, 8, 5]
         */

        /*	deficient Array
         *	[2, 5, 4]
         *	[3, 5, 4, 1]
         *	[5, 2]
         *	[1, 2, 5, 8, 7]
         *	[2, 3, 9, 8, 7, 4, 1]
         *	[4, 5, 8]
         *	[5, 9, 7, 4]
         *	[8, 5]
         */
    }

    public int[] seekIndexNeighbours(int[][] inputArray, int indexI, int indexJ) {

        if (inputArray.length == 0 || indexI < 0 || indexJ < 0 || indexI > inputArray.length
            || indexJ > inputArray[indexI].length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int arrayLength = countNeighbours(inputArray, indexI, indexJ);
        int[] neighBours = new int[arrayLength];

        int neighBoursIndex = 0;
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int neighbourIndexI = DIRECTIONS[i][0] + indexI;
            int neighbourIndexJ = DIRECTIONS[i][1] + indexJ;

            if (neighbourIndexI >= 0 && neighbourIndexJ >= 0 && neighbourIndexI < inputArray.length
                && neighbourIndexJ < inputArray[neighbourIndexI].length) {
                int neighbour = inputArray[neighbourIndexI][neighbourIndexJ];
                neighBours[neighBoursIndex++] = neighbour;
            }
        }

        return neighBours;
    }

    public int countNeighbours(int[][] inputArray, int indexI, int indexJ) {
        int count = 0;

        for (int[] direction : DIRECTIONS) {
            int neighbourIndexI = direction[0] + indexI;
            int neighbourIndexJ = direction[1] + indexJ;

            if (neighbourIndexI >= 0 && neighbourIndexJ >= 0 && neighbourIndexI < inputArray.length
                && neighbourIndexJ < inputArray[neighbourIndexI].length) {

                count++;
            }
        }

        return count;
    }

}
