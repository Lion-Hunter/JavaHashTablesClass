package ru.lionhunter;

import java.util.Iterator;
import java.util.stream.IntStream;

public class JavaHashTableClass {
    public Pair[] array;
    public int size;

    public JavaHashTableClass(int quantity) {
        array = new Pair[quantity];
        size = 0;
        IntStream.range(0, quantity).forEach(i -> array[i] = new Pair());
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
            array[index].key++;
            array[index].value.add(num);
            size++;
            return true;
        }

        return  false;
    }

    public boolean remove(int num) {
        Integer number = num;
        int index = transform(number, array);
        array[index].value.remove(new Integer(num));
        array[index].key--;
        size--;
        return true;
    }

    @Override
    public boolean equals(Object arr) {
        if (arr instanceof JavaHashTableClass) {
            JavaHashTableClass table = (JavaHashTableClass) arr;
            if (table.size != this.size) return false;
            for (int i = 0; i < table.array.length; i++) {
                for (Iterator<Integer> iterator = array[i].value.iterator(); iterator.hasNext(); ) {
                    Integer num = iterator.next();
                    if (!table.contain(num)) return false;
                }
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
    }
}