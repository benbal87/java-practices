package com.ben.javapractices.utils.randomnumbers;

import java.util.StringJoiner;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RandomGenerator {

    private final int MIN = 0;

    private final int MAX = 9;

    public double generateRandomDouble() {
        return (Math.random() * ((MAX) - MIN)) + MIN;
    }

    public double generateRandomDouble(double min, double max) {
        return (Math.random() * ((max) - min)) + min;
    }

    public float generateRandomFloat() {
        return (float) (Math.random() * ((MAX) - MIN)) + MIN;
    }

    public float generateRandomFloat(float min, float max) {
        return (float) (Math.random() * ((max) - min)) + min;
    }

    public int generateRandomInteger() {
        return (int) (Math.random() * ((MAX + 1) - MIN)) + MIN;
    }

    public int generateRandomInteger(int min, int max) {
        return (int) (Math.random() * ((max + 1) - min)) + min;
    }

    public String generateRandomNumbers(int numberOfDigits) {
        String[] result = new String[numberOfDigits];

        int min = 0;
        int max = 9;
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(generateRandomInteger(min, max));
        }

        return String.join("", result);
    }

    public String generateRandomHungarianPhoneNumber(boolean isFormatted) {
        String delimiter = isFormatted ? " " : "";

        StringJoiner stringJoiner = new StringJoiner(delimiter);
        String INTERNATIONAL_PREFIX = "+36";
        String MOBILE_NETWORK_CODE = "55";
        stringJoiner.add(INTERNATIONAL_PREFIX);
        stringJoiner.add(MOBILE_NETWORK_CODE);

        int FIRST_SECTION_SIZE = 3;
        int SECOND_SECTION_SIZE = 4;
        stringJoiner.add(generateRandomNumbers(FIRST_SECTION_SIZE));
        stringJoiner.add(generateRandomNumbers(SECOND_SECTION_SIZE));

        return stringJoiner.toString();
    }

}
