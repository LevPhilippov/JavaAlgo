package lev.filippov;

import lev.filippov.interfaces.Stack;

public class LionsStack<E> implements Stack<E> {

    public static final int DEFAULT_SIZE = -1;
    private int current_index;
    private static final int maxSize = 8;
    private E data[];

    public LionsStack() {
        this(maxSize);
    }

    public LionsStack(int maxSize) {
        current_index = DEFAULT_SIZE;
        data = (E[]) new Object[maxSize];
    }

    public boolean push(E value) {
        if(isFull())
            throw  new RuntimeException("Stack is full!");
        data[++current_index] = value;
        return true;
    }

    public E pop() {
        if(isEmpty())
            throw  new RuntimeException("Stack is empty!");
        return data[current_index--];
    }

    public E peek() {
        if(isEmpty())
            throw  new RuntimeException("Stack is empty!");
        return data[current_index];
    }

    public boolean isFull() {
        return current_index == data.length-1;
    }

    public boolean isEmpty() {
        return current_index == DEFAULT_SIZE;
    }

    @Override
    public int getSize() {
        return current_index+1;
    }
}
