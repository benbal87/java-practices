package com.ben.javapractices.practices.littleoopexcercises.comparatorcar;

import java.awt.*;

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
public class Car implements Comparable<Car> {

    private String brand;

    private int maxSpeed;

    private Color color;

    private int cc;

    private double consumption;

    private int year;

    @Override
    public int compareTo(Car o) {
        return year - o.getYear();
    }

}
