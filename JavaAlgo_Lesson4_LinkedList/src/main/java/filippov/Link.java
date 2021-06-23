package lev.filippov;

public class Link <E> {

    private E element;

    private Link <E> nextLink;

    private Link <E> previousLink;

    Link(E value) {
        element = value;
        nextLink = null;
        previousLink = null;
    }

    E getElement() {
        return element;
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
        return getClass().getName() + "@" + this.element.toString();
    }
}
