package lev.filippov;

public class LionSimpleLinkedListImpl<E> implements LionSimpleLinkedList<E> {

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

    private Link <E> find(E value) {

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
        firstLink.getNextLink().setPreviousLink(null);
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
}
