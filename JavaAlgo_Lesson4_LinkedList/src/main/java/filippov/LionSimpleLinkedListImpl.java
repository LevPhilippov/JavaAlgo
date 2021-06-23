package lev.filippov;

import java.util.*;

public class LionSimpleLinkedListImpl<E> implements LionSimpleLinkedList<E>, Iterable<E> {

    Link<E> newLink;
    Link<E> firstLink;
    int size;

    @Override
    public void add(E value) {

    newLink = new Link<>(value);
    newLink.setNextLink(firstLink);

    if(!isEmpty()) {
       firstLink.setPreviousLink(newLink);
    }

    firstLink = newLink;
    size++;
    }

    protected Link <E> find(E value) {

        Link <E> current = firstLink;

        while(current != null) {
            if (current.getElement().equals(value)) {
                return current;
            }
            current = current.getNextLink();
        }

        return null;
    }

    @Override
    public E remove(E value) {
        Link <E> current;
        if ((current = find(value)) == null) {
            return null;
        }

        if(current==firstLink){
        return removeFirst();
        }

        current.getPreviousLink().setNextLink(current.getNextLink());
        current.getNextLink().setPreviousLink(current.getPreviousLink());

        size--;
        return current.getElement();
    }


    @Override
    public E removeFirst() {
        if (isEmpty()){
            return null;
        }
        E temp = firstLink.getElement();
        firstLink = firstLink.getNextLink();

        if(firstLink!=null){
            firstLink.setPreviousLink(null);
        }
        size--;
        return temp;
    }

    @Override
    public E getFirst() {
        return firstLink.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        Link<E> current = firstLink;
        System.out.println("-----------------");

        while (current!=null) {
            System.out.println(current.toString() + "\n");
            current = current.getNextLink();
        }
        System.out.println("-----------------");

    }

    @Override
    public int size() {
        return size;
    }

    //...................................методы для итератора.............................

    @Override
    public Iterator <E> iterator() {
        return new MyIterator<E>();
    }

    // класс итератор
    private class MyIterator<T> implements Iterator<T> {

        int cursor=0;       // index of next element to return
        int lastRet=-1; // index of last element returned; -1 if no such
        Link<E> current;
        boolean REMOVED_MARK = true;

        @Override
        public boolean hasNext() {
            return (cursor < size);
        }

        @Override
        public T next() {

            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            if(current == null) {
                current = firstLink;
                lastRet++;
                }
            else {
                current = current.getNextLink();
                lastRet++;
            }

            cursor = lastRet+1;

            REMOVED_MARK = false;
            return (T)current.getElement();
        }
        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @implSpec
         * The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *         operation is not supported by this iterator
         *
         * @throws IllegalStateException if the {@code next} method has not
         *         yet been called, or the {@code remove} method has already
         *         been called after the last call to the {@code next}
         *         method
         */

        @Override
        public void remove() {

            if(lastRet == -1 || REMOVED_MARK){
                throw new IllegalStateException();
            }

            if(current==firstLink){
                firstLink = current.getNextLink();
            }
            if(lastRet==0) {
                current.getNextLink().setPreviousLink((current.getPreviousLink()));
            } else if (cursor == size) {
                current.getPreviousLink().setNextLink((current.getNextLink()));
            } else {
            current.getPreviousLink().setNextLink(current.getNextLink());
            current.getNextLink().setPreviousLink(current.getPreviousLink());
            }

            size--;
            lastRet--;
            cursor = lastRet+1;
            REMOVED_MARK = true;
        }
    }
}
