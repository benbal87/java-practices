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

class MessageConverter {

    void converter(String keyStrings) {
        CharFactory charFactory = new CharFactory();
        StringBuilder textResult = new StringBuilder();
        int knockDownCount = 0;
        char actualChar;
        char letter;

        if (keyStrings.length() > 1) {
            for (int i = 0; i < keyStrings.length(); i++) {
                actualChar = keyStrings.charAt(i);
                // char nextChar = keyStrings.charAt(i + 1);
                char nextChar = 0;

                if (actualChar == '1') {
                    continue;
                }
                if (keyStrings.length() > i + 1) {
                    nextChar = keyStrings.charAt(i + 1);
                }
                if (nextChar == actualChar) {
                    knockDownCount += 1;
                } else {
                    letter = charFactory.Char(actualChar, knockDownCount);
                    textResult.append(letter);
                    knockDownCount = 0;
                }
            }
        } else {
            knockDownCount = 0;
            actualChar = keyStrings.charAt(0);
            letter = charFactory.Char(actualChar, knockDownCount);
            textResult.append(letter);
        }
        System.out.println(textResult);
    }

}
