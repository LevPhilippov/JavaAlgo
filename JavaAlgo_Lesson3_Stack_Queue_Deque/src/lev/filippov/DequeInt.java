package lev.filippov;

public interface DequeInt<E> extends QueueInt<E>  {

    void insertLeft(E value); // Adds an item at the front of Deque.
    void insertRight(E value); // Adds an item at the end of Deque.
    E deleteLeft(); // Deletes an item from front of Deque.

    E deleteRight(); //Deletes an item from end of Deque.

    E getFront(); // Gets the front item from queue.
    E getEnd(); //Gets the last item from queue.
}
