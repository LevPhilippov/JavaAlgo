package philippov;

public interface Array <E> {

    void add(E value);
    boolean remove(int index);
    boolean remove(E value);

    boolean contains(E value);
    int getIndex(E value);
    E get(int index);
    int size();

}
