package lev.filippov;

public class Node <E extends Comparable <? super E>> {

    //переменная для ограничения глубины пенетрации
    //метод депенетрации не реализован, т.к. нельзя войти в одну реку дважды:d

    private final E value;

    private Node<E> leftChild;
    private Node<E> rightChild;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean equals(Node<E> value) {
        return this.value.equals(value.getValue());
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    public boolean isLeftChild(Node<E> node) {
        return this.value.compareTo(node.getValue()) <0;
    }

}
