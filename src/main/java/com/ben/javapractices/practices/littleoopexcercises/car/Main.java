package com.ben.javapractices.practices.littleoopexcercises.car;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car Car1 = new Car("red", FuelType.DIESEL, 1000, "ASD123");
        Car Car2 = new Car("green", FuelType.GASOLINE, 1200, "ASD123");
        Car Car3 = new Car("black", FuelType.ELECTRIC, 1221200, "ASD123");

        List<Car> Cark = new ArrayList<>();
        Cark.add(Car1);
        Cark.add(Car3);
        Cark.add(Car2);

        System.out.println(Cark.indexOf(Car2));
    }

}
