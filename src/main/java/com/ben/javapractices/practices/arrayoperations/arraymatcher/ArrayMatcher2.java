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

public class ArrayMatcher2 {

    public static String[] inArray(String[] array1, String[] array2) {
        String[] result;
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : array2) {
            for (String value : array1) {
                if (s.contains(value)) {
                    stringBuilder
                        .append(value)
                        .append(",");
                }
            }
        }

        if (stringBuilder.length() == 0) {
            result = new String[] {};
        } else {
            result = stringBuilder.toString().split(",");

            Set<String> hashSet = new HashSet<>(Arrays.asList(result));
            result = hashSet.toArray(new String[0]);

            List<String> stringList = Arrays.asList(result);
            Collections.sort(stringList);
            result = (String[]) stringList.toArray();
        }

        return result;
    }

    public static void displayMatchArrays(String[] arraySmall, String[] arrayBig) {
        String[] matchedArray = inArray(arraySmall, arrayBig);
        System.out.println(Arrays.toString(matchedArray));
    }

    public static void main(String[] args) {
        String[] array1 = { "arp", "live", "strong" };
        String[] array2 = { "lively", "alive", "harp", "sharp", "armstrong" };
        // returns ["arp", "live", "strong"]

        String[] array3 = { "tarp", "mice", "bull" };
        String[] array4 = { "lively", "alive", "harp", "sharp", "armstrong" };
        // returns []

        ArrayMatcher2.displayMatchArrays(array1, array2);
        ArrayMatcher2.displayMatchArrays(array3, array4);

        int n1 = ArrayMatcher2.inArray(array1, array2).length;
        int n2 = ArrayMatcher2.inArray(array3, array4).length;
        System.out.println(n1);
        System.out.println(n2);
    }

}
