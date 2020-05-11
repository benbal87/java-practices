package com.ben.javapractices.typeconversions;

public class IntegerConversions {

    public static void main(String[] args) {
        Integer a = 8; /* Integer a = new Integer(8) */

        // Integer --> byte / Byte
        byte b = a.byteValue();
        Byte c = a.byteValue();

        // Integer --> short / Short
        short d = a.shortValue();
        Short e = a.shortValue();

        // Integer --> int
        int f = a; /* int b = Integer.valueOf(a) */

        // Integer --> long / Long
        long g = a.longValue();
        Long h = a.longValue();

        // Integer --> float / Float
        float i = a.floatValue();
        Float j = a.floatValue();

        // Integer --> double / Double
        double k = a.doubleValue();
        Double l = a.doubleValue();

        // Integer --> char / Character (only for one digit)
        int number_system = 10;

        char m = Integer.toString(a).charAt(0);
        Character n = Integer.toString(a).charAt(0);

        char o = Character.forDigit(a, number_system);
        Character p = Character.forDigit(a, number_system);

        char q = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character r = (char) (a + 48);

        // Integer --> String
        String s = Integer.toString(a);
        String t = String.valueOf(a);

        System.out.println("IntegerConversions");
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
