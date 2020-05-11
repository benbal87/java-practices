package com.ben.javapractices.practices.codewars.kyu7.complementarydna;

import java.util.HashMap;
import java.util.Map;

public class DnaStrand {

    private static Map<Character, Character> dnaMap = new HashMap<>();

    static {
        dnaMap.put('A', 'T');
        dnaMap.put('C', 'G');
    }

    public static String makeComplement(String dna) {
        StringBuilder result = new StringBuilder();

        for (Character character : dna.toCharArray()) {
            Character pair = searchPair(character);
            result.append(pair);
        }

        return result.toString();
    }

    private static Character searchPair(Character character) {
        Character result = null;

        for (Character key : dnaMap.keySet()) {
            if (key.equals(character)) {
                result = dnaMap.get(key);
            } else if (dnaMap.get(key).equals(character)) {
                result = key;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String dna = makeComplement("ATTGC");

        if ("TAACG".equals(dna)) {
            System.out.println("OK");
        }
    }

}
