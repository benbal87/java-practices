package com.ben.javapractices.practices.littleoopexcercises.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    private String color = "red";

    private FuelType fuelType = FuelType.DIESEL;

    private int runKms = 100;

    private String id;

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        Car Car = (Car) obj;
        return Car.getId().equals(id);
    }

}
