/*
 * Your goal is to make a string wrapped when there is no more space in a line to write the rest of the
 * string. Write a function which takes a string as a parameter and an integer which represents the
 * maximum length of each lines.
 * Rules are the following:
 * - wrapping is only allowed where it is neccessary
 * - first character of a line can not be a space
 * - a word can only be splitted if it is longer than maximum length and this time it should be started
 * in a new line
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

public class TextWrapper4 {

    public static void main(String[] args) {
        String text = "I think this is the beginning of a beautiful friendship";
        int maxLineLength = 5;

        TextWrapper4 textWrapper = new TextWrapper4();
        String wrappedText = textWrapper.wrapTheText(text, maxLineLength);
        System.out.println(wrappedText);
    }

    public String wrapTheText(String inputText, int maxLineLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = inputText.split(" ");

        int charsInRow = 0;
        for (String word : words) {
            if (charsInRow + word.length() > maxLineLength && stringBuilder.length() != 0 && charsInRow != 0) {
                stringBuilder.append("\n");
                charsInRow = 0;
            }

            for (int i = 0; i < word.length() / maxLineLength; i++) {
                stringBuilder.append(word.substring(i * maxLineLength, (i + 1) * maxLineLength));
                stringBuilder.append('\n');
                charsInRow = 0;
            }

            word = word.substring(word.length() - (word.length() % maxLineLength));
            stringBuilder.append(word);
            charsInRow += word.length();

            if (charsInRow + 1 <= maxLineLength && charsInRow > 0) {
                stringBuilder.append(" ");
                charsInRow++;
            }
        }
        return stringBuilder.toString();
    }

}
