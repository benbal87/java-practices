package com.ben.javapractices.practices.littleoopexcercises.shapeinterface;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle implements Shape {

    private double radius = Math.PI;

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

}
