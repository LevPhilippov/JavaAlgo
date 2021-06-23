package lev.filippov.interfaces;

public interface Queue<E> {

    void push(E value);

    E pop();

    E peek();

    boolean isFull();

    boolean isEmpty();

    int getSize();

}
