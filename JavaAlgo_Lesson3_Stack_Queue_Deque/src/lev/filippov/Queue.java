package lev.filippov;

public class Queue <E> implements QueueInt <E> {

    public static final int FRONT = -1;
    public static final int END = 0;
    public static final int SIZE = -1;
    private int end;
    private int front;
    private static final int maxSize = 16;
    private int size;
    private E[] data;

    public Queue (int size) {
        end = END;
        front = FRONT;
        size = SIZE;
        data = (E[])new Object[size];
    }

    public Queue () {
      this(maxSize);
    }

    @Override
    public void push(E value) {
        if (isFull())
            throw new RuntimeException();
        if (end == data.length-1)
            end = END; //0
        data[end++] = value;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new RuntimeException();
        size--;
        if (front == data.length)
            front = FRONT; //-1
        return data[++front] ;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new RuntimeException();
        return data[end];
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
}
