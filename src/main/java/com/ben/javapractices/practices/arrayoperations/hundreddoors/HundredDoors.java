package com.ben.javapractices.practices.arrayoperations.hundreddoors;

public class HundredDoors {

    private boolean[] doors = new boolean[101];

    private int stop;

    private HundredDoors(int stop) {
        this.stop = stop;
        openCloseDoors();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            HundredDoors hundredDoors1 = new HundredDoors(i);
            int result1 = hundredDoors1.numberOfDoorsOpened();
            System.out.println("(" + i + ",\t" + result1 + ")");
        }
    }

    private void openCloseDoors() {
        for (int i = 1; i <= stop; i++) {
            for (int j = i; j < doors.length; j++) {
                if (j % i == 0) {
                    doors[j] = !doors[j];
                }
            }
        }
    }

    private int numberOfDoorsOpened() {
        int count = 0;
        for (boolean bool : doors) {
            count = bool ? ++count : count;
        }
        return count;
    }

}
