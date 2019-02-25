package ru.lionhunter;

public class Pair {
    private final int key;
    private int value;
    public boolean deleted;

    public Pair (int inKey, int inValue) {
        key = inKey;
        value = inValue;
        deleted = false;
    }

    public int key() {
        return key;
    }

    public int value() {
        return  value;
    }
}
