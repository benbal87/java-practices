package com.ben.javapractices.practices.arrayoperations.fiveinarow;

import java.util.ArrayList;
import java.util.List;

public class FiveInARow3 {

    private final char EMPTY = '.';

    private final char PLAYER_X = 'X';

    private final char PLAYER_O = 'O';

    private final int[][] DIRECTIONS = new int[][] {
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 }
    };

    private int fieldSize;

    private double seroprevalence;

    private List<String> matchesForX = new ArrayList<>();

    private List<String> matchesForO = new ArrayList<>();

    private FiveInARow3(int fieldSize, double seroprevalence) {
        this.fieldSize = fieldSize;
        this.seroprevalence = seroprevalence;
    }

    public static void main(String[] args) {
        FiveInARow3 fiveInARow = new FiveInARow3(15, 0.4);
        boolean result = fiveInARow.seekWinnerInRandomField();
        System.out.println("\n" + result);
    }

    private char[][] generateField() {
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

    private void displayField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == 0) {
                    System.out.print(i + "\t[" + field[i][j] + ", ");
                } else if (j == field[i].length - 1) {
                    System.out.print(field[i][j] + "]");
                } else {
                    System.out.print(field[i][j] + ", ");
                }
            }

            System.out.print("\n");
        }

        System.out.print("\n");
    }

    private void displayMatches() {
        for (String match : matchesForX) {
            System.out.println(match);
        }
        for (String match : matchesForO) {
            System.out.println(match);
        }
    }

    private boolean seekWinnerInRandomField() {
        char[][] field = generateField();

        int winCountPlayerX = 0;
        int winCountPlayerO = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != EMPTY) {
                    if (field[i][j] == PLAYER_X) {
                        winCountPlayerX += seekWinnerInDirections(field, i, j);
                    } else if (field[i][j] == PLAYER_O) {
                        winCountPlayerO += seekWinnerInDirections(field, i, j);
                    }
                }
            }
        }

        System.out.println("Total wins for player with X: " + winCountPlayerX);
        System.out.println("Total wins for player with O: " + winCountPlayerO);

        displayMatches();

        return winCountPlayerX != 0 || winCountPlayerO != 0;
    }

    private int seekWinnerInDirections(char[][] field, int indexI, int indexJ) {
        int counter = 0;
        char actualPlayer = field[indexI][indexJ];
        int winCount = 0;

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
                    collectMatchIndexes(indexI, indexJ, neighBourI, neighBourJ, actualPlayer);

                    winCount++;
                }
            }

            counter = 0;
        }

        return winCount;
    }

    private void collectMatchIndexes(int firstI, int firstJ, int lastI, int lastJ, char actualPlayer) {
        StringBuilder stringBuilder = new StringBuilder();

        if (actualPlayer == PLAYER_X) {
            stringBuilder.append("X - ");
        } else if (actualPlayer == PLAYER_O) {
            stringBuilder.append("O - ");
        }

        stringBuilder.append("(");
        stringBuilder.append(firstI);
        stringBuilder.append(", ");
        stringBuilder.append(firstJ);
        stringBuilder.append(")\t(");
        stringBuilder.append(lastI);
        stringBuilder.append(", ");
        stringBuilder.append(lastJ);
        stringBuilder.append(")");

        String matchIndexes = stringBuilder.toString();

        if (actualPlayer == PLAYER_X) {
            matchesForX.add(matchIndexes);
        } else if (actualPlayer == PLAYER_O) {
            matchesForO.add(matchIndexes);
        }
    }

}
