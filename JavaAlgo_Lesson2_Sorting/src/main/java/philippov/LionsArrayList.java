package philippov;


import java.util.Arrays;
import java.util.Comparator;

public class LionsArrayList<E> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 16;
    public static final int WRONG_INDEX = -1;
    protected volatile int CURRENT_SIZE;
    protected volatile E[] data;

    public LionsArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.CURRENT_SIZE = 0;
    }

    public LionsArrayList() {
        this(DEFAULT_CAPACITY);
    }


    public void add(E value) {
        ensure_capasity();
        data[CURRENT_SIZE] = value;
        CURRENT_SIZE++;
    }

    protected void ensure_capasity() {
        if (data.length == CURRENT_SIZE) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public int getIndex(E value) {
        for (int i = 0; i < CURRENT_SIZE; i++) {
            if (data[i].equals(value))
                return i;
        }
        return WRONG_INDEX;
    }




    public boolean remove(E value) {
        return remove(getIndex(value));
    }

    public boolean remove(int index) {
        if (index > data.length-1)
            throw new ArrayIndexOutOfBoundsException();
        if (CURRENT_SIZE > 0 && index >= 0 && index< data.length) {
            for (int i = index; i < CURRENT_SIZE-1; i++) {
                data[i] = data[i + 1];
            }
            data[--CURRENT_SIZE] = null;
            return true;
        }
        else return false;
    }

    public boolean contains(E value) {
        return getIndex(value) != -1;
    }

    public E get(int index) {
        return data[index];
    }


    public int size() {
        return CURRENT_SIZE;
    }

    public void bubbleSort(Comparator<? super E> comparator) {
        for (int i = 0; i < CURRENT_SIZE - 1; i++) {
            for (int j = 0; j < CURRENT_SIZE - i - 1; j++) {
                if (comparator.compare(data[j],data[j + 1])>0)
                    change(j, j + 1);
            }
        }

    }

    public void selectSort(Comparator<? super E> comparator) {
        int minIndex;
        for (int i = 0; i < CURRENT_SIZE; i++) {
            minIndex = i;
            for (int j = i + 1; j < CURRENT_SIZE; j++) {
                if (comparator.compare(data[j],data[minIndex])< 0)
                    minIndex = j;
            }
            change(i, minIndex);
        }
    }

    public void insertSort(Comparator<? super E> comparator) {
        for (int i = 1; i < CURRENT_SIZE; i++) {
            E temp = data[i];
            int iter = i;
            while (iter > 0 && comparator.compare(data[iter - 1],temp)>=0) {
                data[iter] = data[iter - 1];
                iter--;
            }
            data[iter] = temp;
        }
    }


    private void change(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}

