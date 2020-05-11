/*
 * Write a function that takes an (unsigned) integer as input, and returns
 * the number of bits that are equal to one in the binary representation
 * of that number.
 *
 * Example:
 * The binary representation of 1234 is 10011010010, so the
 * function should return 5 in this case.
 */

package com.ben.javapractices.practices.codewars.kyu6.bitcounting;

public class BitCounting {

    public static int countBits(int number) {
        return Integer.bitCount(number);
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println(BitCounting.countBits(n));
    }

}
