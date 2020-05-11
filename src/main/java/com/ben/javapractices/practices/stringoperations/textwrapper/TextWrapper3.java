/*
 * Your goal is to make a string wrapped when there is no more space in a line to write the rest of the string.
 * Write a function which takes a string as a parameter and an integer which represents the maximum length of each
 * lines.
 * Rules are the following:
 * - wrapping is only allowed where it is neccessary
 * - first character of a line can not be a space
 * - a word can only be splitted if it is longer than maximum length and this time it should be started in a new line
 * E.g.
 * Input: "I think this is the beginning of a beautiful friendship", max_length = 8
 * Output:
 * I think
 * this is
 * the
 * beginnin
 * g of a
 * beautifu
 * l
 * friendsh
 * ip
 */

package com.ben.javapractices.practices.stringoperations.textwrapper;

public class TextWrapper3 {

    public static void main(String[] args) {
        String text =
            "Beautiful I think this is the beginning friendship of a beautiful friendship.";
        int maxLineLength = 5;

        TextWrapper3 textWrapper = new TextWrapper3();
        System.out.println(textWrapper.wrapTheText(text, maxLineLength));
    }

    public String wrapTheText(String text, int maxLineLength) {
        String[] words = text.split(" ");
        StringBuilder stringBuilder1 = new StringBuilder();
        int chars_left = maxLineLength;

        for (String word : words) {
            if (word.length() >= chars_left && !stringBuilder1.equals("")) {
                stringBuilder1.append("\n");
                chars_left = maxLineLength;
            } else if (word.length() >= chars_left) {
                chars_left = maxLineLength;
            }

            while (word.length() > maxLineLength) {
                for (int i = 0; i < maxLineLength; i++) {
                    stringBuilder1.append(word.charAt(i));
                }

                stringBuilder1.append("\n");
                StringBuilder stringBuilder2 = new StringBuilder();

                for (int i = maxLineLength; i < word.length(); i++) {
                    stringBuilder2.append(word.charAt(i));
                }

                word = stringBuilder2.toString();
            }

            stringBuilder1.append(word);
            chars_left -= word.length();

            if (chars_left > 1) {
                stringBuilder1.append(" ");
                chars_left -= 1;
            }
        }

        String result = stringBuilder1.toString();
        return result;
    }

}
