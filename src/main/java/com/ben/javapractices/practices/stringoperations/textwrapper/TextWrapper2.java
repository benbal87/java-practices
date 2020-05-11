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

public class TextWrapper2 {

    public static void main(String[] args) {
        String inputText =
            "Beautiful I think this is the beginning friendship of a beautiful friendship.";
        TextWrapper2 textWrapper = new TextWrapper2();
        String wrappedText = textWrapper.wrapTheText(inputText, 5);
        System.out.println(wrappedText);
    }

    public String wrapTheText(String inputText, int maxLineLength) {
        String result = "";
        String[] inputTextArray = inputText.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        int lineLength = 0;

        for (int i = 0; i < inputTextArray.length; i++) {
            String actualWord = inputTextArray[i];
            int actualWordLength = actualWord.length();

            if ((lineLength + actualWordLength + 1) <= maxLineLength) {
                stringBuilder
                    .append(actualWord)
                    .append(" ");
                lineLength += actualWordLength + 1;
            } else if ((lineLength + actualWordLength) <= maxLineLength) {
                stringBuilder.append(actualWord);
                lineLength += actualWordLength;
            } else if ((lineLength + actualWordLength) > maxLineLength
                       && actualWordLength <= maxLineLength
                       && actualWordLength <= maxLineLength + 1) {
                stringBuilder
                    .append("\n")
                    .append(actualWord)
                    .append(" ");
                lineLength = actualWordLength + 1;
            } else if ((lineLength + actualWordLength) > maxLineLength
                       && actualWordLength <= maxLineLength
                       && actualWordLength <= maxLineLength) {
                stringBuilder
                    .append("\n")
                    .append(actualWord);
                lineLength = actualWordLength;
            } else if (actualWordLength > maxLineLength
                       && (actualWordLength < maxLineLength * 2 || actualWordLength <= maxLineLength * 2)) {
                if (!stringBuilder.toString().equals("")) {
                    stringBuilder.append("\n");
                }

                String wordFirstPart = actualWord.substring(0, maxLineLength);
                stringBuilder
                    .append(wordFirstPart)
                    .append("\n");
                String wordSecondPart = actualWord.substring(maxLineLength, actualWordLength);

                if (actualWordLength < maxLineLength * 2) {
                    stringBuilder
                        .append(wordSecondPart)
                        .append(" ");
                    lineLength = wordSecondPart.length() + 1;
                } else if (actualWordLength == maxLineLength * 2) {
                    stringBuilder
                        .append(wordSecondPart)
                        .append("\n");
                    lineLength = 0;
                }
            } else if (actualWordLength > maxLineLength * 2) {
                if (!stringBuilder.toString().equals("")) {
                    stringBuilder.append("\n");
                }
                if (stringBuilder.charAt(stringBuilder.length() - 1) == '\n') {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                char[] wordLetters = actualWord.toCharArray();

                int count = 0;
                for (char wordLetter : wordLetters) {
                    if (count < maxLineLength) {
                        stringBuilder.append(wordLetter);
                        count++;
                    } else {
                        stringBuilder
                            .append("\n")
                            .append(wordLetter);
                        count = 1;
                    }
                }
            }
        }

        result = stringBuilder.toString();
        return result;
    }

}
