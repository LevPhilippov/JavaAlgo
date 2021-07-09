package lev.filippov;

public interface HashTable<K extends Object,V extends Object> {

    boolean put(K key, V value);

    boolean isEmpty();

    boolean remove(K key);

    V getValue(K key);

    void display();

    int size();

    int hashIndex(K key);
}
