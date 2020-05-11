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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySplitter1 {

    public static void main(String[] args) {
        ArraySplitter1 arraySplitter1 = new ArraySplitter1();
        Integer[][] array = arraySplitter1.splitArray(50, 20);

        for (Integer[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[] generateNumberArray(int quantity, int max) {
        int[] result = new int[quantity];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(result) + "\n");
        return result;
    }

    public Integer[][] splitArray(int quantity, int max) {
        int[] generatedArray = generateNumberArray(50, 20);
        List<Integer[]> resultList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        for (int integer : generatedArray) {
            if (!subList.contains(integer)) {
                subList.add(integer);
            } else {
                Integer[] subArray = subList.toArray(new Integer[1]);
                resultList.add(subArray);
                subList.clear();
                subList.add(integer);
            }
        }

        return resultList.toArray(new Integer[1][]);
    }

}
