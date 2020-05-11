package com.ben.javapractices.typeconversions;

public class FloatConversions {

    public static void main(String[] args) {
        Float a = (float) 8; /* Float a = new Float((float) 8); */

        // Float --> byte / Byte
        byte b = a.byteValue();
        Byte c = a.byteValue();

        // Float --> short / Short
        short d = a.shortValue();
        Short e = a.shortValue();

        // Float --> int / Integer
        int f = a.intValue();
        Integer g = a.intValue();

        // Float --> long / Long
        long h = a.longValue();
        Long i = a.longValue();

        // Float --> float
        Float j = a;

        // Float --> double / Double
        double k = a.doubleValue();
        Double l = a.doubleValue();

        // float --> char / Character
        char m = Float.toString(a).charAt(0);
        Character n = Float.toString(a).charAt(0);

        char o = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character p = (char) (a + 48);

        // Float --> String
        String q = Float.toString(a);

        System.out.println("FloatConversions");
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
