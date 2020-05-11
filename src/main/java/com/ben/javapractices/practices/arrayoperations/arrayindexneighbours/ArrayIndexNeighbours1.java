/*
 *	Write a program what can collect the neighbours of an element in a given 2d array;
 */

package com.ben.javapractices.practices.arrayoperations.arrayindexneighbours;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIndexNeighbours1 {

    public static void main(String[] args) {
        int[][] inputArray = new int[][] {
            { 1, 2, 3 },
            { 4, 5 },
            { 7, 8, 9 }
        };

        ArrayIndexNeighbours1 arrayIndexNeighbours1V2 = new ArrayIndexNeighbours1();

        int[] result1 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 0, 0);
        int[] result2 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 0, 1);
        int[] result3 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 0, 2);
        int[] result4 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 1, 0);
        int[] result5 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 1, 1);
        // int[] result6 = arrayIndexNeighboursV2.seekIndexNeighbours(inputArray, 1, 2); exception
        int[] result7 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 2, 0);
        int[] result8 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 2, 1);
        int[] result9 = arrayIndexNeighbours1V2.seekIndexNeighbours(inputArray, 2, 2);

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

    private int[] seekIndexNeighbours(int[][] inputArray, int indexI, int indexJ) {
        int[][] directions = new int[][] {
            { -1, 0 },
            { -1, 1 },
            { 0, 1 },
            { 1, 1 },
            { 1, 0 },
            { 1, -1 },
            { 0, -1 },
            { -1, -1 }
        };

        if (inputArray.length == 0 || indexI < 0 || indexJ < 0 || indexI > inputArray.length
            || indexJ > inputArray[indexI].length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        List<Integer> integerList = new ArrayList<>();

        for (int[] direction : directions) {
            int neighbourIndexI = direction[0] + indexI;
            int neighbourIndexJ = direction[1] + indexJ;

            if (neighbourIndexI >= 0 && neighbourIndexJ >= 0 && neighbourIndexI < inputArray.length
                && neighbourIndexJ < inputArray[neighbourIndexI].length) {
                int neighbour = inputArray[neighbourIndexI][neighbourIndexJ];
                integerList.add(neighbour);
            }
        }

        int[] result = new int[integerList.size()];

        for (int i = 0; i < integerList.size(); i++) {
            result[i] = integerList.get(i);
        }

        return result;
    }

}
