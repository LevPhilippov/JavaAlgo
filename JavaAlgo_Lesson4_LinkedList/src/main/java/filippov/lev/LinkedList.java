package filippov.lev;

public interface LinkedList<E> {

    void add(E value);

    E remove(E value);

    E removeFirst();

    E getFirst();

    boolean isEmpty();

    void display();

    int getSize();


}
