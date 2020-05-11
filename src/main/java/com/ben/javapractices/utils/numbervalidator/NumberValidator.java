package com.ben.javapractices.utils.numbervalidator;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberValidator {

    /*
     * Returns true if the given string contains only one positive or negative integer.
     * */
    public boolean isInteger(String input) {
        String pattern = "(?<=\\[)[^\\]]+|[-\\w]+";
        return input.matches(pattern);
    }

    /*
     * Returns true if the given string contains only one positive integer.
     * */
    public boolean isPositiveInteger(String input) {
        String pattern = "^[0-9]*$";
        return input.matches(pattern);
    }

    /*
     * Returns true if the given string contains only one negative integer.
     * */
    public boolean isNegativeInteger(String input) {
        String pattern = "^-[0-9]*$";
        return input.matches(pattern);
    }

    /*
     * Returns true if the given string contains only one positive or negative integer or double.
     * */
    public boolean isIntegerOrDouble(String input) {
        String pattern = "^([+-](?=\\.?\\d))?(\\d+)?(\\.\\d+)?$";
        return input.matches(pattern);
    }

    /*
     * Returns true if the given string contains only positive or negative integers or doubles separated by comma.
     * */
    public boolean isNumberList(String input) {
        String pattern = "^((\\d?)|(([-+]?\\d+\\.?\\d*)|([-+]?\\d*\\.?\\d+))|(([-+]?\\d+"
                         + "\\.?\\d*\\,\\ ?)*([-+]?\\d+\\.?\\d*))|(([-+]?\\d*\\.?\\d+\\,\\"
                         + "?)*([-+]?\\d*\\.?\\d+))|(([-+]?\\d+\\.?\\d*\\,\\ ?)*([-+]?\\d"
                         + "*\\.?\\d+))|(([-+]?\\d*\\.?\\d+\\,\\ ?)*([-+]?\\d+\\.?\\d*)))$";
        return input.matches(pattern);
    }

}
