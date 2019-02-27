package lev.filippov;

public class QueueOnList<E> implements QueueInt<E> {
    LionDoubleSidedLinkedList<E> queue = new LionDoubleSidedLinkedListImpl();

    @Override
    public void push(E value) {
        queue.add(value);
    }

    @Override
    public E pop() {
        return queue.removeLast();
    }

    @Override
    public E peek() {
        return queue.getLast();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int getSize() {
        return queue.size();
    }
}
