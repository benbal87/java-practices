/*
 * Usage of the followings are FORBIDDEN:
 * - internet
 * - IDE
 * - classes outside of java.lang package
 * - boxing classes like java.lang.Integer, etc.
 *
 * Write a method which is able to generate the transpose of a matrix. The number of rows and number of columns are not
 * equal !
 * Example:
 * [1, 2, 3] -> [1, 4]
 * [4, 5, 6] [2, 5]
 * [3, 6]
 */

package com.ben.javapractices.practices.arrayoperations.matrix_transpose;

public class MatrixTranspose {

    public static void main(String[] args) {
        int[][] inputMatrix = new int[][] {
            { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
            { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 },
            { 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 },
            { 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 }
        };

        MatrixTranspose matrixTranspose = new MatrixTranspose();
        int[][] resultMatrix = matrixTranspose.transpose(inputMatrix);

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + "  ");
            }

            System.out.print("\n");
        }
    }

    public int[][] transpose(int[][] inputMatrix) {
        if (inputMatrix == null || inputMatrix.length == 0 || inputMatrix[0] == null) {
            return null;
        }

        int firstRowLength = inputMatrix[0].length;

        for (int i = 1; i < inputMatrix.length; i++) {
            if (inputMatrix[i] == null || inputMatrix[i].length != firstRowLength) {
                return null;
            }
        }

        int[][] resultMatrix = new int[inputMatrix[0].length][inputMatrix.length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                resultMatrix[j][i] = inputMatrix[i][j];
            }
        }

        return resultMatrix;
    }

}
