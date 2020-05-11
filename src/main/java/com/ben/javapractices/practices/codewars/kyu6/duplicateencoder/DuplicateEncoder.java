/*
 * The goal of this exercise is to convert a string to a new string where each
 * character in the new string is '(' if that character appears only once in
 * the original string, or ')' if that character appears more than once in
 * the original string. Ignore capitalization when determining if a character
 * is a duplicate.
 *
 * Examples:
 * "din" => "((("
 * "recede" => "()()()"
 * "Success" => ")())())"
 * "(( @" => "))(("
 */

package com.ben.javapractices.practices.codewars.kyu6.duplicateencoder;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {

    public static String encode(String input) {
        String result = "";

        input = input.toLowerCase();
        Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            int count = 0;

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    count++;
                }
            }

            hashMap.put(input.charAt(i), count);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (hashMap.get(input.charAt(i)) > 1) {
                stringBuilder.append(')');
            } else {
                stringBuilder.append('(');
            }
        }

        result = stringBuilder.toString();
        return result;
    }

    public static void main(String[] args) {
        String word = "Success";
        String result = DuplicateEncoder.encode(word);

        System.out.println(result);
    }

}
