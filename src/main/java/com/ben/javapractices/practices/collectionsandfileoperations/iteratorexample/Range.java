package com.ben.javapractices.practices.collectionsandfileoperations.iteratorexample;

import java.util.Iterator;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Range implements Iterable<Integer> {

    private int start;

    private int end;

    public static void main(String[] args) {
        Range range = new Range(1, 10);

        // Long way
        Iterator<Integer> it = range.iterator();
        while (it.hasNext()) {
            int current = it.next();
            System.out.print(current + "  ");
        }

        System.out.println("\n--------");

        // Shorter, nicer way:
        for (Integer current : range) {
            System.out.print(current + "  ");
        }

        System.out.println("\n--------");

        for (Integer current : new Range(5, 10)) {
            System.out.print(current + "  ");
        }

        Integer number = new Integer(81);
        System.out.println(++number);
    }

    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    // Inner class example
    private class RangeIterator implements Iterator<Integer> {

        private int cursor;

        public RangeIterator() {
            this.cursor = Range.this.start;
        }

        public boolean hasNext() {
            return this.cursor < Range.this.end;
        }

        public Integer next() {
            if (this.hasNext()) {
                return cursor++;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
