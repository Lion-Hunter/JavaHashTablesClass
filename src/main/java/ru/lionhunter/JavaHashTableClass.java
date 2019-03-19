package ru.lionhunter;

import java.util.stream.IntStream;

public class JavaHashTableClass {
    private Pair[] array;
    private int size;

    public JavaHashTableClass(int quantity) {
        array = new Pair[quantity];
        size = 0;
        IntStream.range(0, quantity).forEach(i -> array[i] = new Pair());
    }

    public int getSize() {
        return this.size;
    }

    public boolean contain(int elem) {
        Integer element = elem;
        int index = transform(element, array);
        return array[index].value.contains(elem);
    }

    private static int transform(Integer object, Pair[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    public boolean add(int num) {
        Integer element = num;
        int index = transform(element, array);

        if (!array[index].value.contains(num)) {
            array[index].value.add(num);
            size++;
            return true;
        }

        return  false;
    }

    public boolean remove(int num) {
        Integer number = num;
        int index = transform(number, array);
        if (array[index].value.contains(num)) {
            array[index].value.remove(new Integer(num));
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
        for (Pair anArray : array) {
            for (Integer iterator : anArray.value) {
                if (!table.contain(iterator)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }
}