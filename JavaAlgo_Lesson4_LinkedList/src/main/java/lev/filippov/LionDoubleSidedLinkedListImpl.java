package lev.filippov;

public class LionDoubleSidedLinkedListImpl<E> extends LionSimpleLinkedListImpl<E> implements LionDoubleSidedLinkedList <E> {

    protected Link <E> lastLink;

    @Override
    public void addLast(E value) {
        newLink = new Link<>(value);
        newLink.setPreviousLink(lastLink);

        if(!isEmpty()) { //если список уже содержит ссылку на lastLink
            lastLink.setNextLink(newLink);
        }
        lastLink = newLink;

        if (isEmpty()) { //если список пуст - присваиваем firstLink и lastLink одну и ту же ссылку
            firstLink = lastLink;
        }
        size++;
    }

    @Override
    public E getLast() {
        return lastLink.getElement();
    }

    @Override
    public E removeLast() {
        if(isEmpty()) {
            return null;
        }
        E temp = lastLink.getElement();
        lastLink = lastLink.getPreviousLink();

        if(lastLink!=null){
            lastLink.setNextLink(null);
        }
        size--;
        return temp;
    }

    @Override
    public void add(E value) {
        newLink = new Link<>(value);
        newLink.setNextLink(firstLink);

        if(!isEmpty()) { //если список уже содержит ссылку на firstLink
            firstLink.setPreviousLink(newLink);
        }

        firstLink = newLink;

        if(isEmpty()) { //если список пуст - присваиваем firstLink и lastLink одну и ту же ссылку
            lastLink = firstLink;
        }
        size++;

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

        if (current==lastLink){
            return removeLast();
        }

        current.getPreviousLink().setNextLink(current.getNextLink());
        current.getNextLink().setPreviousLink(current.getPreviousLink());

        size--;
        return current.getElement();
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
