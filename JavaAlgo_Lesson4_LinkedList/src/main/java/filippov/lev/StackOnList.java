package filippov.lev;
import filippov.lev.filippov.interfaces.Stack;

public class StackOnList<E> implements Stack<E> {

    LinkedList<E> stack = new LionsLinkedList<>();

    @Override
    public boolean push(E value) {
        stack.add(value);
        return true;
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
        return stack.getSize();
    }
}
