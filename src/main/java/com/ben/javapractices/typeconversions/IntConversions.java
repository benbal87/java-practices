package com.ben.javapractices.typeconversions;

public class IntConversions {

    public static void main(String[] args) {
        int a = 8;

        // int --> byte / Byte
        byte b = (byte) a;
        Byte c = (byte) b;

        // int --> short / Short
        short d = (short) a;
        Short e = (short) a;

        // int --> Integer
        Integer f = a; /* Integer a = new Integer(a); */

        // int --> long / Long
        long g = a;
        Long h = (long) a;

        // int --> float / Float
        float i = a;
        Float j = (float) a;

        // int --> double / Double
        double k = a;
        Double l = (double) a;

        // int --> char / Character (only for one digit)
        int number_system = 10;

        char m = Integer.toString(a).charAt(0);
        Character n = Integer.toString(a).charAt(0);

        char o = Character.forDigit(a, number_system);
        Character p = Character.forDigit(a, number_system);

        char q = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character r = (char) (a + 48);

        // int --> String
        String s = Integer.toString(a);
        String t = String.valueOf(a);

        System.out.println("IntConversions");
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
        System.out.println("t: " + t);
    }

}
