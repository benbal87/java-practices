package com.ben.javapractices.practices.stringoperations.shufflewordsinteriors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleWordsInteriors3 {

    public static void main(String[] args) {
        String inputText =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the "
            + "industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and"
            + " scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap"
            + " into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with "
            + "the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop "
            + "publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        ShuffleWordsInteriors3 shuffleWordsInteriorsV4 = new ShuffleWordsInteriors3();
        String resultText = shuffleWordsInteriorsV4.shuffleWordsInText(inputText);

        System.out.println(resultText);
    }

    public String shuffleWordsInText(String inputText) {
        char[] inputTextCharArray = inputText.toCharArray();
        int wordLetterCount = 0;

        for (int i = 0; i < inputTextCharArray.length; i++) {
            char actualCharacter = inputTextCharArray[i];

            if (Character.isAlphabetic(actualCharacter)) {
                wordLetterCount++;
            } else if (!Character.isAlphabetic(actualCharacter) && wordLetterCount > 3) {
                int indexStart = i - wordLetterCount + 1;
                int indexEnd = i - 2;
                List<Character> shuffledList = shuffleWordInterior(inputTextCharArray, indexStart, indexEnd);
                replaceShuffledCharsBackToArray(shuffledList, inputTextCharArray, indexStart, indexEnd);
                wordLetterCount = 0;
            } else {
                wordLetterCount = 0;
            }
        }

        String result = String.valueOf(inputTextCharArray);
        return result;
    }

    public List<Character> shuffleWordInterior(char[] inputTextCharArray, int indexStart, int indexEnd) {
        List<Character> originalListToShuffle = new ArrayList<>();
        List<Character> shuffledList = new ArrayList<>();

        for (int j = indexStart; j <= indexEnd; j++) {
            shuffledList.add(inputTextCharArray[j]);
            originalListToShuffle.add(inputTextCharArray[j]);
        }

        while (shuffledList.equals(originalListToShuffle)) {
            Collections.shuffle(shuffledList);
        }

        return shuffledList;
    }

    public void replaceShuffledCharsBackToArray(
        List<Character> fromList,
        char[] toArray,
        int indexStart,
        int indexEnd
    ) {
        int count = 0;
        for (int m = indexStart; m <= indexEnd; m++) {
            for (int n = count; n <= count; n++) {
                toArray[m] = fromList.get(n);
            }
            count++;
        }
    }

}
