/*
 * 2d int array
 * the app will return with a matrix of a specific element in the center of it with a radius
 */

package com.ben.javapractices.practices.arrayoperations.submatrix;

import java.util.Arrays;

public class SubMatrix {

    private int[][] inputArray;

    private int indexI;

    private int indexJ;

    private int radius;

    private SubMatrix(int[][] inputArray, int indexI, int indexJ, int radius) {
        this.inputArray = inputArray;
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.radius = radius;
    }

    public static void main(String[] args) {
        int[][] inputArray = new int[][] {
            //00  01  02  03  04  05  06  07  08  09
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }, // 0
            { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 }, // 1
            { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 }, // 2
            { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 }, // 3
            { 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 }, // 4
            { 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 }, // 5
            { 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 }, // 6
            { 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 }
        }; // 7
        int indexI = 3;
        int indexJ = 4;
        int radius = 120;

        SubMatrix subMatrix = new SubMatrix(inputArray, indexI, indexJ, radius);
        int[][] resultSubMatrix = subMatrix.getSubMatrix();

        for (int[] row : resultSubMatrix) {
            System.out.println(Arrays.toString(row));
        }

    }

    private int[][] getSubMatrix() {
        if (inputArray.length == 0
            || indexI < 0
            || indexI >= inputArray.length
            || indexJ < 0
            || indexJ >= inputArray[indexI].length) {
            throw new NullPointerException();
        }

        int[] subSizeArray = determineSubMatrixSize();
        int subMaxI = subSizeArray[0];
        int subMaxJ = subSizeArray[1];
        int[][] subMatrix = new int[subMaxI][subMaxJ];

        fillSubMatrix(inputArray, subMatrix);

        return subMatrix;
    }

    private int[] determineSubMatrixSize() {
        int[] result = new int[2];
        int countI = 0;
        int countJ = 0;

        // Vertical size

        if ((indexI + radius) < inputArray.length) {
            countI += radius + 1;
        } else {
            countI += inputArray.length - indexI;
        }

        if ((indexI - radius) >= 0) {
            countI += radius;
        } else {
            countI += indexI;
        }

        // Horizontal size

        if ((indexJ + radius) < inputArray.length) {
            countJ += radius + 1;
        } else {
            countJ += inputArray[indexI].length - indexJ;
        }

        if ((indexJ - radius) >= 0) {
            countJ += radius;
        } else {
            countJ += indexJ;
        }

        result[0] = countI;
        result[1] = countJ;

        return result;
    }

    private void fillSubMatrix(int[][] inputArray, int[][] subMatrix) {
        int subI = 0;
        int subJ = 0;

        for (int i = indexI - radius; i <= indexI + radius; i++) {
            for (int j = indexJ - radius; j <= indexJ + radius; j++) {
                if (i >= 0 && i < inputArray.length && j >= 0 && j < inputArray[i].length) {
                    int neighbour = inputArray[i][j];

                    if (subJ < subMatrix[0].length) {
                        subMatrix[subI][subJ] = neighbour;
                        subJ++;
                    } else {
                        subI++;
                        subJ = 0;
                        subMatrix[subI][subJ] = neighbour;
                        subJ++;
                    }
                }
            }
        }
    }

}
