package com.ben.javapractices.practices.collectionsandfileoperations.sortarraylistwithcomparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarComparator implements Comparator<Car> {

    private static final List<Integer> filterIdList = new ArrayList<>();

    static {
        filterIdList.add(Constants.BMW_ID);
        filterIdList.add(Constants.AUDI_ID);
        filterIdList.add(Constants.RENAULT_ID);
        filterIdList.add(Constants.MERCEDES_ID);
        filterIdList.add(Constants.CITROEN_ID);
    }

    @Override
    public int compare(Car car1, Car car2) {
        int index1 = filterIdList.indexOf(car1.getId());
        int index2 = filterIdList.indexOf(car2.getId());

        return index1 - index2;
    }

}
