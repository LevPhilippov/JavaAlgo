package filippov.lev.filippov;

import filippov.lev.filippov.interfaces.Queue;

import java.util.Arrays;

public class LionsQueue<E> implements Queue<E> {

    protected static final int DEFAULT_HEAD = 0;
    protected static final int DEFAULT_TAIL = -1;
    protected static final int SIZE = 0;
    protected static final int MAX_SIZE = 16;

    protected int tail;
    protected int head;
    protected int size;
    protected E[] data;

    public LionsQueue(int size) {
        this.tail = DEFAULT_TAIL;
        this.head = DEFAULT_HEAD;
        this.size = SIZE;
        this.data = (E[]) new Object[size];
    }

    public LionsQueue() {
        this(MAX_SIZE);
    }

    @Override
    public void push(E value) {
        if (isFull())
            throw new RuntimeException();

        if (tail == data.length) {
            tail = DEFAULT_TAIL; //-1
        }

        data[++tail] = value;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new RuntimeException();
        E item = data[head++];

        if (head == data.length)
            head = DEFAULT_HEAD; //0

        size--;
        return data[head];
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new RuntimeException();
        return data[head];
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == SIZE;
    }

    @Override
    public int getSize() {
        return size;
    }

    public String display() {
        return Arrays.toString(data);
    }
}
