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

    public static int transform(Element object, Pair[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    public void add(int num) {
        Element el = new Element(num);
        int index = transform(el, array);
        LinkedList<Integer> list = array[index].value;
        if (!list.contains(num)) {
            array[index].key = index;
            list.add(num);
        }
    }

    public void remove(int num) {
        array[num].value.remove(new Integer(num));
    }

    public static void main(String[] args) {
    }
}
