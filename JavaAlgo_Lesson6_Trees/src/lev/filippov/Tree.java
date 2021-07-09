package lev.filippov;

public interface Tree <E extends Comparable <? super E>> {

    enum TaverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER;
    }

    void clear();

    void insert(E value);

    boolean find(E value);

    boolean delete(E value);

    void display();

    void traverse(TaverseMode mode);

    boolean isBalanced();

}
