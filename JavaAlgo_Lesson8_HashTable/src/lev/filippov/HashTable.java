package lev.filippov;

public interface HashTable {

    boolean put(Item item, int price);

    boolean isEmpty();

    boolean remove(Item item);

    int getValue(Item item);

    void display();

    int size();

    int hash(Item item);
}
