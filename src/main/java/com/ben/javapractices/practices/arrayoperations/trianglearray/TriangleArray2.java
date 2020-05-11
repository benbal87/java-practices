package com.ben.javapractices.practices.arrayoperations.trianglearray;

public class TriangleArray2 {

    public static void main(String[] args) {
        String inputString = "CODECOOL";
        TriangleArray2 triangleArray = new TriangleArray2();
        char[][] array = triangleArray.generateTriangle(inputString);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                char actualChar = array[i][j];

                if (j == 0 && array[i].length == 1) {
                    System.out.print("[");
                    System.out.print(actualChar);
                    System.out.print("]");
                } else if (j == 0) {
                    System.out.print("[");
                    System.out.print(actualChar);
                    System.out.print(", ");
                } else if (j == array[i].length - 1) {
                    System.out.print(actualChar);
                    System.out.print("]");
                } else {
                    System.out.print(actualChar);
                    System.out.print(", ");
                }
            }
            System.out.print("\n");
        }
    }

    public char[][] generateTriangle(String inputString) {
        String inputStringReversed = new StringBuilder(inputString).reverse().toString();
        char[][] result = new char[2 * inputString.length() - 1][];

        for (int i = 0; i < result.length / 2; i++) {
            String sub = inputStringReversed.substring(0, i + 1);
            char[] subArray = sub.toCharArray();
            result[i] = subArray;
            result[result.length - 1 - i] = subArray;
        }

        result[inputString.length() - 1] = inputStringReversed.toCharArray();
        return result;
    }

    /*
     * [L]
     * [L, O]
     * [L, O, O]
     * [L, O, O, C]
     * [L, O, O, C, E]
     * [L, O, O, C, E, D]
     * [L, O, O, C, E, D, O]
     * [L, O, O, C, E, D, O, C]
     * [L, O, O, C, E, D, O]
     * [L, O, O, C, E, D]
     * [L, O, O, C, E]
     * [L, O, O, C]
     * [L, O, O]
     * [L, O]
     * [L]
     */
}
