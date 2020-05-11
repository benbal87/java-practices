/*
 * ------- ------- -------
 * |     | | ABC | | DEF |
 * |  1  | |  2  | |  3  |
 * ------- ------- -------
 * ------- ------- -------
 * | GHI | | JKL | | MNO |
 * |  4  | |  5  | |  6  |
 * ------- ------- -------
 * ------- ------- -------
 * |PQRS | | TUV | | WXYZ|
 * |  7  | |  8  | |  9  |
 * ------- ------- -------
 * ------- ------- -------
 * |     | |space| |     |
 * |  *  | |  0  | |  #  |
 * ------- ------- -------
 */

package com.ben.javapractices.practices.stringoperations.phonepad1;

public class Main {

    public static void main(String[] args) {
        String keyString1 = "22222266631332226661666555";
        String keyString2 = "3";
        String keyString3 = "99966688088777733130866602221255515550633066616606999022233555155574466616633";
        String keyString4 = "5555666444444660866608443303277755077774443133";
        String keyString5 = "02212222224567";

        MessageConverter messageConverter = new MessageConverter();

        messageConverter.converter(keyString1); // "CODECOOL"
        messageConverter.converter(keyString2); // "D"
        messageConverter.converter(keyString3); // "YOU USED TO CALL ME ON CELLPHONE"
        messageConverter.converter(keyString4); // "JOIN TO THE DARK SIDE"
        messageConverter.converter(keyString5); // " BCGJMP"
    }

}
