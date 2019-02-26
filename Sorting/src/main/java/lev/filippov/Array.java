package lev.filippov;

public interface Array <E extends Comparable<E>> {

    void add(E value);
    boolean remove(int index);
    boolean remove(E value);

    boolean contains(E value);
    int getIndex(E value);
    E get(int index);
    int size();
    void bubbleSort();
    void insertSort();
    void selectSort();

}
