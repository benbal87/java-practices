package com.ben.javapractices.typeconversions;

public class ByteConversions {

    public static void main(String[] args) {
        Byte a = 8; /* Byte a = new Byte((byte) 8); */

        // Byte --> byte
        byte b = a;

        // Byte --> short / Short
        short c = a.shortValue();
        Short d = a.shortValue();

        // Byte --> int / Integer
        int e = a.intValue();
        Integer f = a.intValue();

        // Byte --> long / Long
        long g = a.longValue();
        Long h = a.longValue();

        // Byte --> float / Float
        float i = a.floatValue();
        Float j = a.floatValue();

        // Byte --> double / Double
        double k = a.doubleValue();
        Double l = a.doubleValue();

        // Byte --> char / Character
        int number_system = 10;

        char m = Byte.toString(a).charAt(0);
        Character n = Byte.toString(a).charAt(0);

        char o = Character.forDigit(a, number_system);
        Character p = Character.forDigit(a, number_system);

        char q = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character r = (char) (a + 48);

        // Byte --> String
        String s = Byte.toString(a);

        System.out.println("ByteConversions");
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
