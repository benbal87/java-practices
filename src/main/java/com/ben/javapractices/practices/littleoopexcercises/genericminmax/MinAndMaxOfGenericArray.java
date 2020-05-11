package com.ben.javapractices.practices.littleoopexcercises.genericminmax;

public class MinAndMaxOfGenericArray {

    private static <T extends Number & Comparable<T>> T min(T[] inputArray) {
        T result = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i].compareTo(result) < 0) {
                result = inputArray[i];
            }
        }
        return result;
    }

    private static <T extends Number & Comparable<T>> T max(T[] inputArray) {
        T result = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i].compareTo(result) > 0) {
                result = inputArray[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] i = { -2147483648, 0, 2147483647 };
        System.out.println(min(i));
        System.out.println(max(i));

        Byte[] b = { -128, 0, 127 };
        System.out.println(min(b));
        System.out.println(max(b));

        Short[] s = { -32728, 0, 32767 };
        System.out.println(min(s));
        System.out.println(max(s));

        Long[] l = { -9223372036854775808L, 0L, 9223372036854775807L };
        System.out.println(min(l));
        System.out.println(max(l));

        Float[] f = { Float.MIN_VALUE, 0F, Float.MAX_VALUE };
        System.out.println(min(f));
        System.out.println(max(f));

        Double[] d = { Double.MIN_VALUE, 0D, Double.MAX_VALUE };
        System.out.println(min(d));
        System.out.println(max(d));
    }

}
