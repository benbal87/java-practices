package com.ben.javapractices.practices.arrayoperations.matrixrotation;

import java.util.Arrays;

public class MatrixRotation2 {

    public static int[][] rotateOnce(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            result[i] = reverse(getColumn(matrix, i));
        }
        return result;
    }

    public static int[][] rotateTwice(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = reverse(matrix[matrix.length - 1 - i]);
        }
        return result;
    }

    public static int[][] rotateThreeTimes(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            result[i] = getColumn(matrix, matrix[0].length - 1 - i);
        }
        return result;
    }

    public static int[][] rotate(int[][] matrix, int n) {
        if (matrix == null) {
            return null;
        }
        n %= 4;
        if (n == 0) {
            return matrix;
        }
        int[][] result;
        if (n == 1) {
            result = rotateOnce(matrix);
        } else if (n == 2) {
            result = rotateTwice(matrix);
        } else {
            result = rotateThreeTimes(matrix);
        }
        return result;
    }

    public static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[i][columnIndex];
        }
        return result;
    }

    public static int[] reverse(int[] array) {
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[array.length - 1 - i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = { { 1, 2, 3 }, { 4, 5, 6 } };
        result = rotate(result, -111);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }

}
