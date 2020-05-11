package com.ben.javapractices.practices.litteexcercises.employeecompare;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Create a java class Employee.
 * Add instance members to it to store name, age, salary.
 * Create getter / setter to them.
 * Add class level member to it to store the retiring age. It is 65 by default.
 * Initializes the instance tags in the constructor.
 * Implement a method getLeftYearsToRetiring to get the year left to retiring.
 * Add a method that returns all parameter in a well formed string. Named
 * getEmployeeInfo.
 * Add a method to set the retiring age.
 * Add a method to compare two Employee instances which one has greater salary.
 * This is class level method.
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private String name;

    private int age;

    private double salary;

    private int retiringAge = 65;

    public Employee(String name, int age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getLeftYearsToRetiring(int age, int retiringAge) {
        return retiringAge - age;
    }

}
