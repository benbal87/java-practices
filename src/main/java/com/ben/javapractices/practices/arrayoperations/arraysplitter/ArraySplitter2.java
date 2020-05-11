/*
 * 1. Generate n random integers and store them in an array
 * 2. Write a method which gets an array of integers and splits
 * it to as few sub-arrays (keeping the order) as possible,
 * but these sub-arrays must not contain duplications
 *
 * Random numbers should be between 0 and 20 and the return type of the splitter method
 * is a 2 dimensional array of integers
 * example: [1, 2, 3, 4, 4, 5, 6, 7, 7, 8] -> [[1, 2, 3, 4], [4, 5, 6, 7], [7, 8]]
 */

package com.ben.javapractices.practices.arrayoperations.arraysplitter;

public class ArraySplitter2 {

    private int size;

    private int minValue;

    private int maxValue;

    public ArraySplitter2(int size, int minValue, int maxValue) {
        this.size = size;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static void main(String[] args) {
        int size = 40;
        int minValue = 10;
        int maxValue = 40;

        ArraySplitter2 arraySplitter = new ArraySplitter2(size, minValue, maxValue);
        int[][] splittedArray = arraySplitter.splitArray();
        arraySplitter.displayMatrix(splittedArray);
    }

    public int[] generateRandomArray() {
        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            int randomNumber = (int) (Math.random() * (maxValue + 1 - minValue)) + minValue;
            result[i] = randomNumber;
        }

        return result;
    }

    public int[][] splitArray() {
        int[] randomArray = generateRandomArray();

        for (int i = 0; i < randomArray.length; i++) {
            if (i == 0) {
                System.out.print("[" + randomArray[i] + ", ");
            } else if (i == randomArray.length - 1) {
                System.out.print(randomArray[i] + "]");
            } else {
                System.out.print(randomArray[i] + ", ");
            }
        }
        System.out.print("\n");

        int rowNumber = calculateRowNumber(randomArray);
        int[][] result = new int[rowNumber][];

        int start = 0;
        int rowIndex = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (i != randomArray.length - 1) {
                for (int j = start; j < i; j++) {
                    if (randomArray[i] == randomArray[j]) {
                        int[] row = new int[i - start];

                        int start2 = start;
                        for (int k = 0; k < row.length; k++) {
                            row[k] = randomArray[start2++];
                        }

                        result[rowIndex] = row;
                        start = i;
                        rowIndex++;
                    }
                }
            } else {
                int[] row = new int[randomArray.length - start];

                int start2 = start;
                for (int k = 0; k < row.length; k++) {
                    row[k] = randomArray[start2++];
                }

                result[rowIndex] = row;
            }

        }

        return result;
    }

    public int calculateRowNumber(int[] randomArray) {
        int start = 0;
        int rowCount = 1;

        for (int i = 1; i < randomArray.length; i++) {
            for (int j = start; j < i; j++) {
                if (randomArray[i] == randomArray[j]) {
                    start = i;
                    rowCount++;
                    break;
                }
            }
        }

        return rowCount;
    }

    public void displayMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length == 0) {
                System.out.print("[ ]");
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length == 1) {
                    System.out.print("[");
                    System.out.print(array[i][j]);
                    System.out.print("]");
                } else if (j == 0) {
                    System.out.print("[");
                    System.out.print(array[i][j]);
                    System.out.print(", ");
                } else if (j == array[i].length - 1) {
                    System.out.print(array[i][j]);
                    System.out.print("]");
                } else {
                    System.out.print(array[i][j]);
                    System.out.print(", ");
                }
            }
            System.out.print("\n");
        }
    }

}
