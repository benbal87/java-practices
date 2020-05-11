package com.ben.javapractices.practices.arrayoperations.brailletranslator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://py.checkio.org/mission/braille-translator/
 *
 * Braille is a tactile writing system used by the blind and the visually impaired. It is traditionally written with
 * embossed paper. Braille characters are small rectangular blocks, called cells, which contain tiny palpable bumps
 * called raised dots. The number and arrangement of these dots distinguish one character from another.
 *
 * We will use a 6-dots Braille alphabet. Each letter can be represented as a 3x2 matrix where 1 is a raised dot and 0
 * is an empty space.
 *
 * Letters should be separated by an empty column. Whitespaces are two empty columns (plus a separator empty column if
 * it is between letters). Various formatting marks indicate the values of the letters that follow them. They have no
 * direct equivalent in print. The most important indicators in English Braille are: "capital" and "number". These marks
 * work as "shift" - only for a follow letter.
 *
 * You are given a page of text and you should convert it into Braille. The page contains one or several lines
 * represented as a matrix. Each line contains no more than 10 symbols (including non-printed). Lines are separated by
 * one empty row. Symbols are separated by empty columns but there are no separators in beginnings and ends of lines. If
 * text can be placed in one line, then the page width is proportional to the length of the text. If the page has more
 * than one line, then the width is equal to the longer line and the final line is appended by whitespaces.
 */

public class BrailleTranslator1 {

    private static final Map<String, Integer[][]> BRAILLE_MAP = new HashMap<>();

    static {
        BRAILLE_MAP.put("a", new Integer[][] { { 1, 0 }, { 0, 0 }, { 0, 0 } });
        BRAILLE_MAP.put("b", new Integer[][] { { 1, 0 }, { 1, 0 }, { 0, 0 } });
        BRAILLE_MAP.put("c", new Integer[][] { { 1, 1 }, { 0, 0 }, { 0, 0 } });
        BRAILLE_MAP.put("d", new Integer[][] { { 1, 1 }, { 0, 1 }, { 0, 0 } });
        BRAILLE_MAP.put("e", new Integer[][] { { 1, 0 }, { 0, 1 }, { 0, 0 } });
        BRAILLE_MAP.put("f", new Integer[][] { { 1, 1 }, { 1, 0 }, { 0, 0 } });
        BRAILLE_MAP.put("g", new Integer[][] { { 1, 1 }, { 1, 1 }, { 0, 0 } });
        BRAILLE_MAP.put("h", new Integer[][] { { 1, 0 }, { 1, 1 }, { 0, 0 } });
        BRAILLE_MAP.put("i", new Integer[][] { { 0, 1 }, { 1, 0 }, { 0, 0 } });
        BRAILLE_MAP.put("j", new Integer[][] { { 0, 1 }, { 1, 1 }, { 0, 0 } });
        BRAILLE_MAP.put("k", new Integer[][] { { 1, 0 }, { 0, 0 }, { 1, 0 } });
        BRAILLE_MAP.put("l", new Integer[][] { { 1, 0 }, { 1, 0 }, { 1, 0 } });
        BRAILLE_MAP.put("m", new Integer[][] { { 1, 1 }, { 0, 0 }, { 1, 0 } });
        BRAILLE_MAP.put("n", new Integer[][] { { 1, 1 }, { 0, 1 }, { 1, 0 } });
        BRAILLE_MAP.put("o", new Integer[][] { { 1, 0 }, { 0, 1 }, { 1, 0 } });
        BRAILLE_MAP.put("p", new Integer[][] { { 1, 1 }, { 1, 0 }, { 1, 0 } });
        BRAILLE_MAP.put("q", new Integer[][] { { 1, 1 }, { 1, 1 }, { 1, 0 } });
        BRAILLE_MAP.put("r", new Integer[][] { { 1, 0 }, { 1, 1 }, { 1, 0 } });
        BRAILLE_MAP.put("s", new Integer[][] { { 0, 1 }, { 1, 0 }, { 1, 0 } });
        BRAILLE_MAP.put("t", new Integer[][] { { 0, 1 }, { 1, 1 }, { 1, 0 } });
        BRAILLE_MAP.put("u", new Integer[][] { { 1, 0 }, { 0, 0 }, { 1, 1 } });
        BRAILLE_MAP.put("v", new Integer[][] { { 1, 0 }, { 1, 0 }, { 1, 1 } });
        BRAILLE_MAP.put("x", new Integer[][] { { 1, 1 }, { 0, 0 }, { 1, 1 } });
        BRAILLE_MAP.put("y", new Integer[][] { { 1, 1 }, { 0, 1 }, { 1, 1 } });
        BRAILLE_MAP.put("z", new Integer[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } });
        BRAILLE_MAP.put("w", new Integer[][] { { 0, 1 }, { 1, 1 }, { 1, 1 } });
        BRAILLE_MAP.put(",", new Integer[][] { { 0, 0 }, { 1, 0 }, { 0, 0 } });
        BRAILLE_MAP.put(".", new Integer[][] { { 0, 0 }, { 1, 1 }, { 0, 1 } });
        BRAILLE_MAP.put("-", new Integer[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } });
        BRAILLE_MAP.put("?", new Integer[][] { { 0, 0 }, { 1, 0 }, { 1, 1 } });
        BRAILLE_MAP.put("_", new Integer[][] { { 0, 0 }, { 0, 0 }, { 1, 1 } });
        BRAILLE_MAP.put("!", new Integer[][] { { 0, 0 }, { 1, 1 }, { 1, 0 } });
        BRAILLE_MAP.put("capital", new Integer[][] { { 0, 0 }, { 0, 0 }, { 0, 1 } });
        BRAILLE_MAP.put("number", new Integer[][] { { 0, 1 }, { 0, 1 }, { 1, 1 } });
    }

    private final int MAX_LINE_LENGTH = 29;

    Integer[][] brailleArray;

    private String stringToTranslate;

    public static void main(String[] args) {
        BrailleTranslator1 brailleTranslator = new BrailleTranslator1();
        brailleTranslator.tanslate("hello 1st World!");

        for (Integer[] row : brailleTranslator.brailleArray) {
            System.out.println(Arrays.toString(row));
        }
    }

    void tanslate(String inputString) {
        stringToTranslate = inputString;
        brailleArray = new Integer[calculateRowNumber()][MAX_LINE_LENGTH];

        for (int i = 0; i < brailleArray.length; i++) {
            for (int j = 0; j < brailleArray[i].length; j++) {
                brailleArray[i][j] = 0;
            }
        }

        int insertionIndexI = 0;
        int insertionIndexJ = 0;

        for (int i = 0; i < stringToTranslate.length(); i++) {
            char actualChar = stringToTranslate.charAt(i);
            String actualString = Character.toString(stringToTranslate.charAt(i));
            String actualStringLowerCase = Character.toString((Character.toLowerCase(stringToTranslate.charAt(i))));

            if (BRAILLE_MAP.containsKey(actualString) || BRAILLE_MAP.containsKey(actualStringLowerCase)
                || Character.isDigit(actualChar)) {
                if (insertionIndexJ < MAX_LINE_LENGTH) {
                    if (Character.isUpperCase(actualChar) && insertionIndexJ + 4 < MAX_LINE_LENGTH) {
                        insertSymbolToArray(BRAILLE_MAP.get("capital"), insertionIndexI, insertionIndexJ);
                        insertionIndexJ += 3;
                        insertSymbolToArray(BRAILLE_MAP.get(actualStringLowerCase), insertionIndexI, insertionIndexJ);
                        insertionIndexJ += 3;
                    } else if (Character.isDigit(actualChar) && insertionIndexJ + 4 < MAX_LINE_LENGTH) {
                        insertSymbolToArray(BRAILLE_MAP.get("number"), insertionIndexI, insertionIndexJ);
                        insertionIndexJ += 3;
                        insertSymbolToArray(BRAILLE_MAP.get(digitCharToString(actualChar)), insertionIndexI,
                            insertionIndexJ
                        );
                        insertionIndexJ += 3;
                    } else if (insertionIndexJ + 1 < MAX_LINE_LENGTH) {
                        insertSymbolToArray(BRAILLE_MAP.get(actualString), insertionIndexI, insertionIndexJ);
                        insertionIndexJ += 3;
                    }
                } else {
                    insertionIndexI += 4;
                    insertionIndexJ = 0;
                    i--;
                }
            } else {
                if (insertionIndexJ < MAX_LINE_LENGTH && insertionIndexJ + 1 < MAX_LINE_LENGTH) {
                    insertionIndexJ += 3;
                } else {
                    insertionIndexI += 4;
                    insertionIndexJ = 0;
                    i--;
                }
            }
        }
    }

    private String digitCharToString(char actualChar) {
        return actualChar == '0' ? "j" : Character.toString((char) (actualChar + 48));
    }

    private void insertSymbolToArray(Integer[][] arrayToInsert, int insertionIndexI, int insertionIndexJ) {
        int indexJ = insertionIndexJ;
        for (Integer[] integers : arrayToInsert) {
            for (Integer integer : integers) {
                brailleArray[insertionIndexI][insertionIndexJ] = integer;
                insertionIndexJ++;
            }
            insertionIndexI++;
            insertionIndexJ = indexJ;
        }
    }

    private int calculateRowNumber() {
        int letterHeightPlusLineSpace = 4;
        int rowCounter = 3;
        int columnCounter = 0;

        for (int i = 0; i < stringToTranslate.length(); i++) {
            char actualChar = stringToTranslate.charAt(i);
            if (columnCounter == 0) {
                columnCounter += 2;
                if (Character.isTitleCase(actualChar) || Character.isDigit(actualChar)) {
                    columnCounter += 3;
                }
            } else if (columnCounter > 0) {
                if ((Character.isTitleCase(actualChar) || Character.isDigit(actualChar))
                    && columnCounter + 6 <= MAX_LINE_LENGTH - 1) {
                    columnCounter += 6;
                } else if (!Character.isTitleCase(actualChar) && !Character.isDigit(actualChar)
                           && columnCounter + 3 <= MAX_LINE_LENGTH - 1) {
                    columnCounter += 3;
                } else {
                    columnCounter = 0;
                    rowCounter += letterHeightPlusLineSpace;
                }
            }
        }
        return rowCounter;
    }

}
