package lev.filippov;

import java.util.LinkedList;


public class ChainedHashTable extends HashTableImpl  {

    private LinkedList<Entry> [] data;

    public ChainedHashTable(int maxVolume) {
        data = new LinkedList[maxVolume];
    }

    @Override
    public int hash(Item item) {
        return item.hashCode()%data.length;
    }

    @Override
    public boolean put(Item item, int price) {
        int index = hash(item);
        Entry newEntry = new Entry(item, price);
        if (data[index]==null) {
            data[index] = new LinkedList<>();
        }
        size++;
        return data[index].add(new Entry(item,price));
    }

    @Override
    public boolean remove(Item item) {
        Entry temp = getEntry(item);
        if (item!= null){
            size--;
            return data[hash(item)].remove(temp);
        }
        return false;
    }

    private Entry getEntry(Item item) {
        int index = hash(item);
        for (Entry o: data[index]) {
            if (o.getItem().equals(item))
                return o;
        }
        return null;
    }

    @Override
    public int getValue(Item item) {
        return getEntry(item).getPrice();
    }

    @Override
    public void display() {
        for (LinkedList<Entry> datum : data) {
            for (Entry entry : datum) {
                System.out.println(entry);
            }

        }
    }

}
