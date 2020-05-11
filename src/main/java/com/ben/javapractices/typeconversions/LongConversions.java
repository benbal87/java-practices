package com.ben.javapractices.typeconversions;

public class LongConversions {

    public static void main(String[] args) {

        Long a = (long) 8; /* Long a = new Long((long) 8); */

        // Long --> byte / Byte
        byte b = a.byteValue();
        Byte c = a.byteValue();

        // Long --> short / Short
        short d = a.shortValue();
        Short e = a.shortValue();

        // Long --> int / Integer
        int f = a.intValue();
        Integer g = a.intValue();

        // Long --> long
        long h = a.longValue();

        // Long --> float / Float
        float i = a.floatValue();
        Float j = a.floatValue();

        // Long --> double / Double
        double k = a.doubleValue();
        Double l = a.doubleValue();

        // Long --> char / Character
        char m = Long.toString(a).charAt(0);
        Character n = Long.toString(a).charAt(0);

        char o = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character p = (char) (a + 48);

        // Long --> String
        String q = Long.toString(a);

        System.out.println("LongConversions");
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
    }

}
