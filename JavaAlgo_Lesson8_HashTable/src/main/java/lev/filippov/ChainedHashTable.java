package lev.filippov;

import java.util.LinkedList;


public class ChainedHashTable<K,V> extends HashTableImpl<K,V>  {

    private Entry<K,V> [] data;

    public ChainedHashTable(int maxVolume) {
        data = new Entry [maxVolume];
    }

    @Override
    public int hashIndex(Object key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashIndex(key);
        Entry entry = new Entry(key, value);
        if (data[index] != null) {
            if(data[index].getKey().equals(key)){
                return false;
            }
            data[index].setNextEntry(entry);
        } else {
            data[index] = entry;
        }
        size++;
        return true;
    }

    @Override
    public V getValue(K key) {
        int index = indexOf(key);
        if(index == -1 || data[index] == null)
            return null;
        Entry temp = data[index];
        do {
            if(data[index].getKey().equals(key))
                return data[index].getValue();
        }
        while ((temp = temp.getNextEntry())!= null);
        return null ;
    }

    @Override
    protected int indexOf(K key) {
        int index = hashIndex(key);
        if(data[index] == null)
            return WRONG_INDEX;
        return index;
    }

    @Override
    public boolean remove(K key) {
        int index = indexOf(key);
        if(index == -1 || data[index] == null)
            return false;
        Entry temp = data[index];
        Entry previous=data[index];
        do {
            if(data[index].getKey().equals(key)) {
                if(data[index].getNextEntry() != null) {
                    if (previous != data[index]) {
                        previous.setNextEntry(data[index].getNextEntry());
                    }
                    data[index] = data[index].getNextEntry();
                } else {
                    data[index] = null;
                }
                size--;
                return true;
            }
            previous = data[index];
        }
        while ((temp = temp.getNextEntry())!= null);
        return false;
    }

    @Override
    public void display() {
        for (Entry<K, V> d : data) {
            for (Entry temp = d; temp != null; temp=temp.getNextEntry()) {
                System.out.print(temp + "  ");
            }
        }
    }
}
