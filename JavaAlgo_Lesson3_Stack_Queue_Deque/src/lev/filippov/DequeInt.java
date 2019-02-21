package lev.filippov;

public interface DequeInt<E> {
    void insertFront(E value); // Adds an item at the front of Deque.
    void insertRear(E value); // Adds an item at the rear of Deque.
    E deleteFront(); // Deletes an item from front of Deque.
    E deleteRear(); //Deletes an item from rear of Deque.

    E getFront(); // Gets the front item from queue.
    E getRear(); //Gets the last item from queue.
    boolean isEmpty(); // Checks whether Deque is empty or not.
    boolean isFull(); //Checks whether Deque is full or not.
}
