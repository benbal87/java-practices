package com.ben.javapractices.practices.littleoopexcercises.animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Animal animal_01 = new Animal(4, 5, 0.54);
        Animal animal_02 = new Animal(2, 2, 0.64);
        Animal animal_03 = new Animal(0, 7, 0.77);
        Animal animal_04 = new Animal(4, 3, 0.85);
        Animal animal_05 = new Animal(2, 4, 0.11);
        Animal animal_06 = new Animal(0, 9, 0.68);

        Set<Animal> animalSet = new HashSet<>();
        animalSet.add(animal_01);
        animalSet.add(animal_02);
        animalSet.add(animal_03);
        animalSet.add(animal_04);
        animalSet.add(animal_05);
        animalSet.add(animal_06);

        System.out.println(animalSet.size());

        Map<Animal, Integer> animalMap = new HashMap<>();
        animalMap.put(animal_01, 1);
        animalMap.put(animal_02, 2);
        animalMap.put(animal_03, 3);
        animalMap.put(animal_04, 4);
        animalMap.put(animal_05, 5);
        animalMap.put(animal_06, 6);

        System.out.println(animalMap.size());
        System.out.println(animalMap.get(animal_06));

        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal_01);
        animalList.add(animal_02);
        animalList.add(animal_03);
        animalList.add(animal_04);
        animalList.add(animal_05);
        animalList.add(animal_06);

        System.out.println(animalList.indexOf(animal_04));
    }

}
