package lev.filippov;

public class Link <E> {

    private E element;

    private Link <E> nextLink;

    private Link <E> previousLink;

    public Link(E value) {
        element = value;
        nextLink = null;
        previousLink = null;
    }

    public E getElement() {
        return element;
    }

    public Link<E> getNextLink() {
        return nextLink;
    }

    public void setNextLink(Link<E> nextLink) {
        this.nextLink = nextLink;
    }

    public void setPreviousLink(Link<E> previousLink) {
        this.previousLink = previousLink;
    }

    public Link<E> getPreviousLink() {
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

        if (this.equals(o)) {
            return true;
        }

        return false;
    }

    public String toString() {
        return getClass().getName() + "@" + this.element.toString();
    }
}
