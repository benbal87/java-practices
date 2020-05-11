package com.ben.javapractices.practices.littleoopexcercises.shapeinterface;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square implements Shape {

    private double sideLength = 5.4;

    @Override
    public double getPerimeter() {
        return -1;
    }

    @Override
    public double getArea() {
        return -1;
    }

}
