package com.ben.javapractices.practices.collectionsandfileoperations.sortarraylistwithcomparator;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarList {

    private List<Car> carList;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : carList) {
            stringBuilder.append(car.toString());
        }

        return "CarList: {" + "carList=" + stringBuilder.toString() + '}';
    }

}
