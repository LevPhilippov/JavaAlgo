package lev.filippov;

public class DoubleHashTableImpl extends HashTableImpl {

    private final int constant;

    public DoubleHashTableImpl(int size) {
        super(size);
        constant = data.length-data.length/3;
    }

    @Override
    public int getValue(Item item) {
        return super.getValue(item);
    }

    @Override
    public int hash(Item item) {
        return constant - (super.hash(item)%constant);
    }

    @Override
    public boolean put(Item item, int price) {
        return super.put(item, price);
    }

    @Override
    public boolean remove(Item item) {
        return super.remove(item);
    }

}
