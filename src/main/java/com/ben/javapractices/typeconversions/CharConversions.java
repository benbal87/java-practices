package com.ben.javapractices.typeconversions;

public class CharConversions {

    public static void main(String[] args) {
        char a = '8';

        // char --> byte / Byte
        byte b = (byte) (a - 48);
        Byte c = (byte) (a - 48);

        byte d = (byte) Character.getNumericValue(a);
        Byte e = (byte) Character.getNumericValue(a);

        // char --> short / Short
        short f = (short) (a - 48);
        Short g = (short) (a - 48);

        short h = (short) Character.getNumericValue(a);
        Short i = (short) Character.getNumericValue(a);

        // char --> int / Integer
        int j = a - 48;
        Integer k = a - 48;

        int l = Character.getNumericValue(a);
        Integer m = (int) Character.getNumericValue(a);

        // char --> long / Long
        long n = a - 48;
        Long o = (long) a - 48;

        long p = Character.getNumericValue(a);
        Long q = (long) Character.getNumericValue(a);

        // char --> float / Float
        float r = a - 48;
        Float s = (float) (a - 48);

        float t = Character.getNumericValue(a);
        Float u = (float) Character.getNumericValue(a);

        // char --> double / Double
        double v = a - 48;
        Double w = (double) (a - 48);

        double x = Character.getNumericValue(a);
        Double y = (double) Character.getNumericValue(a);

        // char --> Character
        Character z = a;

        // char --> String
        String z1 = Character.toString(a);

        System.out.println("CharConversions");
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
        System.out.println("u: " + u);
        System.out.println("v: " + v);
        System.out.println("w: " + w);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("z1: " + z1);
    }

}
