package com.ben.javapractices.typeconversions;

public class StringConversions {

    public static void main(String[] args) {
        String a = "8";

        // String --> byte / Byte
        byte b = Byte.valueOf(a);
        Byte c = Byte.valueOf(a);

        byte d = Byte.parseByte(a);
        Byte e = Byte.parseByte(a);

        // String --> short / Short
        short f = Short.valueOf(a);
        Short g = Short.valueOf(a);

        short h = Short.parseShort(a);
        Short i = Short.parseShort(a);

        // String --> int / Integer
        int j = Integer.valueOf(a);
        Integer k = Integer.valueOf(a);

        int l = Integer.parseInt(a);
        Integer m = Integer.parseInt(a);

        // String --> long / Long
        long n = Long.valueOf(a);
        Long o = Long.valueOf(a);

        long p = Long.parseLong(a);
        Long q = Long.parseLong(a);

        // String --> float / Float
        float r = Float.valueOf(a);
        Float s = Float.valueOf(a);

        float t = Float.parseFloat(a);
        Float u = Float.parseFloat(a);

        // String --> double / Double
        double v = Double.valueOf(a);
        Double w = Double.valueOf(a);

        double x = Double.parseDouble(a);
        Double y = Double.parseDouble(a);

        // String --> char / Character
        char z = Character.valueOf(a.charAt(0));
        Character z1 = Character.valueOf(a.charAt(0));

        System.out.println("StringConversions");
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
