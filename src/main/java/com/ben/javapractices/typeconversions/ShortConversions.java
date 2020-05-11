package com.ben.javapractices.typeconversions;

public class ShortConversions {

    public static void main(String[] args) {
        Short a = 8; /* Short a = new Short((short) 8); */

        // Short --> byte / Byte
        byte b = a.byteValue();
        Byte c = a.byteValue();

        // Short --> short
        short d = a;

        // Short --> int / Integer
        int e = a.intValue();
        Integer f = a.intValue();

        // Short --> long / Long
        long g = a.longValue();
        Long h = a.longValue();

        // Short --> float / Float
        float i = a.floatValue();
        Float j = a.floatValue();

        // Short --> double / Double
        double k = a.doubleValue();
        Double l = a.doubleValue();

        // Short --> char / Character
        int number_system = 10;

        char m = Short.toString(a).charAt(0);
        Character n = Short.toString(a).charAt(0);

        char o = Character.forDigit(a, number_system);
        Character p = Character.forDigit(a, number_system);

        char q = (char) (a + 48); // in ASCII table the 48th character is the zero.
        Character r = (char) (a + 48);

        // Short --> String
        String s = Short.toString(a);

        System.out.println("ShortConversions");
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
