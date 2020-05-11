package com.ben.javapractices.practices.stringoperations.stringcalculatorminusplusmultiply;

import java.util.StringTokenizer;

public class StringCalculatorMultiply {

    public static void main(String[] args) {
        try {
            StringCalculatorMultiply stringCalculator = new StringCalculatorMultiply();
            System.out.println("11 * 2 * 3 * 4 - 3 * 2 * 2");
            int result = stringCalculator.calculate("11 * 2 * 3 * 4 - 3 * 2 * 2");
            System.out.println(result);
            System.out.println(11 * 2 * 3 * 4 - 3 * 2 * 2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int calculate(String inputString) throws Exception {
        if (inputString == null || inputString.equals("")) {
            throw new Exception("invalid input");
        }
        String formedString = inputString.replaceAll(" ", "").replaceAll("\t", "");
        StringTokenizer stringTokenizer = new StringTokenizer(formedString, "+-", true);

        if (isThereAnyMultiplication(stringTokenizerToArray(stringTokenizer))) {
            stringTokenizer = new StringTokenizer(formedString, "+-*", true);
            String[] operations = stringTokenizerToArray(stringTokenizer);
            String[] operationsWithSolvedMultiplications = evaluateMultiplications(operations);
            String joinedString = String.join("", operationsWithSolvedMultiplications);
            stringTokenizer = new StringTokenizer(joinedString, "+-", true);
        } else {
            stringTokenizer = new StringTokenizer(formedString, "+-", true);
        }

        int result = 0;
        int factor = 1;
        while (stringTokenizer.hasMoreTokens()) {
            String string = stringTokenizer.nextToken();
            if (string.equals("-")) {
                factor = -1;
            } else if (string.equals("+")) {
                factor = 1;
            } else {
                result += factor * Integer.parseInt(string);
            }
        }
        return result;
    }

    public String[] stringTokenizerToArray(StringTokenizer stringTokenizer) {
        String[] operations = new String[stringTokenizer.countTokens()];
        int indexCounter = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String string = stringTokenizer.nextToken();
            operations[indexCounter++] = string;
        }
        return operations;
    }

    public String[] evaluateMultiplications(String[] operationsArray) {
        int multiplicationResult = 0;
        int multiplicationIndex = 0;
        for (int i = 0; i < operationsArray.length; i++) {
            if (operationsArray[i].equals("*")) {
                int operand1 = Integer.parseInt(operationsArray[i - 1]);
                int operand2 = Integer.parseInt(operationsArray[i + 1]);
                multiplicationResult = operand1 * operand2;
                multiplicationIndex = i - 1;
                break;
            }
        }

        String[] resultArray = subtractMultiplication(operationsArray, multiplicationResult, multiplicationIndex);

        if (isThereAnyMultiplication(resultArray)) {
            return evaluateMultiplications(resultArray);
        }

        return resultArray;
    }

    public String[] subtractMultiplication(
        String[] operationsArray,
        int multiplicationResult,
        int multiplicationIndex
    ) {
        String[] resultArray = new String[operationsArray.length - 2];
        int countIndex = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (i < multiplicationIndex) {
                resultArray[countIndex++] = operationsArray[i];
            } else if (i == multiplicationIndex) {
                resultArray[countIndex++] = String.valueOf(multiplicationResult);
            } else {
                resultArray[countIndex++] = operationsArray[i + 2];
            }
        }
        return resultArray;
    }

    public boolean isThereAnyMultiplication(String[] inputArray) {
        for (String s : inputArray) {
            if (s.contains("*")) {
                return true;
            }
        }
        return false;
    }

}
