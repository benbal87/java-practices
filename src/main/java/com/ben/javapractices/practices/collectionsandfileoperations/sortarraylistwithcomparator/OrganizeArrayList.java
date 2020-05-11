package com.ben.javapractices.practices.collectionsandfileoperations.sortarraylistwithcomparator;

import java.util.ArrayList;
import java.util.List;

public class OrganizeArrayList {

    /**
     * The comparator is organizing the array list due to the indexes of the elements (car ids) in the array list in the
     * comparator class.
     */
    public static void main(String[] args) {
        Car bmw = new Car(345, "BMW", "X5", 1999, 2500);
        Car audi = new Car(789, "AUDI", "TT", 2011, 1800);
        Car renault = new Car(159, "RENAULT", "TWINGO", 2014, 900);
        Car mercedes = new Car(753, "MERCEDES", "GLA", 2006, 2100);
        Car citroen = new Car(951, "CITROEN", "C4", 2010, 1500);

        List<Car> carList = new ArrayList<>();
        carList.add(mercedes);
        carList.add(audi);
        carList.add(renault);
        carList.add(bmw);
        carList.add(citroen);

        CarList cars = new CarList();
        cars.setCarList(carList);
        System.out.println(cars.toString());

        carList.sort(new CarComparator());
        System.out.println(cars.toString());
    }

}
