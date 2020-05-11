package com.ben.javapractices.practices.litteexcercises.employeecompare;

import java.util.Arrays;
import java.util.List;

public class EmployeeHandler {

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 54, 1177);
        Employee e2 = new Employee("Eve", 46, 1356);
        Employee e3 = new Employee("Bob", 35, 1795);
        Employee e4 = new Employee("Mary", 45, 1285);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        employeeList.sort(new EmployeeSalaryComparator());

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

}
