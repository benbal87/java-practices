package com.ben.javapractices.typeconversions;

public class DoubleConversions {

    public static void main(String[] args) {
        Double a = (double) 8; /* Double a = new Double(8); */

        // Double --> byte / Byte
        byte b = a.byteValue();
        Byte c = a.byteValue();

        // Double --> short / Short
        short d = a.shortValue();
        Short e = a.shortValue();

        // Double --> int / Integer
        int f = a.intValue();
        Integer g = a.intValue();

        // Double --> long / Long
        long h = a.longValue();
        Long i = a.longValue();

        // Double --> float / Float
        float j = a.floatValue();
        Float k = a.floatValue();

        // Double --> double
        double l = a;

        // Double --> char / Character
        char m = Double.toString(a).charAt(0);
        Character n = Double.toString(a).charAt(0);

        char o = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character p = (char) (a + 48);

        // Double --> String
        String q = Double.toString(a);

        System.out.println("DoubleConversions");
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
