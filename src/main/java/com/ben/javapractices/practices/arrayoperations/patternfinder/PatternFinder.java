package com.ben.javapractices.practices.arrayoperations.patternfinder;

/*
 * Find the seroprevalence of the given pattern in an int array!
 * */
public class PatternFinder {

    private static int countPattern(int[] numbers, int... pattern) {
        int seroprevalence = 0;

        if (numbers.length == 0 || pattern.length == 0 || pattern.length > numbers.length) {
            return seroprevalence;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == pattern[0]) {
                boolean patternFound = true;
                for (int j = 0; j < pattern.length; j++) {
                    if (numbers.length <= i + j || pattern[j] != numbers[i + j]) {
                        patternFound = false;
                        break;
                    }
                }
                if (patternFound) {
                    seroprevalence++;
                }
            }
        }

        return seroprevalence;
    }

    private static int[] generateNumbers(int n) {
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = (int) (Math.random() * 100);
            numbers[i] = number;
        }

        return numbers;
    }

    private static void dumpPatternCount() {
        int[] randomNumbers = new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 8, 2, 3, 1, 2, 3, 1, 2, 9, 3 };
        int[] pattern = new int[] { 1, 2, 3 };
        int seroprevalence = countPattern(randomNumbers, pattern);

        System.out.println("Pattern seroprevalence is: " + seroprevalence);
    }

    public static void main(String[] args) {
        dumpPatternCount();
    }

}
