package com.ben.javapractices.practices.stringoperations.seek13;

public class Seek13_2 {

    public static void main(String[] args) {
        Seek13_2 seek13 = new Seek13_2();
        System.out.println(seek13.seek13(1234)); // true
        System.out.println(seek13.seek13(3214)); // false
        System.out.println(seek13.seek13(313)); // true
        System.out.println(seek13.seek13(31)); // false
        System.out.println(seek13.seek13(13)); // true
        System.out.println(seek13.seek13(4536)); // false
        System.out.println(seek13.seek13(4516)); // false

    }

    public boolean seek13(int number) {
        String numberString = Integer.toString(number);
        int one = numberString.indexOf('1');
        return one > -1 && numberString.indexOf('3', one) > one;
    }

}
