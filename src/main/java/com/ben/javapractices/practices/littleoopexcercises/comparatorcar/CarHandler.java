package com.ben.javapractices.practices.littleoopexcercises.comparatorcar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarHandler {

    public static void main(String[] args) {
        Car ford = new Car("Ford", 180, new Color(128, 128, 128), 1300, 8.5, 2001);
        Car opel = new Car("Opel", 150, Color.black, 1400, 9.2, 2006);
        Car skoda = new Car("Skoda", 180, Color.blue, 1500, 5.5, 2010);

        List<Car> cars = new ArrayList<>();
        cars.add(ford);
        cars.add(opel);
        cars.add(skoda);

        System.out.println("Before sorting:");

        for (Car car : cars) {
            System.out.println(car);
        }

        cars.sort(new ConsumptionComparator());

        System.out.println("After sorting by consumption:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

}
