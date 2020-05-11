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

public class ArrayModification1 {

    public static void main(String[] args) {
        ArrayModification1 arrayOperations = new ArrayModification1();

        int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int numberToInput = 10;
        int inputIndex = 14;

        int numberToDelete = 0;
        int deleteIndex = 0;

        System.out.print("Original array: ");
        System.out.print(Arrays.toString(input));

        System.out.println("\nNumber to input: " + numberToInput + "\nInput index: " + inputIndex
                           + "\nNumber to delete: " + numberToDelete + "\nDelete index: " + deleteIndex);

        int[] result1 = arrayOperations.insertIntoIntArray(input, numberToInput, inputIndex);
        int[] result2 = arrayOperations.deleteFromIntArray(input, numberToDelete, deleteIndex);

        System.out.println("The new modified array with INSERTED element: " + Arrays.toString(result1));
        System.out.println("The new modified array without DELETED element: " + Arrays.toString(result2));
    }

    int[] insertIntoIntArray(int[] inputArray, int numberToInput, int inputIndex) {
        if (inputIndex < 0 || inputArray.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (inputIndex > inputArray.length + 1) {
            inputIndex = inputArray.length;
        }

        int[] result = new int[inputArray.length + 1];

        System.arraycopy(inputArray, 0, result, 0, inputIndex);

        result[inputIndex] = numberToInput;

        if (inputArray.length + 1 - inputIndex + 1 >= 0) {
            System.arraycopy(
                inputArray,
                inputIndex + 1 - 1,
                result,
                inputIndex + 1,
                inputArray.length + 1 - inputIndex + 1
            );
        }

        return result;
    }

    int[] deleteFromIntArray(int[] inputArray, int numberToDelete, int deleteIndex) {
        if (deleteIndex < 0 || deleteIndex >= inputArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (inputArray[deleteIndex] != numberToDelete) {
            throw new NullPointerException();
        }

        int[] resultArray = new int[inputArray.length - 1];

        System.arraycopy(inputArray, 0, resultArray, 0, deleteIndex);
        for (int i = deleteIndex + 1; i < inputArray.length; i++) {
            if (i + 1 < inputArray.length + 1) {
                resultArray[i - 1] = inputArray[i];
            }
        }

        return resultArray;
    }

}
