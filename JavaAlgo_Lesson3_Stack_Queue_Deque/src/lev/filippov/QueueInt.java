package lev.filippov;

public interface QueueInt<E> {

    void push(E value);

    E pop();

    E peek();

    boolean isFull();

    boolean isEmpty();

    int getSize();

}
