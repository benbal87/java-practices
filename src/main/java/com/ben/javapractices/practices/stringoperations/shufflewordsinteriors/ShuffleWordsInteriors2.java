package com.ben.javapractices.practices.stringoperations.shufflewordsinteriors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ShuffleWordsInteriors2 {

    public static void main(String[] args) {
        String inputText = "Test message.";

        ShuffleWordsInteriors2 shuffleWordsInteriors = new ShuffleWordsInteriors2();
        String resultText = shuffleWordsInteriors.shuffleText(inputText);

        System.out.println(resultText);
    }

    public String shuffleText(String inputText) {
        // Putting special characters with their index number into a sorted map.
        Set<Map.Entry<Integer, Character>> specialCharactersSortedMap = identifySpecialCharacters(inputText);
        // Replacing all hyphen characters with whitespaces.
        inputText = inputText.replaceAll("-", " ");
        // Removing special characters from the text.
        inputText = removeSpecialCharacters(inputText);
        // Splitting the text to a string array by whitespaces.
        String[] wordsArray = inputText.split(" ");
        // Shuffle the word's interior in the array.
        StringBuilder shuffledText = shuffleWords(wordsArray);
        // Re insert The special characters into the text.
        return reInsertSpecialChars(specialCharactersSortedMap, shuffledText);
    }

    public Set<Map.Entry<Integer, Character>> identifySpecialCharacters(String inputText) {
        Map<Integer, Character> specialCharactersMap = new TreeMap<>();

        for (int i = 0; i < inputText.length(); i++) {
            char actualCharacter = inputText.charAt(i);
            String actualCharacterString = Character.toString(actualCharacter);

            if (actualCharacterString.matches("\\p{Punct}")) {
                specialCharactersMap.put(i, actualCharacter);
            }
        }

        return specialCharactersMap.entrySet();
    }

    public String removeSpecialCharacters(String inputText) {
        String result;

        char[] inputTextArray = inputText.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : inputTextArray) {
            String characterString = Character.toString(character);

            if (!characterString.matches("\\p{Punct}")) {
                stringBuilder.append(character);
            }
        }

        result = stringBuilder.toString();
        return result;
    }

    public String reInsertSpecialChars(
        Set<Map.Entry<Integer, Character>> specialCharactersSortedMap,
        StringBuilder stringBuilder
    ) {
        String result;

        for (Map.Entry<Integer, Character> mapEntry : specialCharactersSortedMap) {
            int insertIndex = mapEntry.getKey();
            char charToInsert = mapEntry.getValue();

            if (charToInsert == '-') {
                stringBuilder.insert(insertIndex, charToInsert);
                stringBuilder.replace(insertIndex, insertIndex + 2, "-");
            } else {
                stringBuilder.insert(insertIndex, charToInsert);
            }
        }

        result = stringBuilder.toString();
        return result;
    }

    public StringBuilder shuffleWords(String[] wordsArray) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : wordsArray) {
            if (word.length() > 3) {
                List<Character> shuffledWordCharList = shuffleOneWord(word);

                for (Character letter : shuffledWordCharList) {
                    stringBuilder.append(letter);
                }

                stringBuilder.append(" ");
            } else {
                stringBuilder
                    .append(word)
                    .append(" ");
            }
        }

        return stringBuilder;
    }

    public List<Character> shuffleOneWord(String word) {
        List<Character> shuffleList = new ArrayList<>();
        List<Character> originalList = new ArrayList<>();

        for (int i = 1; i < word.length() - 1; i++) {
            shuffleList.add(word.charAt(i));
            originalList.add(word.charAt(i));
        }

        // Ensuring that no word remain the same.
        while (shuffleList.equals(originalList)) {
            Collections.shuffle(shuffleList);
        }

        shuffleList.add(0, word.charAt(0));
        shuffleList.add(word.length() - 1, word.charAt(word.length() - 1));

        return shuffleList;
    }

}
