package com.ben.javapractices.typeconversions;

public class BooleanPrimitiveConversions {

    public static void main(String[] args) {
        boolean a = true;

        // boolean --> Boolean
        Boolean b = a;

        // boolean --> String
        String c = Boolean.toString(a);

        System.out.println("BooleanPrimitiveConversions");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }

}
