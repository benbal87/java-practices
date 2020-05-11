/*
 * Usage of the followings are FORBIDDEN:
 * - internet
 * - IDE
 * - classes outside of java.lang package
 * - boxing classes like java.lang.Integer, etc.
 *
 * Write a method which can insert (NOT update) an int value into an array
 * of integers (int[]) at a given index and returns with the new array.
 * Throw an ArrayIndexOutOfBoundsException where it is necessary !
 *
 * Write a method which can delete an element from an array of integers
 * (int[]) at a given index and returns with the new array.
 * Throw an ArrayIndexOutOfBoundsException where it is necessary !
 */

package com.ben.javapractices.practices.arrayoperations.arrayinsertanddelete;

import java.util.Arrays;

public class ArrayModification2 {

    public static int[] insertIntoArray(int[] input, int numberToInsert, int insertIndex) {
        if (insertIndex > input.length || insertIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        boolean isInserted = false;
        int[] result = new int[input.length + 1];

        for (int i = 0; i < input.length; i++) {
            if (i == insertIndex && !isInserted) {
                result[i] = numberToInsert;
                isInserted = true;
                i--;
            } else if (isInserted) {
                result[i + 1] = input[i];
            } else {
                result[i] = input[i];
            }
        }

        return result;
    }

    public static int[] deleteFromArray(int[] input, int numberToDelete, int deleteIndex) {
        if (deleteIndex > input.length || deleteIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        boolean skipped = false;
        int[] result = new int[input.length - 1];

        for (int i = 0; i < result.length; i++) {
            if (deleteIndex == i && numberToDelete == input[i]) {
                i++;
                result[i - 1] = input[i];
                skipped = true;
            } else if (skipped) {
                result[i - 1] = input[i];
            } else {
                result[i] = input[i];
            }
        }

        if (skipped) {
            result[result.length - 1] = input[input.length - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int numberToInsert = 21;
        int insertIndex = 5;
        int numberToDelete = 5;
        int deleteIndex = 5;
        int[] resultArray1 = ArrayModification2.insertIntoArray(input, numberToInsert, insertIndex);
        int[] resultArray2 = ArrayModification2.deleteFromArray(input, numberToDelete, deleteIndex);

        System.out.println(Arrays.toString(resultArray1));
        System.out.println(Arrays.toString(resultArray2));
    }

}
