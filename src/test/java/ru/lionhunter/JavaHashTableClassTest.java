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

    @Test
    void add() {
        assertTrue(addTest(12, 78));
        assertTrue(addTest(1, 65));
        assertFalse(addRepeat(30, 9, 11));
        assertTrue(addRepeat(54, 32, 32));
    }

    static boolean removeTest(int size, int num1, int num2) {
        JavaHashTableClass table = new JavaHashTableClass(size);
        table.add(num1);
        table.remove(num2);

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

        table1.add(num1);
        table1.add(num2);
        table2.add(num2);
        table2.add(num1);

        return table1.equals(table2);
    }

    @Test
    void equals() {
        assertTrue(compareTest(12, 12, 43, 23));
        assertFalse(compareTest(43, 54, 23, 43));
        assertTrue(compareTest(63, 63,  4, 4));
    }

    @Test
    void main() {
    }
}