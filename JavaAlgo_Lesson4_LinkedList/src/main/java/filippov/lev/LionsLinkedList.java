package filippov.lev;

import java.util.*;

public class LionsLinkedList<E> implements LinkedList<E> {

    Link<E> newLink;
    Link<E> firstLink;
    int size;

    public LionsLinkedList() {
        this.newLink = null;
        this.firstLink = null;
    }

    @Override
    public void add(E value) {
        newLink = new Link<>(value);
        newLink.setNextLink(firstLink);

        if (!isEmpty()/*firstlink!=null*/) {
            firstLink.setPreviousLink(newLink);
        }

        firstLink = newLink;
        size++;
    }

    @Override
    public E remove(E value) {
        Link<E> current;
        if ((current = find(value)) == null) {
            return null;
        }
        if (current == firstLink) {
            return removeFirst();
        }
        current.getPreviousLink().setNextLink(current.getNextLink());
        if(current.getNextLink()!= null) {
            current.getNextLink().setPreviousLink(current.getPreviousLink());
        }
        size--;
        current.setNextLink(null);
        current.setPreviousLink(null);
        return current.getValue();
    }


    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Link<E> current = firstLink;
        firstLink = firstLink.getNextLink();

        if (firstLink != null) {
            firstLink.setPreviousLink(null);
        }
        size--;
        current.setNextLink(null);
        return current.getValue();
    }

    @Override
    public E getFirst() {
        if(firstLink == null) return null;
        return firstLink.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        Link<E> current = firstLink;
        System.out.println("-----------------");
        while (current != null) {
            System.out.println(current.toString() + "\n");
            current = current.getNextLink();
        }
        System.out.println("-----------------");

    }

    @Override
    public int getSize() {
        return size;
    }

    protected Link<E> find(E value) {
        Link<E> current = firstLink;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNextLink();
        }
        return null;
    }

    //...................................метод итератора.............................

    @Override
    public Iterator<E> iterator() {
        return new LLIterator<E>(this);
    }

    //...................................Класс итератора.............................

    protected class LLIterator<T> implements Iterator<T> {
//        int cursor = 0;       // index of next element to return
//        int lastRet = -1; // index of last element returned; -1 if no such
        Link<T> cursor;
        boolean REMOVED_MARK = false;
        LionsLinkedList<T> lionsLinkedList;

        public LLIterator(LionsLinkedList<T> lionsLinkedList) {
            this.lionsLinkedList=lionsLinkedList;
            cursor = null;
        }

        @Override
        public boolean hasNext() {
            if (cursor!=null) {
                return cursor.nextLink != null;
            } else {
                return lionsLinkedList.firstLink != null;
            }
//            return (cursor < size);
        }

        @Override
        public T next() {
            if(!hasNext()) { throw new NoSuchElementException();}
            if (cursor==null) {
                cursor=(Link<T>) lionsLinkedList.firstLink;
            } else { cursor = cursor.getNextLink();}
            REMOVED_MARK=false;
            return (T) cursor.getValue();
        }

        @Override
        public void remove() {
            if (REMOVED_MARK) throw new IllegalStateException();
            lionsLinkedList.remove(cursor.getValue());
            REMOVED_MARK=true;


//            if (lastRet == -1 || REMOVED_MARK) {
//                throw new IllegalStateException();
//            }
//
//            if (current == firstLink) {
//                firstLink = current.getNextLink();
//            }
//            if (lastRet == 0) {
//                current.getNextLink().setPreviousLink((current.getPreviousLink()));
//            } else if (cursor == size) {
//                current.getPreviousLink().setNextLink((current.getNextLink()));
//            } else {
//                current.getPreviousLink().setNextLink(current.getNextLink());
//                current.getNextLink().setPreviousLink(current.getPreviousLink());
//            }
//
//            size--;
//            lastRet--;
//            cursor = lastRet + 1;
//            REMOVED_MARK = true;
        }
    }

    protected class Link<E> {

        private E value;

        private Link<E> nextLink;

        private Link<E> previousLink;

        Link(E value) {
            this.value = value;
            nextLink = null;
            previousLink = null;
        }

        E getValue() {
            return value;
        }


        Link<E> getNextLink() {
            return nextLink;
        }

        void setNextLink(Link<E> nextLink) {
            this.nextLink = nextLink;
        }


        void setPreviousLink(Link<E> previousLink) {
            this.previousLink = previousLink;
        }

        Link<E> getPreviousLink() {
            return previousLink;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            E o = (E) obj;

            return this.equals(o);

        }

        public String toString() {
            return getClass().getName() + "@" + this.value.toString();
        }
    }
}
