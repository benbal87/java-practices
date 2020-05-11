package com.ben.javapractices.typeconversions;

public class DoublePrimitiveConversions {

    public static void main(String[] args) {
        double a = 8;

        // double --> byte / Byte
        byte b = (byte) a;
        Byte c = (byte) a;

        // double --> short / Short
        short d = (short) a;
        Short e = (short) a;

        // double --> int / Integer
        int f = (int) a;
        Integer g = (int) a;

        // double --> long / Long
        long h = (long) a;
        Long i = (long) a;

        // double --> float / Float
        float j = (float) a;
        Float k = (float) a;

        // double --> Double
        Double l = a;

        // double --> char / Character
        char m = Double.toString(a).charAt(0);
        Character n = Double.toString(a).charAt(0);

        char o = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character p = (char) (a + 48);

        // double --> String
        String q = Double.toString(a);

        System.out.println("DoublePrimitiveConversions");
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
