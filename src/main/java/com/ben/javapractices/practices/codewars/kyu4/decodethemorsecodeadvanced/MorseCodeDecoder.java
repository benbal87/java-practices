package com.ben.javapractices.practices.codewars.kyu4.decodethemorsecodeadvanced;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MorseCodeDecoder {

    private static Map<String, String> morseAlphabet;

    final static private Pattern binaryPattern = Pattern.compile("(0+|1+)");

    private static final int PAUSE_BETWEEN_WORDS = 7;

    private static final int PAUSE_BETWEEN_LETTERS = 3;

    static {
        morseAlphabet = new HashMap<>();
        morseAlphabet.put(".-", "A");
        morseAlphabet.put("-...", "B");
        morseAlphabet.put("-.-.", "C");
        morseAlphabet.put("-..", "D");
        morseAlphabet.put(".", "E");
        morseAlphabet.put("..-.", "F");
        morseAlphabet.put("--.", "G");
        morseAlphabet.put("....", "H");
        morseAlphabet.put("..", "I");
        morseAlphabet.put(".---", "J");
        morseAlphabet.put("-.-", "K");
        morseAlphabet.put(".-..", "L");
        morseAlphabet.put("--", "M");
        morseAlphabet.put("-.", "N");
        morseAlphabet.put("---", "O");
        morseAlphabet.put(".--.", "P");
        morseAlphabet.put("--.-", "Q");
        morseAlphabet.put(".-.", "R");
        morseAlphabet.put("...", "S");
        morseAlphabet.put("-", "T");
        morseAlphabet.put("..-", "U");
        morseAlphabet.put("...-", "V");
        morseAlphabet.put(".--", "W");
        morseAlphabet.put("-..-", "X");
        morseAlphabet.put("-.--", "Y");
        morseAlphabet.put("--..", "Z");
        morseAlphabet.put("-----", "0");
        morseAlphabet.put(".----", "1");
        morseAlphabet.put("..---", "2");
        morseAlphabet.put("...--", "3");
        morseAlphabet.put("....-", "4");
        morseAlphabet.put(".....", "5");
        morseAlphabet.put("-....", "6");
        morseAlphabet.put("--...", "7");
        morseAlphabet.put("---..", "8");
        morseAlphabet.put("----.", "9");
        morseAlphabet.put(".-.-.-", ".");
        morseAlphabet.put("--..--", ");");
        morseAlphabet.put("..--..", "?");
        morseAlphabet.put(".----.", "`");
        morseAlphabet.put("-.-.--", "!");
        morseAlphabet.put("-..-.", "/");
        morseAlphabet.put("-.--.", "(");
        morseAlphabet.put("-.--.-", ")");
        morseAlphabet.put(".-...", "&");
        morseAlphabet.put("---...", ":");
        morseAlphabet.put("-.-.-.", ";");
        morseAlphabet.put("-...-", "=");
        morseAlphabet.put(".-.-.", "+");
        morseAlphabet.put("-....-", "-");
        morseAlphabet.put("..--.-", "_");
        morseAlphabet.put(".-..-.", "\"");
        morseAlphabet.put("...-..-", "$");
        morseAlphabet.put(".--.-.", "@");
        morseAlphabet.put("...-.-", "End of work");
        morseAlphabet.put("........", "Error");
        morseAlphabet.put("-.-.-", "Starting Signal");
        morseAlphabet.put("...-.", "Understood");
        morseAlphabet.put("...---...", "SOS");
        morseAlphabet.put("", " ");
    }

    public static String decodeBits(String bits) {
        String trimmed = trimZeros(bits);
        int unitLength = getUnitLength(trimmed);

        trimmed = trimmed.replace(concatenate('1', unitLength * 3), "-")
            .replace(concatenate('1', unitLength), ".")
            .replace(concatenate('0', unitLength * PAUSE_BETWEEN_WORDS), "   ")
            .replace(concatenate('0', unitLength * PAUSE_BETWEEN_LETTERS), " ")
            .replace(concatenate('0', unitLength), "");

        return trimmed;
    }

    private static int getUnitLength(String bits) {
        final Set<String> sequences = new HashSet<>();
        final Matcher matcher = binaryPattern.matcher(bits);
        while (matcher.find()) {
            sequences.add(matcher.group());
        }
        final String minSeq = sequences.stream()
            .min((String o1, String o2)
                -> Integer.compare(o1.length(), o2.length())).orElse("0");
        return minSeq.length();
    }

    private static String concatenate(char character, int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    private static String trimZeros(String bits) {
        String result = "";

        int firstOne = bits.indexOf('1');

        if (firstOne > -1) {
            int lastOne = bits.lastIndexOf('1');
            result = bits.substring(firstOne, lastOne + 1);
        }

        return result;
    }

    public static String decodeMorse(String morseCode) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] text = morseCode.split(" {3}");

        for (int i = 0; i < text.length; i++) {
            String[] word = text[i].split(" ");

            for (String letter : word) {
                stringBuilder.append(morseAlphabet.get(letter));
            }

            boolean isLastWord = i == text.length - 1;
            if (!isLastWord) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(decodeMorse(decodeBits(
            "00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110")));
    }

}
