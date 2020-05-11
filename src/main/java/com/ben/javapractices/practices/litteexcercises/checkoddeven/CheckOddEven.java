// Write a program called CheckOddEven
// which prints "Odd Number" if the int variable "number" is odd, or
// "Even Number" otherwise.
// The number is a member variable and initialized in the constructor.
// The printing method is called as PrintOdd.

package com.ben.javapractices.practices.litteexcercises.checkoddeven;

public class CheckOddEven {

    public static void main(String[] args) {
        CheckOddEven checkOddEven = new CheckOddEven();
        System.out.println(checkOddEven.CheckNumber(3));
    }

    private String CheckNumber(int number) {
        if (number % 2 == 0) {
            return "Even Number!";
        }
        return "Odd Number!";
    }

}
