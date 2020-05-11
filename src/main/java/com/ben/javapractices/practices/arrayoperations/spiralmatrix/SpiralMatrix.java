package com.ben.javapractices.practices.arrayoperations.spiralmatrix;

/*
 * http://www.guideforschool.com/1260759-java-program-to-print-circular-spiral-matrix/
 */

public class SpiralMatrix {

    public static void main(String args[]) {
        int matrixSize = 8;
        int startNumber = 11;

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] spiral = spiralMatrix.generateSpiral(matrixSize, startNumber);

        for (int[] ints : spiral) {
            for (int j = 0; j < ints.length; j++) {
                if (j == 0) {
                    System.out.print("[" + ints[j] + ", ");
                } else if (j == ints.length - 1) {
                    System.out.print(ints[j] + "]");
                } else if (j < ints.length) {
                    System.out.print(ints[j] + ", ");
                }
            }

            System.out.print("\n");
        }
    }

    private int[][] generateSpiral(int matrixSize, int startNumber) {
        int[][] resultMatrix = new int[matrixSize][matrixSize];

        int columnFirst = 0;
        int columnLast = matrixSize - 1;
        int rowFirst = 0;
        int rowLast = matrixSize - 1;

        int lastNumber = matrixSize * matrixSize + startNumber - 1;

        while (startNumber <= lastNumber) {
            for (int i = columnFirst; i <= columnLast; i++) {
                resultMatrix[rowFirst][i] = startNumber++;
            }

            for (int j = rowFirst + 1; j <= rowLast; j++) {
                resultMatrix[j][columnLast] = startNumber++;
            }

            for (int i = columnLast - 1; i >= columnFirst; i--) {
                resultMatrix[rowLast][i] = startNumber++;
            }

            for (int j = rowLast - 1; j >= rowFirst + 1; j--) {
                resultMatrix[j][columnFirst] = startNumber++;
            }

            columnFirst++;
            columnLast--;
            rowFirst++;
            rowLast--;
        }

        return resultMatrix;
    }

}
