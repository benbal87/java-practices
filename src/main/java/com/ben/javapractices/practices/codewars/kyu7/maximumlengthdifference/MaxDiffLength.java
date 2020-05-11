package com.ben.javapractices.practices.codewars.kyu7.maximumlengthdifference;

public class MaxDiffLength {

    public static int mxdiflg(String[] a1, String[] a2) {
        int result = -1;

        if (a1 == null || a1.length == 0 || a2 == null || a2.length == 0) {
            return result;
        }

        for (String a : a1) {
            for (String b : a2) {
                int lengthDiff = a.length() - b.length();
                int lengthDiffAbs = Math.abs(lengthDiff);

                if (result < lengthDiffAbs) {
                    result = lengthDiffAbs;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s1 = new String[] {
            "hoqq",
            "bbllkw",
            "oox",
            "ejjuyyy",
            "plmiis",
            "xxxzgpsssa",
            "xxwwkktt",
            "znnnnfqknaz",
            "qqquuhii",
            "dvvvwz"
        };
        String[] s2 = new String[] { "cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww" };

        int result = mxdiflg(s1, s2);

        System.out.println(result);
    }

}
