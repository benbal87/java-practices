package com.ben.javapractices.practices.littleoopexcercises.towersofhannoi;

class Gui {

    private int[][] actualStateOfGame;

    Gui(int[][] actualStateOfGame) {
        this.actualStateOfGame = actualStateOfGame;
        printPlayground();
    }

    private void printPlayground() {
        int sumOfTowerLengths = 0;
        for (int[] ints : actualStateOfGame) {
            if (ints != null) {
                sumOfTowerLengths += ints.length;
            }
        }

        int[] counts = new int[actualStateOfGame.length];

        for (int lineCount = sumOfTowerLengths + 1; lineCount > 0; lineCount--) {
            for (int tower = 0; tower < actualStateOfGame.length; tower++) {
                if (lineCount > actualStateOfGame[tower].length) {
                    for (int k = 0; k < sumOfTowerLengths; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("[0]");
                    for (int k = 0; k < sumOfTowerLengths - 1; k++) {
                        System.out.print(" ");
                    }
                } else {
                    int actualDiskSize = actualStateOfGame[tower][counts[tower]++];
                    for (int l = 0; l <= sumOfTowerLengths - actualDiskSize; l++) {
                        System.out.print(" ");
                    }
                    for (int l = 0; l < actualDiskSize; l++) {
                        System.out.print("-");
                    }
                    System.out.print(actualDiskSize);
                    for (int l = 0; l < actualDiskSize; l++) {
                        System.out.print("-");
                    }
                    for (int l = 0; l < sumOfTowerLengths - actualDiskSize; l++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("\n");
        }
    }

}
