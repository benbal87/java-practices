package com.ben.javapractices.practices.arrayoperations.sudokuvalidator;

import java.util.ArrayList;
import java.util.Collections;

public class SudokuValidator {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][] { // good
            { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        int[][] matrix2 = new int[][] { // wrong column number
            { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 7, 9 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        int[][] matrix3 = new int[][] { // wrong size of elements
            { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 65, 1, 4, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
            { 7, 1, 3, 9, 2, -4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 77, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        int[][] matrix4 = new int[][] { // multiple occurrences in a row
            { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 7, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 4, 9, 1 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        int[][] matrix5 = new int[][] { // multiple occurrences in a
            // column
            { 5, 3, 4, 6, 7, 8, 1, 9, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        int[][] matrix6 = new int[][] { // multiple occurrences in a 3x3
            // box
            { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 8, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        int[][] matrix7 = new int[][] { // every error occurs
            { 5, 3, 4, 7, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 7, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2 },
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };
        SudokuValidator sudoku = new SudokuValidator();
        System.out.println(sudoku.checkSudoku(matrix1)); // true
        System.out.println(sudoku.checkSudoku(matrix2)); // false
        System.out.println(sudoku.checkSudoku(matrix3)); // false
        System.out.println(sudoku.checkSudoku(matrix4)); // false
        System.out.println(sudoku.checkSudoku(matrix5)); // false
        System.out.println(sudoku.checkSudoku(matrix6)); // false
        System.out.println(sudoku.checkSudoku(matrix7)); // false
    }

    // Check if the given int[][] is a sudoku or not.
    private Boolean checkSudokuSize(int[][] matrix) {
        if (matrix.length != 9) {
            return false;
        }
        for (int[] ints : matrix) {
            if (ints.length != 9) {
                return false;
            }
        }
        return true;
    }

    // Check if the size of any element in the matrix is not bigger than 9.
    private Boolean checkSizeOfElements(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int matrixElement : ints) {
                if (matrixElement > 9) {
                    return false;
                }
            }
        }
        return true;
    }

    // Check that the numbers 1 to 9 appear exactly once in each row.
    private Boolean checkOccurrencesInRows(int[][] matrix) {
        try {
            for (int[] ints : matrix) {
                ArrayList<Integer> columnList = new ArrayList<>();
                for (int j = 0; j < matrix.length; j++) {
                    Integer columnElementInteger = ints[j];
                    columnList.add(columnElementInteger);
                }
                for (Integer element : columnList) {
                    int occurrence = Collections.frequency(columnList, element);
                    if (occurrence > 1) {
                        return false;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
        return true;
    }

    // Check that the numbers 1 to 9 appear exactly once in each column.
    private Boolean checkOccurrencesInColumns(int[][] matrix) {
        try {
            for (int i = 0; i < matrix.length; i++) {
                ArrayList<Integer> columnList = new ArrayList<>();
                for (int[] ints : matrix) {
                    Integer columnElementInteger = ints[i];
                    columnList.add(columnElementInteger);
                }
                for (Integer element : columnList) {
                    int occurrence = Collections.frequency(columnList, element);
                    if (occurrence > 1) {
                        return false;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
        return true;
    }

    // Check that the numbers 1 to 9 appear exactly once in each 3x3 box.
    private Boolean checkOccurrencesInBoxes(int[][] matrix) {
        try {
            int n = 0;
            int k = 3;
            for (int x = 0; x < 3; x++) {
                int l = 0;
                int m = 3;
                while (l < 7 && m < 10) {
                    ArrayList<Integer> columnList = new ArrayList<>();
                    for (int i = n; i < k; i++) {
                        for (int j = l; j < m; j++) {
                            Integer columnElementInteger = matrix[i][j];
                            columnList.add(columnElementInteger);
                        }
                    }
                    for (Integer element : columnList) {
                        int occurrence = Collections.frequency(columnList, element);
                        if (occurrence > 1) {
                            return false;
                        }
                    }
                    l += 3;
                    m += 3;
                }
                n += 3;
                k += 3;
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
        return true;
    }

    private Boolean checkSudoku(int[][] matrix) {
        int number = (checkSudokuSize(matrix) ? 1 : 0) + (checkSizeOfElements(matrix) ? 1 : 0)
                     + (checkOccurrencesInRows(matrix) ? 1 : 0) + (checkOccurrencesInColumns(matrix) ? 1 : 0)
                     + (checkOccurrencesInBoxes(matrix) ? 1 : 0);
        return number == 5;
    }

}
