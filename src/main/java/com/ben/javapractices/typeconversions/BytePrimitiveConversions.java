package com.ben.javapractices.typeconversions;

public class BytePrimitiveConversions {

    public static void main(String[] args) {
        byte a = 8;

        // byte --> Byte
        Byte b = a;

        // byte --> short / Short
        short c = a;
        Short d = (short) a;

        // byte --> int / Integer
        int e = a;
        Integer f = (int) a;

        // byte --> long / Long
        long g = a;
        Long h = (long) a;

        // byte --> float / Float
        float i = a;
        Float j = (float) a;

        // byte --> double / Double
        double k = a;
        Double l = (double) a;

        // byte --> char / Character
        int number_system = 10;

        char m = Byte.toString(a).charAt(0);
        Character n = Byte.toString(a).charAt(0);

        char o = Character.forDigit(a, number_system);
        Character p = Character.forDigit(a, number_system);

        char q = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character r = (char) (a + 48);

        // byte --> String
        String s = Byte.toString(a);

        System.out.println("BytePrimitiveConversions");
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
