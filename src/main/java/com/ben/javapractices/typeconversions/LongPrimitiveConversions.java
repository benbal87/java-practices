package com.ben.javapractices.typeconversions;

public class LongPrimitiveConversions {

    public static void main(String[] args) {
        long a = 8;

        // long --> byte / Byte
        byte b = (byte) a;
        Byte c = (byte) a;

        // long --> short / Short
        short d = (short) a;
        Short e = (short) a;

        // long --> int / Integer
        int f = (int) a;
        Integer g = (int) a;

        // long --> Long
        Long h = a;

        // long --> float / Float
        float i = a;
        Float j = (float) a;

        // long --> double / Double
        double k = a;
        Double l = (double) a;

        // long --> char / Character
        char m = Long.toString(a).charAt(0);
        Character n = Long.toString(a).charAt(0);

        char o = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character p = (char) (a + 48);

        // long --> String
        String q = Long.toString(a);

        System.out.println("LongPrimitiveConversions");
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
        System.out.println("q: " + o);
        System.out.println("r: " + p);
        System.out.println("s: " + q);
    }

}
