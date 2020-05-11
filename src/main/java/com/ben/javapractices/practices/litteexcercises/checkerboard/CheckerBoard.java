package com.ben.javapractices.practices.litteexcercises.checkerboard;

/*
 * Write a program called CheckerBoard that displays the following (n=7) checkerboard pattern using two nested
 * for-loops. The method name is printBoard.
 **/
public class CheckerBoard {

    public static void printBoard(int height, int weight) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                System.out.print("# ");
                if (j == 2) {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CheckerBoard.printBoard(7, 7);
    }

}
