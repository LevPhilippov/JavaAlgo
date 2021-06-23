package lev.filippov;

public interface LionDoubleSidedLinkedList<E> extends LionSimpleLinkedList<E> {

    void addLast(E value);

    E getLast();

    E removeLast();

}
