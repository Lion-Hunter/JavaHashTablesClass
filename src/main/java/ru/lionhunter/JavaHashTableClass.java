package ru.lionhunter;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class JavaHashTableClass {
    private LinkedList[] array;
    private int size;

    public JavaHashTableClass(int quantity) {
        array = new LinkedList[quantity];
        size = 0;
        IntStream.range(0, quantity).forEach(i -> array[i] = new LinkedList());
    }

    public int getSize() {
        return this.size;
    }

    public boolean contain(int elem) {
        Integer element = elem;
        int index = transform(element, array);
        return array[index].contains(elem);
    }

    private static int transform(Integer object, LinkedList[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    public boolean add(int num) {
        Integer element = num;
        int index = transform(element, array);

        if (!array[index].contains(num)) {
            array[index].add(num);
            size++;
            return true;
        }

        return  false;
    }

    public boolean remove(int num) {
        Integer number = num;
        int index = transform(number, array);
        if (array[index].contains(num)) {
            array[index].remove(new Integer(num));
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object arr) {
        if (!(arr instanceof JavaHashTableClass)) {
            return false;
        }

        JavaHashTableClass table = (JavaHashTableClass) arr;
        if (table.size != this.size) return false;
        for (LinkedList anArray : array) {
            for (Object iterator: anArray) {
                if (!table.contain((Integer) iterator)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }
}