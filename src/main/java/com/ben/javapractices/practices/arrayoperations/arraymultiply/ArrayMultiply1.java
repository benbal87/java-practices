/*
 *	Benedek Balazs 2016-10-17
 */

/*
 *	Create a method with return parameter int[][]. The input parameter also an int[][].
 *	First multiply the elements of the odd-number indexed rows with -1.
 *	Then multiply the elements of the odd-number indexed columns with -1.
 *	New array should not be created just return with the changed input array.
 */

package com.ben.javapractices.practices.arrayoperations.arraymultiply;

import java.util.Arrays;

public class ArrayMultiply1 {

    public static void main(String[] args) {
        int[][] inputArray = new int[][] {
            { 5, 8, 4, 6, -15 },
            { 4, 4, 8, 45, 489, -14 },
            { 12, 28, 35 },
            { 123, -8, 92, 64, 93, 88, -64 },
            { 45, 65, 73, 74, 3 }
        };

        ArrayMultiply1 arrayMultiply1 = new ArrayMultiply1();
        int[][] result = arrayMultiply1.multiplyArray(inputArray);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        /*
         *	[5, -8, 4, -6, -15]
         *	[-4, 4, -8, 45, -489, -14]
         *	[12, -28, 35]
         *	[-123, -8, 92, 64, -93, 88, 64]
         *	[45, -65, 73, -74, 3]
         */
    }

    public int[][] multiplyArray(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    inputArray[i][j] = inputArray[i][j] * -1;
                }
            }
        }

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (j % 2 != 0) {
                    inputArray[i][j] = inputArray[i][j] * -1;
                }
            }
        }

        return inputArray;
    }

}
