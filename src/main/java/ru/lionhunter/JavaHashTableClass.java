package ru.lionhunter;

import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaHashTableClass {
    public Pair[] array;

    public JavaHashTableClass(int quantity) {
        array = new Pair[quantity];
        IntStream.range(0, quantity).forEach(i -> array[i] = new Pair());
    }

    public void create() {
        Scanner scan = new Scanner(System.in);
        JavaHashTableClass arr = new JavaHashTableClass(scan.nextInt());
    }

    public boolean contain(int elem) {
        for (Pair anArray : array) {
            if (anArray.value.contains(elem)) return true;
        }

        return false;
    }

    public int transform(Element object, Pair[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    public void add(int num, Pair[] arr, int index) {
        if (!arr[index].value.contains(num)) {
            arr[index].key++;
            arr[index].value.add(num);
        }
    }

    public void remove(int num, Pair[] arr, int index) {
        arr[index].value.remove(new Integer(num));
        arr[index].key--;
    }

    public boolean compare(Pair[] first, Pair[] second) {
        if (first.length != second.length) return false;

        for (int i = 0; i < first.length; i++) {
            if (first[i].key != second[i].key) return false;

            for (int sym: first[i].value) {
                if (!second[i].value.contains(sym)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }
}