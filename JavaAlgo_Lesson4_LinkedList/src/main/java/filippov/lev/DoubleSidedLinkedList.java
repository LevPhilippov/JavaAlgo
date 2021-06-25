package filippov.lev;

public interface DoubleSidedLinkedList<E> extends LinkedList<E> {

    void addLast(E value);

    E getLast();

    E removeLast();

}
