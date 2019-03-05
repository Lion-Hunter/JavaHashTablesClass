package ru.lionhunter;

import java.util.LinkedList;

public class Pair {
    public int key;
    public LinkedList value;
    public boolean deleted;
    public int first;
    public int second;
    public Element head;
    public Element tail;

    public Pair (int inNum) {
        key = inNum;
        value = null;
        head = new Element(inNum);
        tail = new Element(inNum);
    }

    public Pair (int inFirst, int inSecond) {
        first = inFirst;
        second = inSecond;
        head = new Element(inSecond);
        tail = new Element(inSecond);
        deleted = false;
    }
}
