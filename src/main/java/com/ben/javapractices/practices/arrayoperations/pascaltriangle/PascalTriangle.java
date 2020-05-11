package com.ben.javapractices.practices.arrayoperations.pascaltriangle;

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        int[][] triangle = pascalTriangle.generatePascal(10);

        for (int i = 0; i < triangle.length; i++) {
            for (int k = 0; k < triangle.length - i - 1; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    public int[][] generatePascal(int rowNumber) {
        int[][] result = new int[rowNumber][];

        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i + 1];

            for (int j = 0; j < result[i].length; j++) {
                if (j == 0 || j == result[i].length - 1) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                }
            }
        }

        return result;
    }

}
