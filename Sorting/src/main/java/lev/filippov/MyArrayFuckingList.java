package lev.filippov;

import java.util.Arrays;

public class MyArrayFuckingList<E extends Object & Comparable<E>> implements Array <E> {

    private static final int DEFAULT_CAPACITY = 16;
    private int CURRENT_SIZE;
    volatile E[] data;

    public MyArrayFuckingList(int capacity) {
        this.data = (E[]) new Object [capacity];
        this.CURRENT_SIZE = 0;
    }

    public MyArrayFuckingList() {
        this(DEFAULT_CAPACITY);
    }


    @Override

    public void add(E value) {
        ensure_capasity();
        data[CURRENT_SIZE] = value;
        CURRENT_SIZE++;
    }

    private void ensure_capasity () {
        if(data.length == CURRENT_SIZE) {
            data = Arrays.copyOf(data, data.length*2);
        }
    }

    public int getIndex(E value) {
        for (int i = 0; i <CURRENT_SIZE ; i++) {
            if(data[i].equals(value))
                return i;
        }
        return -1;

    }

    public boolean remove(E value) {
        return remove(getIndex(value));
    }

    public boolean remove(int index) {
        if (CURRENT_SIZE > 0 && index >= 0 && index < CURRENT_SIZE) {
            for (int i = index; i <CURRENT_SIZE-1 ; i++) {
                data[i] = data[i+1];
            }
            data[--CURRENT_SIZE] = null;
            return true;
        }
        return false;
    }

    public boolean contains(E value) {
        if(getIndex(value) != -1)
            return true;
        return false;
    }

    public E get(int index) {
        return data[index];
    }


    public int size() {
        return CURRENT_SIZE;
    }

    public void bubbleSort() {

        for (int i = 0; i < CURRENT_SIZE-1; i++) {
            for (int j = 0; j < CURRENT_SIZE-i-1  ; j++) {
                if(data[j].compareTo(data[j+1]) > 0)
                    change(j,j+1);
            }
        }

    }
    public void selectSort() {
        int minIndex;
        for (int i = 0; i <CURRENT_SIZE; i++) {
            minIndex = i;
            for (int j = i+1; j <CURRENT_SIZE; j++) {
                if(data[j].compareTo(data[minIndex]) < 0)
                    minIndex = j;
            }
            change(i,minIndex);
        }
    }

    public void insertSort() {
        for (int i = 1; i <CURRENT_SIZE ; i++) {
            E temp = data[i];
            int iter = i;
            while(iter > 0 && data[iter-1].compareTo(temp) >= 0) {
                data[iter] = data[iter-1];
                --iter;
            }
            data[iter] = temp;
        }
    }


    private void change(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
