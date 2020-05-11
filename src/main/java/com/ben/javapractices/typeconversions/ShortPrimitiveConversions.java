package com.ben.javapractices.typeconversions;

public class ShortPrimitiveConversions {

    public static void main(String[] args) {
        short a = 8;

        // short --> byte / Byte
        byte b = (byte) a;
        Byte c = (byte) a;

        // short --> Short
        Short d = a;

        // short --> int / Integer
        int e = a;
        Integer f = (int) a;

        // short --> long / Long
        long g = a;
        Long h = (long) a;

        // short --> float / Float
        float i = a;
        Float j = (float) a;

        // short --> double / Double
        double k = a;
        Double l = (double) a;

        // short --> char / Character
        int number_system = 10;

        char m = Short.toString(a).charAt(0);
        Character n = Short.toString(a).charAt(0);

        char o = Character.forDigit(a, number_system);
        Character p = Character.forDigit(a, number_system);

        char q = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character r = (char) (a + 48);

        // short --> String
        String s = Short.toString(a);

        System.out.println("ShortPrimitiveConversions");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("e: " + e);
        System.out.println("f: " + f);
        System.out.println("g: " + g);
        System.out.println("h: " + h);
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("k: " + k);
        System.out.println("l: " + l);
        System.out.println("m: " + m);
        System.out.println("n: " + n);
        System.out.println("o: " + o);
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("r: " + r);
        System.out.println("s: " + s);
    }

}
