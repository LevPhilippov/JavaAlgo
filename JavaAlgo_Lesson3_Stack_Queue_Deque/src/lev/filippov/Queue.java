package lev.filippov;

import java.util.Arrays;

public class Queue <E> implements QueueInt <E> {

    static final int FRONT = 0;
    static final int END = -1;
    static final int SIZE = 0;
    int end;
    int front;
    static final int MAX_SIZE = 16;
    int size;
    E[] data;

    public Queue (int size) {
        end = END;
        front = FRONT;
        this.size = size;
        data = (E[])new Object[size];
    }

    public Queue () {
      this(MAX_SIZE);
    }

    @Override
    public void push(E value) {
        if (isFull())
            throw new RuntimeException();

        if (end == data.length) {
            end = END; //-1
        }

        data[++end] = value;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new RuntimeException();
        size--;
        if (front == data.length)
            front = FRONT; //0
        return data[front++] ;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new RuntimeException();
        return data[front];
    }

    @Override
    public boolean isFull() {
        return size == data.length-1;
    }

    @Override
    public boolean isEmpty() {
        return size == SIZE ;
    }

    @Override
    public int getSize() {
        return size;
    }

    public String display(){
        return Arrays.toString(data);
    }
}
