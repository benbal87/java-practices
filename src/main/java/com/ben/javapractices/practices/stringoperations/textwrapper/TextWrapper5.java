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

public class TextWrapper5 {

    public static void main(String[] args) {
        String text = "I think this is the beginning of a beautiful friendship";
        int maxLineLength = 8;

        TextWrapper5 textWrapper = new TextWrapper5();
        String wrappedText = textWrapper.wrapTheText(text, maxLineLength);
        System.out.println(wrappedText);
    }

    public String wrapTheText(String inputText, int maxLineLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = inputText.split(" ");
        int lineLength = 0;

        for (String word : words) {
            if (word.length() > maxLineLength) {
                if (lineLength != 0) {
                    stringBuilder.append("\n");
                }

                int wordRemainLength = word.length();
                int start = 0;
                int stop = maxLineLength;

                while (wordRemainLength > maxLineLength) {
                    String wordPart = word.substring(start, stop);
                    start = stop;
                    stop += maxLineLength;
                    wordRemainLength -= wordPart.length();
                    stringBuilder.append(wordPart);
                    stringBuilder.append("\n");
                }
                if (wordRemainLength > 0) {
                    String wordLastPart = word.substring(start);
                    stringBuilder.append(wordLastPart);
                    lineLength = wordLastPart.length();

                    if (wordLastPart.length() + 1 < maxLineLength) {
                        stringBuilder.append(" ");
                        lineLength = wordLastPart.length() + 1;
                    }
                }
            } else if (word.length() == maxLineLength) {
                if (lineLength != 0) {
                    stringBuilder.append("\n");
                }

                stringBuilder.append(word);
                stringBuilder.append("\n");
                lineLength = 0;
            } else {
                if (lineLength + word.length() + 1 == maxLineLength) {
                    stringBuilder.append(word);
                    stringBuilder.append("\n");
                    lineLength = 0;
                } else if (lineLength + word.length() + 1 < maxLineLength) {
                    stringBuilder.append(word);
                    stringBuilder.append(" ");
                    lineLength += word.length() + 1;
                } else {
                    stringBuilder.append("\n");
                    stringBuilder.append(word);
                    stringBuilder.append(" ");
                    lineLength = word.length() + 1;
                }
            }
        }
        return stringBuilder.toString();
    }

}
