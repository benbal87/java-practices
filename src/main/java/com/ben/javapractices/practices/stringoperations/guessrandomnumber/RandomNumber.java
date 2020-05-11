package com.ben.javapractices.practices.stringoperations.guessrandomnumber;

import java.util.Scanner;

public class RandomNumber {

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.guessEvaluate();
    }

    public int generateRandomNumber() {
        double numberDouble = Math.random() * 100;
        return (int) numberDouble;
    }

    public boolean containsOnlyDigits(String input) {
        return input.matches("^[0-9]*$") && input.length() > 0;
    }

    public void guessEvaluate() {
        int randomNumber = generateRandomNumber();
        int attempts = 0;
        int guessNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("The generated random number is: " + randomNumber + "\n");
        while (randomNumber != guessNumber) {
            System.out.print("Write here your guess: ");
            String scannedText = scanner.nextLine();
            if (!containsOnlyDigits(scannedText)) {
                System.out.println("You can only input positive integers here!");
                continue;
            }
            guessNumber = Integer.parseInt(scannedText);
            if (randomNumber < guessNumber) {
                System.out.println("The number is SMALLER than you thought!");
            } else if (randomNumber > guessNumber) {
                System.out.println("The number is BIGGER than you thought!");
            }
            attempts++;
        }
        System.out.println(String.format("You guessed the number in %o attempts!", attempts));
        scanner.close();
    }

}
