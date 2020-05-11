package com.ben.javapractices.typeconversions;

public class BooleanConversions {

    public static void main(String[] args) {
        Boolean a = true;

        // Boolean --> boolean
        boolean b = a;

        // Boolean --> String
        String c = Boolean.toString(a);

        System.out.println("BooleanConversions");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }

}
