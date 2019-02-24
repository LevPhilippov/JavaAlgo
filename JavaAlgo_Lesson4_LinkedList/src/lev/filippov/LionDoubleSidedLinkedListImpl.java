package lev.filippov;

public class LionDoubleSidedLinkedListImpl<E> extends LionSimpleLinkedListImpl<E> implements LionDoubleSidedLinkedList <E> {

    private Link <E> lastElement;

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public void add(E value) {
        super.add(value);
    }

    @Override
    public E remove(E value) {
        return super.remove(value);
    }

    @Override
    public E removeFirst() {
        return super.removeFirst();
    }

    @Override
    public E getFirst() {
        return super.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void display() {
        super.display();
    }
}
