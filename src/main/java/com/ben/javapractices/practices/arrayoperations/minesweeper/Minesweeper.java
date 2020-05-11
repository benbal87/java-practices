package com.ben.javapractices.practices.arrayoperations.minesweeper;

import java.util.Arrays;

public class Minesweeper {

    private final int[][] directions = new int[][] {
        { -1, -1 },
        { -1, 0 },
        { -1, 1 },
        { 0, -1 },
        { 0, 1 },
        { 1, -1 },
        { 1, 0 },
        { 1, 1 }
    };

    public static void main(String[] args) {
        char[][] mineField = new char[][] {
            { '.', '.', '.', '.', '.', '.', '*', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.' },
            { '*', '*', '.', '.', '.', '.', '*', '.' },
            { '.', '.', '.', '*', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '*', '*', '.', '.' },
            { '.', '.', '*', '.', '.', '.', '*', '.' },
            { '.', '.', '.', '.', '*', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.' }
        };

        Minesweeper minesweeper = new Minesweeper();
        minesweeper.displayMineField(mineField);
    }

    // Counts the number of the neighbour bombs around the actual position.
    private char[][] detectBombs(char[][] mineField) {
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[i].length; j++) {
                if (mineField[i][j] == '.') {
                    int numberOfBombs = countNeighbourBombs(i, j, mineField);

                    if (numberOfBombs > 0) {
                        mineField[i][j] = Character.forDigit(numberOfBombs, 10);
                    }
                }
            }
        }
        return mineField;
    }

    private int countNeighbourBombs(int i, int j, char[][] mineField) {
        int count = 0;

        for (int[] direction : directions) {
            int di = i + direction[0];
            int dj = j + direction[1];

            if (di >= 0 && di < mineField.length && dj >= 0 && dj < mineField[di].length && mineField[di][dj] == '*') {
                count++;
            }
        }

        return count;
    }

    private void displayMineField(char[][] mineField) {
        char[][] exploredMineField = detectBombs(mineField);

        for (char[] chars : exploredMineField) {
            System.out.println(Arrays.toString(chars));
        }
    }

}
