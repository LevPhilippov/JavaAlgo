package lev.filippov;

public class Stack <E> implements StackInt <E>{
    public static final int SIZE = -1;
    private int size;
    private static final int maxSize = 8;
    private E data[];

    public Stack() {
        this(maxSize);
    }
    public Stack (int maxSize) {
        size = SIZE;
        data = (E[]) new Object[maxSize];
    }

    public void push(E value) {
        if(isFull())
            throw  new RuntimeException("Stack is full!");
        data[++size] = value;
    }

    public E pop() {
        if(isEmpty())
            throw  new RuntimeException("Stack is empty!");
        return data[size--];
    }

    public E peek() {
        if(isEmpty())
            throw  new RuntimeException("Stack is empty!");
        return data[size];
    }

    public boolean isFull() {
        return size == data.length-1;
    }

    public boolean isEmpty() {
        return size == SIZE;
    }

    @Override
    public int getSize() {
        return size;
    }
}
