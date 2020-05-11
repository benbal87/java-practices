package com.ben.javapractices.practices.littleoopexcercises.shapeinterface;

public class Calculator {

    private static void printShapeData(Shape shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            System.out.println(c.getRadius());
        } else if (shape instanceof Square) {
            Square s = (Square) shape;
            System.out.println(s.getSideLength());
        }
    }

    public static void main(String[] args) {
        printShapeData(new Square());
        printShapeData(new Circle());
    }

}
