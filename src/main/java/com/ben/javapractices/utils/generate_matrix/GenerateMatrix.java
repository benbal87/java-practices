package com.ben.javapractices.utils.generate_matrix;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GenerateMatrix {

    public int[][] generateMatrixAscending(int rowNumber, int columnNumber, int minValue) {
        int[][] result = new int[rowNumber][columnNumber];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = minValue++;
            }
        }
        return result;
    }

    public int[][] generateMatrixRandom(int rowNumber, int columnNumber, int minValue, int maxValue) {
        int[][] result = new int[rowNumber][columnNumber];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int randomNumber = (int) (Math.random() * ((maxValue + 1) - minValue)) + minValue;
                result[i][j] = randomNumber;
            }
        }
        return result;
    }

    public void displayMatrix(int[][] generatedMatrix) {
        for (int i = 0; i < generatedMatrix.length; i++) {
            for (int j = 0; j < generatedMatrix[i].length; j++) {
                if (j == 0) {
                    System.out.print("\t{ " + generatedMatrix[i][j] + ", ");
                } else if (j < generatedMatrix[i].length - 1) {
                    System.out.print(generatedMatrix[i][j] + ", ");
                } else if (j == generatedMatrix[i].length - 1 && i != generatedMatrix.length - 1) {
                    System.out.print(generatedMatrix[i][j] + " }, ");
                } else {
                    System.out.print(generatedMatrix[i][j] + " } };");
                }
            }
            System.out.print("\n");
        }
    }

}
