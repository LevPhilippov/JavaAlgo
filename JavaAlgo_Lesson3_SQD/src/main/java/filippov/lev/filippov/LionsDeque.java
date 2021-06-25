package filippov.lev.filippov;
//Создать класс для реализации дека.

import filippov.lev.filippov.interfaces.Deque;

public class LionsDeque<E> extends LionsQueue<E> implements Deque<E> {

    public LionsDeque(int maxSize) {
        super(maxSize);
    }

    public LionsDeque() {
        this(MAX_SIZE);
    }

    @Override
    public void insertRight(E value) {
        super.push(value);
    }

    @Override
    public void insertLeft(E value) {
        if (isFull()) {
            throw new RuntimeException();
        }

        if (head == 0) {
            head = data.length;
        }

        data[--head] = value;
        size++;
    }

    @Override
    public E deleteLeft() {
        return super.pop();
    }


    @Override
    public E deleteRight() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        E item = data[tail--];

        if (tail == DEFAULT_TAIL) {
            tail = data.length - 1;
        }

        size--;
        return item;
    }

    @Override
    public E getHead() {
        if (isEmpty())
            throw new RuntimeException("The stack is empty.");
        return data[head];
    }

    @Override
    public E getTail() {
        if (isEmpty())
            throw new RuntimeException("The stack is empty.");
        return data[tail];
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    public int getSize() {
        return size;
    }
}
