package com.ben.javapractices.practices.stringoperations.seek13;

public class Seek13 {

    public static void main(String[] args) {
        int number1 = 451678932;
        int number2 = 45678932;
        int number3 = 456789321;
        Seek13 seek13 = new Seek13();
        boolean result1 = seek13.seek13(number1);
        boolean result2 = seek13.seek13(number2);
        boolean result3 = seek13.seek13(number3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    private boolean seek13(int number) {
        String numberString = Integer.toString(number);

        char seekFirst = '1';
        int count = 0;

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == seekFirst) {
                count++;
                seekFirst = '3';

                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }

}
