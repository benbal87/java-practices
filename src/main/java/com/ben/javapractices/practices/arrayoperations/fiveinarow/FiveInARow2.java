package com.ben.javapractices.practices.arrayoperations.fiveinarow;

public class FiveInARow2 {

    private final char EMPTY = '.';

    private final int[][] DIRECTIONS = new int[][] {
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 }
    };

    private int fieldSize;

    private double seroprevalence;

    public FiveInARow2() {
    }

    public FiveInARow2(int fieldSize, double seroprevalence) {
        this.fieldSize = fieldSize;
        this.seroprevalence = seroprevalence;
    }

    public static void main(String[] args) {
        FiveInARow2 fiveInARow = new FiveInARow2(15, 0.5);
        boolean result = fiveInARow.seekWinnerInRandomField();
        System.out.println("\n" + result);
    }

    public char[][] generateField() {
        char[][] result = new char[fieldSize][fieldSize];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                double randomNumber = Math.random();

                if (randomNumber > seroprevalence) {
                    double randomNumberForCharacter = Math.random();

                    if (randomNumberForCharacter > seroprevalence) {
                        result[i][j] = 'X';
                    } else {
                        result[i][j] = 'O';
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }

        displayField(result);

        return result;
    }

    public void displayField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == 0) {
                    System.out.print("[" + field[i][j] + ", ");
                } else if (j == field[i].length - 1) {
                    System.out.print(field[i][j] + "]");
                } else {
                    System.out.print(field[i][j] + ", ");
                }
            }

            System.out.print("\n");
        }
    }

    public boolean seekWinnerInRandomField() {
        char[][] field = generateField();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != EMPTY) {
                    if (seekWinnerInDirections(field, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean seekWinner(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != EMPTY) {
                    if (seekWinnerInDirections(field, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean seekWinnerInDirections(char[][] field, int indexI, int indexJ) {
        int counter = 0;
        char actualPlayer = field[indexI][indexJ];

        for (int[] directionPair : DIRECTIONS) {
            for (int i = 1; i <= 4; i++) {
                int di = directionPair[0] * i;
                int dj = directionPair[1] * i;
                int neighBourI = di + indexI;
                int neighBourJ = dj + indexJ;

                if (neighBourI >= 0 && neighBourI < field.length && neighBourJ >= 0
                    && neighBourJ < field[neighBourI].length) {
                    if (field[neighBourI][neighBourJ] == actualPlayer) {
                        counter++;
                    }
                }

                if (counter == 4) {
                    return true;
                }
            }

            counter = 0;
        }

        return false;
    }

}
