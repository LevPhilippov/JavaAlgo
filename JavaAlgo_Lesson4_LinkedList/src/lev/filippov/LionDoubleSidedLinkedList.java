package lev.filippov;

public interface LionDoubleSidedLinkedList<E> extends LionSimpleLinkedList<E> {

    void addLast(E value);

    Link<E> getLast();

    E removeLast();

}
