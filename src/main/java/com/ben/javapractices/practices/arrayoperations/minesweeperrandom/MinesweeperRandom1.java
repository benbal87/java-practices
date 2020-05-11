/*
 * aknakeres�
 * nem egys�gm�trix (nem mindegyik sornak egyenl� a hossza)
 * v�letlenszer�ren kell felt�lteni akn�kkal
 * math random ha nagyobb mint 0.5 akkor tegyen akn�kat
 */

package com.ben.javapractices.practices.arrayoperations.minesweeperrandom;

import java.util.Arrays;

public class MinesweeperRandom1 {

    public int maxRowNumber;

    public int minRowLength;

    public int maxRowLength;

    public int[][] DIRECTIONS = new int[][] {
        { -1, -1 },
        { -1, 0 },
        { -1, 1 },
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 },
        { 0, -1 }
    };

    public MinesweeperRandom1(int maxRowNumber, int minRowLength, int maxRowLength) {
        this.maxRowNumber = maxRowNumber;
        this.minRowLength = minRowLength;
        this.maxRowLength = maxRowLength;
    }

    public static void main(String[] args) {
        MinesweeperRandom1 minesweeperRandom1 = new MinesweeperRandom1(20, 5, 20);
        minesweeperRandom1.displaySolvedMineField();
    }

    public char[][] generateRandomMineField(int maxRowNumber, int minRowLength, int maxRowLength) {
        char[][] fieldWithoutMines = new char[maxRowNumber][];

        for (int i = 0; i < maxRowNumber; i++) {
            int randomRowLength = (int) (Math.random() * (maxRowLength - minRowLength)) + minRowLength;

            char[] arrayPattern = new char[randomRowLength];
            fieldWithoutMines[i] = arrayPattern;

            for (int j = 0; j < randomRowLength; j++) {
                fieldWithoutMines[i][j] = '.';
            }
        }

        return fieldWithoutMines;
    }

    public char[][] generateMinesInRandomMineField() {
        char[][] fieldWithoutMines = generateRandomMineField(maxRowNumber, minRowLength, maxRowLength);

        for (int i = 0; i < fieldWithoutMines.length; i++) {
            for (int j = 0; j < fieldWithoutMines[i].length; j++) {
                double randomNumber = Math.random();

                if (randomNumber > 0.5) {
                    fieldWithoutMines[i][j] = '*';
                }
            }
        }

        char[][] fieldWithMines = fieldWithoutMines;
        return fieldWithMines;
    }

    public char[][] solveField() {
        char[][] fieldWithMines = generateMinesInRandomMineField();

        for (int i = 0; i < fieldWithMines.length; i++) {
            for (int j = 0; j < fieldWithMines[i].length; j++) {
                if (fieldWithMines[i][j] == '.') {
                    seekNeighbours(fieldWithMines, i, j);
                }
            }
        }

        char[][] solvedField = fieldWithMines;
        return solvedField;
    }

    public void seekNeighbours(char[][] fieldWithMines, int indexI, int indexJ) {
        int neighboursNumber = 0;

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int neighbourIndexI = indexI + DIRECTIONS[i][0];
            int neighbourIndexJ = indexJ + DIRECTIONS[i][1];

            if (neighbourIndexI >= 0 &&
                neighbourIndexI < fieldWithMines.length &&
                neighbourIndexJ >= 0 &&
                neighbourIndexJ < fieldWithMines[neighbourIndexI].length &&
                fieldWithMines[neighbourIndexI][neighbourIndexJ] == '*') {
                neighboursNumber++;
            }
        }

        if (neighboursNumber != 0) {
            char neighboursNumberChar = Integer.toString(neighboursNumber).charAt(0);
            fieldWithMines[indexI][indexJ] = neighboursNumberChar;
        }
    }

    public void displaySolvedMineField() {
        char[][] solvedMineField = solveField();

        for (char[] row : solvedMineField) {
            System.out.println(Arrays.toString(row));
        }
    }

}
