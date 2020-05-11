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
import java.util.SortedSet;
import java.util.TreeSet;

public class ArrayMatcher3 {

    public static String[] inArray(String[] array1, String[] array2) {
        SortedSet<String> sortedSet = new TreeSet<>();

        for (String string2 : array2) {
            for (String string1 : array1) {
                if (string2.contains(string1)) {
                    sortedSet.add(string1);
                }
            }
        }

        return sortedSet.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = { "arp", "live", "strong" };
        String[] array2 = { "lively", "alive", "harp", "sharp", "armstrong" };
        // returns ["arp", "live", "strong"]

        String[] result = ArrayMatcher3.inArray(array1, array2);

        System.out.println(Arrays.toString(result));
        System.out.println(result.length);
    }

}
