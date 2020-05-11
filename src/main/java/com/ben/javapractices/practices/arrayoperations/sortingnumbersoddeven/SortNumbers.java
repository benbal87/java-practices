/*
 * Write a method which gets an array of integers (int) as a parameter and reorders
 * the elements the following way (and returns with the ordered array):
 * First element is an odd number, if there is one.
 * Every odd number should be followed with an even number, if there is one and
 * every even number should be followed with an odd number, if there is one
 * (eg. [1,4,5,8,...etc.])
 * Odd numbers and even numbers should be ordered ascendingly.
 * Array must not contain an element more than once
 * For example:
 * input = {9,7,5,3,1,6,9,4}
 *
 * output = {1,4,3,6,5,7,9}
 *
 * Usage of the followings are FORBIDDEN:
 * - internet
 * - IDE
 * - classes outside of java.lang package
 * - boxing classes like java.lang.Integer, etc.
 */

package com.ben.javapractices.practices.arrayoperations.sortingnumbersoddeven;

public class SortNumbers {

    public static void main(String[] args) {
        int[] inputArray = new int[] { 5, 9, 9, 9, 7, 5, 3, 1, 6, 9, 4 };

        SortNumbers sortNumbers = new SortNumbers();
        int[] resultArray = sortNumbers.sortNumbers(inputArray);

        for (int number : resultArray) {
            System.out.print(number + "    ");
        }

        /*
         * sort
         * 1, 3, 4, 5, 5, 6, 7, 9, 9, 9, 9
         * remove duplicates
         * 1, 3, 4, 5, 6, 7, 9
         * odd numbers
         * 1, 3, 5, 7, 9
         * even numbers
         * 4, 6
         * merged array
         * 1, 4, 3, 6, 5, 7, 9
         */

    }

    private int[] sortNumbers(int[] inputArray) {
        if (inputArray.length <= 1) {
            return inputArray;
        }

        sortArray(inputArray);
        //		System.out.println("sort - \n 1, 3, 4, 5, 5, 6, 7, 9, 9, 9, 9");
        //		System.out.println(Arrays.toString(inputArray));

        //      int[] arraySortedWithoutDuplicates = removeDuplicatesFromSortedArray(inputArray);
        //		System.out.println("remove duplicates - \n 1, 3, 4, 5, 6, 7, 9");
        //		System.out.println(Arrays.toString(arraySortedWithoutDuplicates));

        //		int[] oddNumbersArray = getOddNumbers(arraySortedWithoutDuplicates);
        //		System.out.println("odd numbers - \n 1, 3, 5, 7, 9");
        //		System.out.println(Arrays.toString(oddNumbersArray));

        //		int[] evenNumbersArray = getEvenNumbers(arraySortedWithoutDuplicates);
        //		System.out.println("even numbers - \n 4, 6");
        //		System.out.println(Arrays.toString(evenNumbersArray));

        int[] oddNumbersArray = new int[] { 1, 3, 5 };
        int[] evenNumbersArray = new int[] { 2, 4, 6, 8, 10 };

        //		System.out.println("merged array - \n 1, 4, 3, 6, 5, 7, 9");
        //		System.out.println(Arrays.toString(mergedArray));

        return mergeArrays(oddNumbersArray, evenNumbersArray);
    }

    private int[] mergeArrays(int[] oddNumbersArray, int[] evenNumbersArray) {
        int[] result = new int[evenNumbersArray.length + oddNumbersArray.length];

        if (evenNumbersArray.length < oddNumbersArray.length) {
            for (int i = 0; i < evenNumbersArray.length; i++) {
                result[2 * i] = oddNumbersArray[i];
            }
            for (int i = 0; i < evenNumbersArray.length; i++) {
                result[2 * i + 1] = evenNumbersArray[i];
            }
            for (int i = evenNumbersArray.length; i < oddNumbersArray.length; i++) {
                result[evenNumbersArray.length + i] = oddNumbersArray[i];
            }
        } else {
            for (int i = 0; i < oddNumbersArray.length; i++) {
                result[2 * i] = oddNumbersArray[i];
            }
            for (int i = 0; i < oddNumbersArray.length; i++) {
                result[2 * i + 1] = evenNumbersArray[i];
            }
            for (int i = oddNumbersArray.length; i < evenNumbersArray.length; i++) {
                result[oddNumbersArray.length + i] = evenNumbersArray[i];
            }
        }
        return result;
    }

    private void sortArray(int[] inputArray) {
        boolean swap = true;

        while (swap) {
            swap = false;

            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    swap = true;
                }
            }
        }
    }

    public int[] removeDuplicatesFromSortedArray(int[] inputArray) {
        int[] result;

        int countDuplicates = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                countDuplicates++;
            }
        }

        result = new int[inputArray.length - countDuplicates];

        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i == 0 || inputArray[i] != inputArray[i - 1]) {
                result[count] = inputArray[i];
                count++;
            }
        }

        return result;
    }

    public int[] getOddNumbers(int[] inputArray) {
        int[] result;

        int oddCount = 0;
        for (int item : inputArray) {
            if (item % 2 == 1) {
                oddCount++;
            }
        }

        result = new int[oddCount];

        int resultCount = 0;
        for (int value : inputArray) {
            if (value % 2 == 1) {
                result[resultCount] = value;
                resultCount++;
            }
        }

        return result;
    }

    public int[] getEvenNumbers(int[] inputArray) {
        int[] result;

        int evenCount = 0;
        for (int item : inputArray) {
            if (item % 2 == 0) {
                evenCount++;
            }
        }

        result = new int[evenCount];

        int resultCount = 0;
        for (int value : inputArray) {
            if (value % 2 == 0) {
                result[resultCount] = value;
                resultCount++;
            }
        }

        return result;
    }

}
