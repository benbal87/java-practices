package com.ben.javapractices.typeconversions;

public class FloatPrimitiveConversions {

    public static void main(String[] args) {
        float a = 8;

        // float --> byte / Byte
        byte b = (byte) a;
        Byte c = (byte) a;

        // float --> short / Short
        short d = (short) a;
        Short e = (short) a;

        // float --> int / Integer
        int f = (int) a;
        Integer g = (int) a;

        // float --> long / Long
        long h = (long) a;
        Long i = (long) a;

        // float --> Float
        Float j = a;

        // float --> double / Double
        double k = a;
        Double l = (double) a;

        // float --> char / Character
        char m = Float.toString(a).charAt(0);
        Character n = Float.toString(a).charAt(0);

        char o = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character p = (char) (a + 48);

        // float --> String
        String q = Float.toString(a);

        System.out.println("FloatPrimitiveConversions");
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
