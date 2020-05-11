/*
 * Do not wrap the words just but them in one one if they fit in the given maximum line length.
 */

package com.ben.javapractices.practices.stringoperations.textwrapper;

public class TextWrapper1 {

    public static void main(String[] args) {
        String text = "I think this is the beginning of a beautiful friendship";
        int maxLineLength = 8;

        TextWrapper1 textWrapper1 = new TextWrapper1();
        System.out.println(textWrapper1.wrapTheText(text, maxLineLength));
    }

    private String wrapTheText(String text, int maxLineLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = text.split(" ");

        int lineLength = 0;
        for (String word : words) {
            if (word.length() >= maxLineLength) {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(word).append("\n");
                    lineLength = 0;
                } else if (lineLength == 0) {
                    stringBuilder.append(word).append("\n");
                    lineLength = 0;
                } else {
                    stringBuilder.append("\n").append(word).append("\n");
                    lineLength = 0;
                }
            } else if (lineLength < maxLineLength) {
                if (lineLength + word.length() + 1 <= maxLineLength) {
                    if (lineLength == 0) {
                        stringBuilder.append(word);
                        lineLength += word.length();
                    } else {
                        stringBuilder.append(" ").append(word);
                        lineLength += word.length() + 1;

                        if (lineLength == maxLineLength) {
                            lineLength = 0;
                            stringBuilder.append("\n");
                        }
                    }
                } else {
                    stringBuilder.append("\n").append(word);
                    lineLength = word.length();
                }
            }
        }
        return stringBuilder.toString();
    }

}
