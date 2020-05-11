package com.ben.javapractices.utils.readtextfile;

import java.util.List;

import com.ben.javapractices.utils.Util;

public class Main {

    public static void main(String[] args) {
        String FILE = Util.getResourcePath() + "test_files/cities/cities.txt";
        List<String> cityList = ReadTextFile.read(FILE);
        String cities = String.join("\n", cityList);
        System.out.println(cities);
    }

}
