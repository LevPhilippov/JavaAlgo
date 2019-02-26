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
        return new MyIterator<>();
    }

    // класс итератор
    private class MyIterator<E> implements Iterator<E> {

        int cursor;       // index of next element to return
        int lastRet=-1; // index of last element returned; -1 if no such
        Object current;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = lastRet;

            while(i < cursor) {

                if(current == null) {
                    current = firstLink;
                    i++;
                    break;
                }

                current = ((Link)current).getNextLink();
                i++;
            }

            lastRet = i;
            cursor = i+1;
            return (E)((Link) current).getElement() ;
        }
    }
}
