package com.ben.javapractices.practices.littleoopexcercises.towersofhannoi;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print("LETS PLAY THE TOWERS OF HANNOI!");
            System.out.println("\nPlease give the number of disks and towers you want to play with.");
            System.out.println("Max number of towers is 3 and for the disks it is 9!");
            System.out.print("\nNumber of towers:\t");
            int towers = scanner.nextInt();
            System.out.print("Number of disks:\t");
            int disks = scanner.nextInt();
            new Game(towers, disks);
        } catch (InterruptedException | IOException exception) {
            exception.printStackTrace();
        }
    }

}
