package com.ben.javapractices.practices.littleoopexcercises.comparatorhuman;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human human1 = new Human(Gender.MALE, "John", 25, 185, 95, true);
        Human human2 = new Human(Gender.FEMALE, "Eve", 45, 162, 55, true);
        Human human3 = new Human(Gender.FEMALE, "Aliz", 35, 158, 64, true);
        Human human4 = new Human(Gender.MALE, "Bob", 15, 176, 82, true);

        List<Human> humans = new ArrayList<>();
        humans.add(human1);
        humans.add(human2);
        humans.add(human3);
        humans.add(human4);

        humans.sort(new HumanHeightComparator());
        for (Human human : humans) {
            System.out.println(human);
        }

        humans.sort(new HumanAgeComparator());
        for (Human human : humans) {
            System.out.println(human);
        }
    }

}
