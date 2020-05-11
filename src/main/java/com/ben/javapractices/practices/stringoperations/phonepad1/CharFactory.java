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

class CharFactory {

    private String button01 = "";

    private String button02 = "ABC";

    private String button03 = "DEF";

    private String button04 = "GHI";

    private String button05 = "JKL";

    private String button06 = "MNO";

    private String button07 = "PQRS";

    private String button08 = "TUV";

    private String button09 = "WXYZ";

    String button10 = "*";

    private String button11 = " ";

    private String button12 = "#";

    private int buttonCharIndex(String button, int knockDownCount) {
        int buttonIndex = 0;

        if (button.length() >= knockDownCount) {
            buttonIndex = knockDownCount;
        }
        if (knockDownCount != 0) {
            buttonIndex = knockDownCount % button.length();
        }

        return buttonIndex;
    }

    char Char(char padNumber, int knockDownCount) {
        char resultChar = 0;

        if (padNumber == '1') {
            int index = buttonCharIndex(button01, knockDownCount);
            resultChar = button01.charAt(index);
        }
        if (padNumber == '2') {
            int index = buttonCharIndex(button02, knockDownCount);
            resultChar = button02.charAt(index);
        }
        if (padNumber == '3') {
            int index = buttonCharIndex(button03, knockDownCount);
            resultChar = button03.charAt(index);
        }
        if (padNumber == '4') {
            int index = buttonCharIndex(button04, knockDownCount);
            resultChar = button04.charAt(index);
        }
        if (padNumber == '5') {
            int index = buttonCharIndex(button05, knockDownCount);
            resultChar = button05.charAt(index);
        }
        if (padNumber == '6') {
            int index = buttonCharIndex(button06, knockDownCount);
            resultChar = button06.charAt(index);
        }
        if (padNumber == '7') {
            int index = buttonCharIndex(button07, knockDownCount);
            resultChar = button07.charAt(index);
        }
        if (padNumber == '8') {
            int index = buttonCharIndex(button08, knockDownCount);
            resultChar = button08.charAt(index);
        }
        if (padNumber == '9') {
            int index = buttonCharIndex(button09, knockDownCount);
            resultChar = button09.charAt(index);
        }
        if (padNumber == '*') {
            int index = buttonCharIndex(button11, knockDownCount);
            resultChar = button11.charAt(index);
        }
        if (padNumber == '#') {
            int index = buttonCharIndex(button12, knockDownCount);
            resultChar = button12.charAt(index);
        }
        return resultChar;
    }

}
