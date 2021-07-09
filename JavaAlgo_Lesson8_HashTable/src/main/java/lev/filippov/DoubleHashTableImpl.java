package lev.filippov;

public class DoubleHashTableImpl<K,V> extends HashTableImpl<K,V> {

    private final int constant;

    public DoubleHashTableImpl(int size) {
        super(size);
        constant = data.length-data.length/3;
    }

    @Override
    protected int indexOf(K key) {
        int index = hashIndex(key);
        int shiftStep = getStepSize(key);
        int counter = 0;
        while (data[index] != null) {
            if (counter == data.length)
                return WRONG_INDEX;
            if (data[index].getKey().equals(key))
                break;
            index = index + shiftStep;
            if(index == data.length);
                index %= data.length;
            counter++;
        }
        return index;
    }

    @Override
    protected int getStepSize(K key) {
        return constant - super.hashIndex(key) % constant;
    }
}
