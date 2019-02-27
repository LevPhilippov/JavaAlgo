package lev.filippov;


public class StackOnList<E> implements StackInt<E> {

    LionSimpleLinkedList<E> stack = new LionSimpleLinkedListImpl<>();

    @Override
    public void push(E value) {
        stack.add(value);
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public E peek() {
        return stack.getFirst();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int getSize() {
        return stack.size();
    }
}
