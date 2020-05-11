package com.ben.javapractices.practices.littleoopexcercises.towersofhannoi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Tower> playground = new ArrayList<>();

    private int numberOfTowers;

    private int numberOfDisks;

    private int moveCounter;

    public Game(int numberOfTowers, int numberOfDisks) throws InterruptedException, IOException {
        if (numberOfTowers > 3 && numberOfDisks > 9) {
            this.numberOfTowers = 3;
            this.numberOfDisks = 9;
        } else if (numberOfTowers > 3) {
            this.numberOfTowers = 3;
            this.numberOfDisks = numberOfDisks;
        } else if (numberOfDisks > 9) {
            this.numberOfDisks = 9;
            this.numberOfTowers = numberOfTowers;
        } else {
            this.numberOfTowers = numberOfTowers;
            this.numberOfDisks = numberOfDisks;
        }
        initializeGame();
        moveDisk();
    }

    public List<Tower> getPlayground() {
        return playground;
    }

    private void initializeGame() throws InterruptedException, IOException {
        for (int i = 0; i < numberOfTowers; i++) {
            Tower pillar = new Tower();
            playground.add(pillar);
        }

        Tower pillarOne = playground.get(0);
        for (int i = numberOfDisks; i > 0; i--) {
            Disk disk = new Disk(i);
            pillarOne.pushDisk(disk);
        }
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        new Gui(getActualStateOfGame());
    }

    public int[][] getActualStateOfGame() {
        int[][] result = new int[playground.size()][];
        for (int i = 0; i < playground.size(); i++) {
            int[] row = new int[playground.get(i).getTowerHeight()];
            for (int j = 0; j < row.length; j++) {
                row[j] = playground.get(i).removeDisk().getDiskSize();
            }
            result[i] = row;
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = result[i].length - 1; j >= 0; j--) {
                Disk disk = new Disk(result[i][j]);
                playground.get(i).pushDisk(disk);
            }
        }
        return result;
    }

    private boolean isEndGame() {
        return playground.get(playground.size() - 1).getTowerHeight() == numberOfDisks;
    }

    private boolean validateMove(int fromTowerIndex, int toTowerIndex) {
        int fromTowerHeight = playground.get(fromTowerIndex).getTowerHeight();
        int toTowerHeight = playground.get(toTowerIndex).getTowerHeight();

        if (fromTowerHeight == 0) {
            return false;
        } else if (toTowerHeight > 0
                   && playground.get(fromTowerIndex).getUpperDiskSize() > playground
            .get(toTowerIndex)
            .getUpperDiskSize()) {
            return false;
        }
        return true;
    }

    public void moveDisk() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (!isEndGame()) {
                int[] moves = new int[2];
                System.out.print("\nNumber of tower from:\t");
                moves[0] = scanner.nextInt();
                System.out.print("Number of tower to:\t");
                moves[1] = scanner.nextInt();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                int fromTowerIndex = moves[0] - 1;
                int toTowerIndex = moves[1] - 1;
                if (validateMove(fromTowerIndex, toTowerIndex)) {
                    Disk diskToRemove = playground.get(fromTowerIndex).removeDisk();
                    playground.get(toTowerIndex).pushDisk(diskToRemove);
                    moveCounter++;
                    new Gui(getActualStateOfGame());
                } else {
                    new Gui(getActualStateOfGame());
                    System.out.println("\nWRONG MOVE! TRY AGAIN!");
                }
            }
        } catch (InterruptedException | IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("THE GAME IS OVER YOU WIN!");
        System.out.println("The total disk movings is: " + moveCounter);
        System.exit(1);
    }

}
