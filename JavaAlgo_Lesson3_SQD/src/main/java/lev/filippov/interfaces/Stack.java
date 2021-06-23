package lev.filippov.interfaces;

public interface Stack<E> {

    boolean push(E value);

    E pop();

    E peek();

    boolean isFull();

    boolean isEmpty();

    int getSize();

}
