package com.ben.javapractices.practices.littleoopexcercises.towersofhannoi;

import java.util.Stack;

class Tower {

    private Stack<Disk> tower = new Stack<>();

    Disk removeDisk() {
        return tower.pop();
    }

    public void pushDisk(Disk disk) {
        tower.push(disk);
    }

    public int getTowerHeight() {
        return tower.size();
    }

    public int getUpperDiskSize() {
        return tower.peek().getDiskSize();
    }

}
