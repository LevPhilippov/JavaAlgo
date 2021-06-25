package filippov.lev;

public class DoubleSidedLionsLinkedList<E> extends LionsLinkedList<E> implements DoubleSidedLinkedList<E> {

    private Link <E> lastLink;

    @Override
    public void add(E value) {
        super.add(value);
        if(size==1) {lastLink=firstLink;}
    }

    @Override
    public void addLast(E value) {
        newLink = new Link(value);
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
        if(lastLink == null) return null;
        return lastLink.getValue();
    }

    @Override
    public E removeLast() {
        if(isEmpty()) {
            return null;
        }
        E temp = lastLink.getValue();
        lastLink = lastLink.getPreviousLink();

        if(lastLink!=null){
            lastLink.setNextLink(null);
        } else {firstLink=null;}
        size--;
        return temp;
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
        return current.getValue();
    }

    @Override
    public E removeFirst() {
        E value= super.removeFirst();
        if (size==0) lastLink = null;
        return value;


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
