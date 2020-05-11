package com.ben.javapractices.practices.stringoperations.shufflewordsinteriors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleWordsInteriors1 {

    public static void main(String[] args) {
        String inputText = "This is a test string for todays morning dojo";
        ShuffleWordsInteriors1 shuffleWordsInteriors1 = new ShuffleWordsInteriors1();
        String resultText = shuffleWordsInteriors1.shuffleText(inputText);
        System.out.println(resultText);
    }

    public String shuffleText(String inputText) {
        String result = "";

        String[] words = inputText.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            if (word.length() > 3) {
                List<Character> stringInterior = new ArrayList<>();

                for (int i = 1; i < word.length() - 1; i++) {
                    stringInterior.add(word.charAt(i));
                }

                Collections.shuffle(stringInterior);
                stringInterior.add(0, word.charAt(0));
                stringInterior.add(word.length() - 1, word.charAt(word.length() - 1));

                for (Character letter : stringInterior) {
                    stringBuilder.append(letter);
                }

                stringBuilder.append(" ");
            } else if (word.length() <= 3) {
                stringBuilder.append(word + " ");
            }
        }

        result = stringBuilder.toString();
        return result;
    }

}
