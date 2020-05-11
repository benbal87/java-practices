package com.ben.javapractices.practices.littleoopexcercises.genericminmax;

public class GenericOperations {

    private static <T extends Comparable<T>> T max(T[] inputArray) {
        T max = inputArray[0];

        for (T element : inputArray) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    private static <T extends Comparable<T>> T min(T[] inputArray) {
        T max = inputArray[0];

        for (T element : inputArray) {
            if (element.compareTo(max) < 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Integer[] intInput = new Integer[] { 1, 3, 5, 2 };
        Double[] doubleInput = new Double[] { 1.5, 2.8, 123.3, 3.5 };

        int maximumINT = max(intInput);
        int minimumINT = min(intInput);
        System.out.println("Max int: " + maximumINT + " " + "Min int: " + minimumINT);

        Double maximumDOUBLE = max(doubleInput);
        Double minimumDOUBLE = min(doubleInput);
        System.out.println("Max double: " + maximumDOUBLE + " " + "Min double: " + minimumDOUBLE);
    }

}
