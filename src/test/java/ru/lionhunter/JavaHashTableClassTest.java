package ru.lionhunter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaHashTableClassTest {
    static boolean addTest(int size, int num1) {
        JavaHashTableClass table = new JavaHashTableClass(size);
        Element element = new Element(num1);
        int index = table.transform(element, table.array);
        table.add(num1, table.array, index);
        return table.contain(num1);
    }

    static boolean addRepeat(int size, int num1, int num2) {
        JavaHashTableClass table1 = new JavaHashTableClass(size);
        JavaHashTableClass table2 = new JavaHashTableClass(size);
        Element elem = new Element(num1);
        int index = table1.transform(elem, table1.array);

        table1.add(num1, table1.array, index);
        table1.add(num1, table1.array, index);
        table2.add(num2, table2.array, index);

        return table1.compare(table1.array, table2.array);
    }

    @Test
    void add() {
        assertTrue(addTest(12, 78));
        assertTrue(addTest(1, 65));
        assertTrue(addRepeat(54, 32, 32));
        assertFalse(addRepeat(30, 9, 11));
    }

    static boolean removeTest(int size, int num1, int num2) {
        JavaHashTableClass table = new JavaHashTableClass(size);
        Element element = new Element(num1);
        int index = table.transform(element, table.array);

        table.add(num1, table.array, index);
        table.remove(num2, table.array, index);

        return !table.contain(num1);


    }

    @Test
    void remove() {
        assertTrue(removeTest(12, 76, 76));
        assertTrue(removeTest(1, 43, 43));
        assertFalse(removeTest(90, 23, 5));
    }

    static boolean compareTest(int size1, int size2, int num1, int num2) {
        JavaHashTableClass table1 = new JavaHashTableClass(size1);
        JavaHashTableClass table2 = new JavaHashTableClass(size2);
        Element elem1 = new Element(num1);
        Element elem2 = new Element(num2);
        int index1 = table1.transform(elem1, table1.array);
        int index2 = table2.transform(elem2, table1.array);

        table1.add(num1, table1.array, index1);
        table1.add(num2, table1.array, index2);
        table2.add(num2, table2.array, index2);
        table2.add(num1, table2.array, index1);

        return table1.compare(table1.array, table2.array);
    }

    @Test
    void compare() {
        assertTrue(compareTest(12, 12, 43, 23));
        assertFalse(compareTest(43, 54, 23, 43));
        assertTrue(compareTest(63, 63,  4, 4));
    }

    @Test
    void main() {
    }
}