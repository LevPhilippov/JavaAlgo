package lev.filippov;

import java.util.LinkedList;
import java.util.Objects;

public class Vertex<E> {

    private final E label;

    private Vertex<E> previous;

    private boolean isVisited;

    private LinkedList <Vertex<E>> previousLinks;

    public Vertex(E label) {
        this.label = label;
        isVisited = false;
        previousLinks = new LinkedList<Vertex<E>>();
    }

    public E getLabel() {
        return label;
    }

    public void visit() {
        isVisited = true;
    }

    public void unVisit() {
        isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Vertex<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex<E> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return label.toString();
    }

    public LinkedList<Vertex<E>> getPreviousLinks() {
        return previousLinks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
