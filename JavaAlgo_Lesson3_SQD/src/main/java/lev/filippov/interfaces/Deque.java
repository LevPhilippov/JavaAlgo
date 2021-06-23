package lev.filippov.interfaces;

public interface Deque<E> extends Queue<E> {

    void insertLeft(E value); // Adds an item at the front of Deque.
    void insertRight(E value); // Adds an item at the end of Deque.

    E deleteLeft(); // Deletes an item from front of Deque.
    E deleteRight(); //Deletes an item from end of Deque.

    E getHead(); // Gets the front item from queue.
    E getTail(); //Gets the last item from queue.
}
