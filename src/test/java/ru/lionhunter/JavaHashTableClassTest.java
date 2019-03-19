package ru.lionhunter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaHashTableClassTest {
    static boolean addTest(int size, int num1) {
        JavaHashTableClass table = new JavaHashTableClass(size);
        table.add(num1);
        return table.contain(num1);
    }

    static boolean addRepeat(int size, int num1, int num2) {
        JavaHashTableClass table1 = new JavaHashTableClass(size);
        JavaHashTableClass table2 = new JavaHashTableClass(size);
        table1.add(num1);
        table1.add(num1);
        table2.add(num2);

        return table1.equals(table2);
    }

    static boolean addSize(int size, int num1, int num2) {
        JavaHashTableClass table1 = new JavaHashTableClass(size);
        JavaHashTableClass table2 = new JavaHashTableClass(size);
        table1.add(num1);
        table1.add(num2);
        table2.add(num1);
        return table1.getSize() == table2.getSize();
    }

    @Test
    void add() {
        assertFalse(addRepeat(3, 9, 11));
        assertTrue(addTest(12, 78));
        assertTrue(addTest(1, 65));

        assertTrue(addRepeat(54, 32, 32));
        assertTrue(addSize(32, 65, 65));
        assertFalse(addSize(4, 42, 98));
    }

    static boolean removeTest(int size, int num1, int num2) {
        JavaHashTableClass table = new JavaHashTableClass(size);
        table.add(num1);
        table.remove(num2);

        return !table.contain(num1);


    }

    static boolean removeSize(int size, int num1, int num2) {
        JavaHashTableClass table = new JavaHashTableClass(size);
        table.add(num1);
        table.remove(num2);
        return table.getSize() == 0;
    }

    @Test
    void remove() {
        assertTrue(removeTest(12, 76, 76));
        assertTrue(removeTest(1, 43, 43));
        assertFalse(removeTest(90, 23, 5));
        assertFalse(removeSize(9, 34, 4));
        assertTrue(removeSize(23, 98, 98));
    }

    static boolean compareTest1(int size1, int size2, int num1, int num2) {
        JavaHashTableClass table1 = new JavaHashTableClass(size1);
        JavaHashTableClass table2 = new JavaHashTableClass(size2);

        table1.add(num1);
        table1.add(num2);
        table2.add(num2);
        table2.add(num1);

        return table1.equals(table2);
    }

    static boolean compareTest2(int size1, int size2, int num1, int num2, int num3) {
        JavaHashTableClass table1 = new JavaHashTableClass(size1);
        JavaHashTableClass table2 = new JavaHashTableClass(size2);

        table1.add(num1);
        table1.add(num2);
        table2.add(num2);
        table2.add(num1);
        table1.add(num3);

        return table1.equals(table2);
    }

    @Test
    void equals() {
        assertFalse(compareTest2(3, 54, 23, 43, 15));
        assertTrue(compareTest2(14, 12, 17, 53, 17));
        assertTrue(compareTest1(12, 12, 43, 23));
        assertTrue(compareTest1(63, 63,  4, 4));
    }

    @Test
    void main() {
    }
}