package ru.lionhunter;
import java.util.Scanner;

public class JavaHashTableClass {
    private static int transform(Element object, Pair[] arr) {
        return Math.abs(object.hashCode()) < arr.length ? Math.abs(object.hashCode()) :
                Math.abs(object.hashCode()) % arr.length;
    }

    private static void add(Element element, int num, Pair[] a) {
        int count = transform(element, a);
        while (count < a.length) {
            if (a[count] == null || a[count].deleted) {
                a[count] = new Pair(transform(element, a), num);
                break;
            } else count++;
        }
        System.out.println("added");
    }

    private static void remove(Element element, int number, Pair[] a) {
        a[transform(element, a)].deleted = true;
        System.out.println("deleted");
    }

    private static void search(Element element, int num, Pair[] arr) {
        int count = 1;
        for (int i = transform(element, arr); i < arr.length; i++) {
            if ((arr[i] != null) && (arr[i].value() == num) && !arr[i].deleted) {
                System.out.println(num + " in table");
                count = 0;
                break;
            }
        }
        if (count == 1) {
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
        Pair[] array = new Pair[16];
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        Element sym = new Element(in);
        add(sym, in, array);
        search(sym, in + 1,array);
    }
}
