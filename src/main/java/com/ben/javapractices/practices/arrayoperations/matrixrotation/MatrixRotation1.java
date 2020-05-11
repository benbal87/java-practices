/*
 * Write a program that can rotate a matrix 'n' times with 90 degrees.
 */

package com.ben.javapractices.practices.arrayoperations.matrixrotation;

public class MatrixRotation1 {

    public static void main(String[] args) {
        int[][] inputMatrix = new int[][] {
            { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 },
            { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 },
            { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 },
            { 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 },
            { 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 },
            { 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 },
            { 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 },
            { 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 },
            { 90, 91, 92, 93, 94, 95, 96, 97, 98, 99 }
        };
        int rotateCount = 1;

        MatrixRotation1 matrixRotate = new MatrixRotation1();
        int[][] rotatedMatrix = matrixRotate.rotateMatrix(inputMatrix, rotateCount);
        matrixRotate.displayMatrix(rotatedMatrix);
    }

    public int[][] rotateMatrix(int[][] inputArray, int rotateCount) {
        rotateCount = rotateCount % 4;
        int[][] rotatedMatrix = rotateRightAngle(inputArray, rotateCount);

        if (rotateCount == 0) {
            return inputArray;
        } else if (rotateCount == 1) {
            return rotatedMatrix;
        } else {
            for (int i = 2; i <= rotateCount; i++) {
                rotatedMatrix = rotateRightAngle(rotatedMatrix, rotateCount);
            }
        }

        return rotatedMatrix;
    }

    public int[][] rotateRightAngle(int[][] inputArray, int rotateCount) {
        int[][] result = new int[inputArray[0].length][inputArray.length];

        int row = 0;
        int column = 0;

        for (int i = 0; i < inputArray[0].length; i++) {
            for (int j = inputArray.length - 1; j >= 0; j--) {
                result[row][column] = inputArray[j][i];
                column++;
            }

            row++;
            column = 0;
        }

        return result;
    }

    public void displayMatrix(int[][] rotatedMatrix) {
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                if (j == 0) {
                    System.out.print("[ " + rotatedMatrix[i][j] + ", ");
                } else if (j < rotatedMatrix[i].length - 1) {
                    System.out.print(rotatedMatrix[i][j] + ", ");
                } else if (j == rotatedMatrix[i].length - 1) {
                    System.out.print(rotatedMatrix[i][j] + " ]");
                }
            }

            System.out.print("\n");
        }
    }

}
