package com.ben.javapractices.practices.codewars.kyu7.givemeadiamond;

public class Diamond {

    public static String print(int n) {
        if (n % 2 == 0 || n < 0) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        int middleIndex = (int) ((double) n / 2 + 0.5);
        int numberOfSpaces = middleIndex - 1;
        int numberOfAsterisks = 1;

        for (int lineNumber = 1; lineNumber <= middleIndex; lineNumber++) {
            StringBuilder line = new StringBuilder();

            if (lineNumber < middleIndex) {
                for (int i = 1; i <= numberOfSpaces; i++) {
                    line.append(" ");
                }

                for (int i = 0; i <= numberOfAsterisks - 1; i++) {
                    line.append("*");
                }

                numberOfAsterisks += 2;
                line.append("\n");
                result.append(line);

                numberOfSpaces--;
            } else {
                for (int i = 1; i <= n; i++) {
                    line.append("*");
                }
                line.append("\n");
                result.append(line);
            }
        }

        String[] lines = result.toString().split("\\n");
        for (int i = lines.length - 2; i >= 0; i--) {
            result.append(lines[i]).append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(print(7));
    }

}
