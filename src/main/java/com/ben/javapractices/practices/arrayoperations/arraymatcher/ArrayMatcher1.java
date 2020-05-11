/*
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order
 * of the strings of a1 which are substrings of strings of a2.
 *
 * Example 1:
 * a1 = ["arp", "live", "strong"]
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * returns ["arp", "live", "strong"]
 *
 * Example 2:
 * a1 = ["tarp", "mice", "bull"]
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * returns []
 *
 * Notes:
 * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
 * Beware: r must be without duplicates.
 */

package com.ben.javapractices.practices.arrayoperations.arraymatcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayMatcher1 {

    public static void main(String[] args) {
        String[] array1 = { "arp", "live", "strong" };
        String[] array2 = { "lively", "alive", "harp", "sharp", "armstrong" };
        // returns ["arp", "live", "strong"]

        String[] array3 = { "tarp", "mice", "bull" };
        String[] array4 = { "lively", "alive", "harp", "sharp", "armstrong" };
        // returns []

        ArrayMatcher1 arrayMatcher1 = new ArrayMatcher1();
        arrayMatcher1.displayMatchArrays(array1, array2);
        arrayMatcher1.displayMatchArrays(array3, array4);

        int n1 = arrayMatcher1.matchArrays(array1, array2).length;
        int n2 = arrayMatcher1.matchArrays(array3, array4).length;
        System.out.println(n1);
        System.out.println(n2);
    }

    private String[] matchArrays(String[] arraySmall, String[] arrayBig) {
        String[] result;
        StringBuilder stringBuilder = new StringBuilder();

        for (String value : arrayBig) {
            for (String s : arraySmall) {
                if (value.contains(s)) {
                    stringBuilder.append(s).append(",");
                }
            }
        }

        result = stringBuilder.toString().split(",");
        result = removeDuplicates(result);
        result = sortLexicographically(result);

        return result;
    }

    private String[] sortLexicographically(String[] array) {
        String[] result;
        List<String> stringList = Arrays.asList(array);
        Collections.sort(stringList);
        result = (String[]) stringList.toArray();
        return result;
    }

    private String[] removeDuplicates(String[] array) {
        String[] result;
        Set<String> hashSet = new HashSet<>();

        Collections.addAll(hashSet, array);

        result = hashSet.toArray(new String[hashSet.size()]);
        return result;
    }

    private void displayMatchArrays(String[] arraySmall, String[] arrayBig) {
        String[] matchedArray = matchArrays(arraySmall, arrayBig);
        System.out.println(Arrays.toString(matchedArray));
    }

}
