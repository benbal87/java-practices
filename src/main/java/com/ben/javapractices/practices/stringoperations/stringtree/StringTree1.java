package com.ben.javapractices.practices.stringoperations.stringtree;

public class StringTree1 {

    public static void displayTree(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < inputString.length() - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print(inputString.charAt(i));
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        String inputString = "0123456";
        StringTree1.displayTree(inputString);
    }

}
