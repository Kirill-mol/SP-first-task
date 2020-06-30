package com.company;

import java.util.Arrays;

public class MyArrayListForInt {
    private Integer[] array;
    private int lastElemIndex;

    public MyArrayListForInt() {
        array = new Integer[10];
        lastElemIndex = -1;
    }

    public int size() {
        return lastElemIndex + 1;
    }

    public void add(Integer index, Integer number) {
        if(lastElemIndex + 1 < index) throw new IndexOutOfBoundsException();
        else if(lastElemIndex + 1 == index) add(number);
        array[index] = number;
    }

    public void add(Integer number) {
        if(lastElemIndex + 1 >= array.length) {
            resizeArray();
        }
        array[++lastElemIndex] = number;
    }

    public int get(Integer index) {
        return array[index];
    }

    private void resizeArray() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size()));
    }
}
