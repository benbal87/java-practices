package com.ben.javapractices.practices.littleoopexcercises.comparatorcar;

import java.util.Comparator;

public class ConsumptionComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getConsumption() < car2.getConsumption()) {
            return -1;
        } else if (car1.getConsumption() > car2.getConsumption()) {
            return 1;
        }
        return 0;
    }

}
