package lev.filippov;
//Создать класс для реализации дека.

public class Deque<E> extends Queue<E> implements DequeInt<E>  {

    public Deque(int maxSize) {
        super(maxSize);
    }

    public Deque () {
        this(MAX_SIZE);
    }

    @Override
    public void insertLeft(E value) {
        super.push(value);

//        if (isFull())
//            throw new RuntimeException("Impossible to push new element - the stack is already full.");
//
//        if(isEmpty()){
//            front=0;
//            end=0;
//        }
//
//        else if (front==0)
//            front = data.length-1;
//
//        data[front] = value;
//        size++;
    }

    @Override
    public E deleteLeft() {
        return super.pop();
//        getFront();
//        //если остался последний элемент
//        if (front == end){
//            E temp = data[front];
//            end = FRONT;
//            front = FRONT;
//            size--;
//            return temp;
//        }
//
//        if (front == data.length-1) {
//            E temp = data[front];
//            front--;
//            size--;
//            return temp;
//        }
//
//        size--;
//        return data[front++];
    }

    @Override
    public void insertRight(E value) {
        if(isFull()){
            throw new RuntimeException();
        }
        if(front==0){
            front = data.length;
        }

        data[--front] = value;
        size++;

//        if (isFull())
//            throw new RuntimeException("Impossible to push new element - the stack is already full.");
//
//        if(isEmpty()){
//            front=0;
//            end =0;
//        }
//        else if(end == data.length-1)
//            end = END;
//        else
//            end++;
//
//        data[end] = value;
//        size++;
    }

    @Override
    public E deleteRight() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        size--;

        if(end==END){
            end=data.length-1;
        }

        return data[end--];
//        getEnd();
//        //последний элемент
//        if (front== end){
//            E temp = data[end];
//            end = FRONT;
//            front = FRONT;
//            size--;
//            return temp;
//        }
//        if (end == END) {
//            size--;
//            return data[(end = data.length-1)];
//        }
//
//        size--;
//        return data[end--];
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw  new RuntimeException("The stack is empty.");
        return data[front];
    }

    @Override
    public E getEnd() {
        if (isEmpty())
            throw  new RuntimeException("The stack is empty.");
        return data[end];
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    public int getSize() {
        return size;
    }
}
