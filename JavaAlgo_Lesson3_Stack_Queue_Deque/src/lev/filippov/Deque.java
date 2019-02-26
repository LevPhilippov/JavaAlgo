package lev.filippov;
//Создать класс для реализации дека.

public class Deque<E> implements DequeInt<E> {

    public static final int MAX_SIZE = 16;
    public static final int FRONT = -1;
    public static final int REAR = 0;
    int front;
    int rear;
    int size;
    E data[];

    public Deque(int maxSize) {
        data = (E[])new Object[maxSize];
        front = FRONT;
        rear = REAR;
        size = 0;
    }

    public Deque() {
        this(MAX_SIZE);
    }

    @Override
    public void insertFront(E value) {
        if (isFull())
            throw new RuntimeException("Impossible to push new element - the stack is already full.");

        if(isEmpty()){
            front=0;
            rear=0;
        }

        else if (front==0)
            front = data.length-1;

        data[front] = value;
        size++;
    }

    @Override
    public E deleteFront() {
        getFront();
        //если остался последний элемент
        if (front == rear){
            E temp = data[front];
            rear = FRONT;
            front = FRONT;
            size--;
            return temp;
        }

        if (front == data.length-1) {
            E temp = data[front];
            front--;
            size--;
            return temp;
        }

        size--;
        return data[front++];
    }

    @Override
    public void insertRear(E value) {
        if (isFull())
            throw new RuntimeException("Impossible to push new element - the stack is already full.");

        if(isEmpty()){
            front=0;
            rear=0;
        }
        else if(rear == data.length-1)
            rear = REAR;
        else
            rear++;

        data[rear] = value;
        size++;
    }

    @Override
    public E deleteRear() {
        getRear();
        //последний элемент
        if (front==rear){
            E temp = data[rear];
            rear = FRONT;
            front = FRONT;
            size--;
            return temp;
        }
        if (rear == REAR) {
            size--;
            return data[(rear = data.length-1)];
        }

        size--;
        return data[rear--];
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw  new RuntimeException("Not possible to delete the element. The stack is already empty.");
        return data[front];
    }

    @Override
    public E getRear() {
        if (isEmpty())
            throw  new RuntimeException("Not possible to delete the element. The stack is already empty.");
        return data[rear];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return front == rear+1 || front==0 && rear==data.length-1;
    }

    public int getSize() {
        return size;
    }
}
