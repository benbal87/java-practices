package com.ben.javapractices.practices.stringoperations.shufflewordsinteriors;

public class ShuffleWordsInteriors4 {

    public static void main(String[] args) {
        String inputText =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the "
            + "industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and"
            + " scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap"
            + " into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with "
            + "the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop "
            + "publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        ShuffleWordsInteriors4 shuffleWordsInteriors = new ShuffleWordsInteriors4();
        String shuffledString = shuffleWordsInteriors.shuffle(inputText);
        System.out.println(shuffledString);
    }

    public String shuffle(String inputString) {
        char[] inputCharArray = inputString.toCharArray();

        int wordCharCount = 0;
        for (int i = 0; i < inputCharArray.length; i++) {
            if (Character.isAlphabetic(inputCharArray[i])) {
                wordCharCount++;
            } else if (!Character.isAlphabetic(inputCharArray[i]) && wordCharCount > 3) {
                int indexStart = i - wordCharCount + 1;
                int indexEnd = i - 2;

                shuffleWord(inputCharArray, indexStart, indexEnd);
                wordCharCount = 0;
            } else {
                wordCharCount = 0;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputCharArray.length; i++) {
            stringBuilder.append(inputCharArray[i]);
        }

        return stringBuilder.toString();
    }

    public void shuffleWord(char[] inputCharArray, int indexStart, int indexEnd) {
        char[] originalArray = new char[inputCharArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = inputCharArray[i];
        }

        while (!checkIfChanged(inputCharArray, originalArray)) {
            for (int i = indexEnd; i > indexStart; i--) {
                int randomIndex = (int) (Math.random() * (indexEnd + 1 - indexStart)) + indexStart;
                char temp = inputCharArray[randomIndex];
                inputCharArray[randomIndex] = inputCharArray[i];
                inputCharArray[i] = temp;
            }
        }
    }

    public boolean checkIfChanged(char[] inputCharArray, char[] originalArray) {
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != inputCharArray[i]) {
                return true;
            }
        }

        return false;
    }

}
