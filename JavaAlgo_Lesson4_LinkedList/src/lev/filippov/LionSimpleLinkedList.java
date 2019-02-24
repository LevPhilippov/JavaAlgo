package lev.filippov;

public interface LionSimpleLinkedList<E> {

    void add(E value);

    E remove(E value);

    E removeFirst();

    E getFirst();

    boolean isEmpty();

    void display();


}
