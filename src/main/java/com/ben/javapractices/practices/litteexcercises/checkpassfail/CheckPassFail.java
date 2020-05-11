// Write a program called CheckPassFail
// which prints "PASS" if the int variable
// "mark" is more than or equal to 50; or
// prints "FAIL" otherwise. The variable is
// a member variable and initialized with a
// member method. SetMark is the name of it.
// The printer method name is PrintResult.

package com.ben.javapractices.practices.litteexcercises.checkpassfail;

import java.util.Scanner;

class CheckPassFail {

    private static int n;

    private static String s;

    public static void main(String arg[]) {

        System.out.println("Marks: ");

        Scanner w = new Scanner(System.in);

        s = w.nextLine();
        w.close();
        n = Integer.parseInt(s);

        if (n >= 50) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

}
