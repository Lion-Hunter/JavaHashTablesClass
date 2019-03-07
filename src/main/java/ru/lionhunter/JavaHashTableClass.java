package ru.lionhunter;

import java.util.Scanner;
import java.util.LinkedList;

public class JavaHashTableClass {
    public Pair[] array;

    public JavaHashTableClass(int quantity) {
        array = new Pair[quantity];
    }

    public void create() {
        Scanner scan = new Scanner(System.in);
        JavaHashTableClass arr = new JavaHashTableClass(scan.nextInt());
    }

    public boolean contain(int elem, Pair[] array) {
        for (Pair anArray : array) {
            if (anArray.value.contains(elem)) return true;
        }
        return false;
    }

    public static int transform(Element object, Pair[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    public void add(int num) {
        Element el = new Element(num);
        int index = transform(el, array);
        LinkedList<Integer> list = array[index].value;

        if (!list.contains(num)) {
            array[index].key++;
            list.add(num);
        }
    }

    public void remove(int num) {
        Element elem = new Element(num);
        int index = transform(elem, array);
        array[index].value.remove(new Integer(num));
        array[index].key--;
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