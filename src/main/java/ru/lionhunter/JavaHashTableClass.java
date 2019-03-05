package ru.lionhunter;

import java.util.LinkedList;

public class JavaHashTableClass {
    public Pair[] array;
    public JavaHashTableClass() {
        array = new Pair[16];
    }

    public void create() {
        JavaHashTableClass arr = new JavaHashTableClass();
    }

    public static int transform(Element object, Pair[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    public boolean search(int num, LinkedList list) {
        for (int i = 0; i < 16; i++) {
            if (list.contains(num)) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        LinkedList list = array[num].value;
        if (!search(num, list)) {
            Element el = new Element(num);
            array[num].key = transform(el, array);
            if (!list.contains(num)) {
                list = new LinkedList();
                list.add(num);
            }
        }
    }

    public void remove(int num) {
        LinkedList list = array[num].value;
        if (!search(num, list)) {
            list.remove(num);
        }
    }

    public static void main(String[] args) {
    }
}
