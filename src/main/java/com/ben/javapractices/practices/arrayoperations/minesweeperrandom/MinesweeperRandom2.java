/*
 * Mine sweeper
 * Create a mine field.
 * It not should be an identity matrix!
 * Row lengths should differ from each other.
 * It should be filled randomly with mines.
 */

package com.ben.javapractices.practices.arrayoperations.minesweeperrandom;

import java.util.Arrays;

public class MinesweeperRandom2 {

    public final char EMPTY_FIELD = '.';

    public final char MINE = '*';

    public final int[][] DIRECTIONS = new int[][] {
        { -1, -1 },
        { -1, 0 },
        { -1, 1 },
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 },
        { 0, -1 }
    };

    public int maxRowNumber;

    public int minRowLength;

    public int maxRowLength;

    public MinesweeperRandom2(int maxRowNumber, int minRowLength, int maxRowLength) {
        this.maxRowNumber = maxRowNumber;
        this.minRowLength = minRowLength;
        this.maxRowLength = maxRowLength;
    }

    public static void main(String[] args) {
        int maxRowNumber = 20;
        int minRowLength = 5;
        int maxRowLength = 20;

        MinesweeperRandom2 minesweeperRandom = new MinesweeperRandom2(maxRowNumber, minRowLength, maxRowLength);
        minesweeperRandom.displaySolvedMineField();
    }

    public char[][] generateRandomMineFieldWithMines(int maxRowNumber, int minRowLength, int maxRowLength) {
        char[][] fieldWithoutMines = new char[maxRowNumber][];

        for (int i = 0; i < maxRowNumber; i++) {
            int randomRowLength = (int) (Math.random() * (maxRowLength - minRowLength)) + minRowLength;

            fieldWithoutMines[i] = new char[randomRowLength];

            for (int j = 0; j < randomRowLength; j++) {
                fieldWithoutMines[i][j] = Math.random() > 0.5 ? MINE : EMPTY_FIELD;
            }
        }

        return fieldWithoutMines;
    }

    public char[][] scanField() {
        char[][] fieldWithMines = generateRandomMineFieldWithMines(maxRowNumber, minRowLength, maxRowLength);

        for (int i = 0; i < fieldWithMines.length; i++) {
            for (int j = 0; j < fieldWithMines[i].length; j++) {
                if (fieldWithMines[i][j] == EMPTY_FIELD) {
                    countNeighbours(fieldWithMines, i, j);
                }
            }
        }

        char[][] solvedField = fieldWithMines;
        return solvedField;
    }

    public void countNeighbours(char[][] fieldWithMines, int indexI, int indexJ) {
        int neighboursNumber = 0;

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int neighbourIndexI = indexI + DIRECTIONS[i][0];
            int neighbourIndexJ = indexJ + DIRECTIONS[i][1];

            if (neighbourIndexI >= 0 && neighbourIndexI < fieldWithMines.length && neighbourIndexJ >= 0
                && neighbourIndexJ < fieldWithMines[neighbourIndexI].length
                && fieldWithMines[neighbourIndexI][neighbourIndexJ] == MINE) {
                neighboursNumber++;
            }
        }

        if (neighboursNumber != 0) {
            char neighboursNumberChar = Integer.toString(neighboursNumber).charAt(0);
            fieldWithMines[indexI][indexJ] = neighboursNumberChar;
        }
    }

    public void displaySolvedMineField() {
        char[][] solvedMineField = scanField();

        for (char[] row : solvedMineField) {
            System.out.println(Arrays.toString(row));
        }
    }

}
