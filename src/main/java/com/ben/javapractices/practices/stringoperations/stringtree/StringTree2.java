package com.ben.javapractices.practices.stringoperations.stringtree;

public class StringTree2 {

    private static void displayTree(String inputString, int multiply) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < multiply; j++) {
                for (int k = 0; k < inputString.length() - i - 1; k++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < i * 2 + 1; k++) {
                    System.out.print(inputString.charAt(i));
                }

                for (int k = 0; k < inputString.length() - i - 1; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        String inputString = "0123456";
        StringTree2.displayTree(inputString, 3);
    }

}
