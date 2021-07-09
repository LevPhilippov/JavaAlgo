package lev.filippov;


public class HashTableImpl<K extends  Object,V extends Object> implements HashTable<K , V> {

    public static final int WRONG_INDEX = -1;
    protected int maxVolume;
    protected int size;
    protected Entry<K,V>[] data;



    protected static class Entry<K,V> {
        private K key;
        private V value;
        private Entry nextEntry;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry getNextEntry() {
            return nextEntry;
        }

        public void setNextEntry(Entry nextEntry) {
            this.nextEntry = nextEntry;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    protected HashTableImpl() {
    }

    public HashTableImpl(int maxVolume) {
        this.maxVolume = maxVolume;
        data = new Entry [this.maxVolume *2];
    }

    @Override
    public int hashIndex(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = indexOf(key);
        if(index == -1)
            return false;
        data[index] = new Entry(key, value);
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean remove(K key) {
        int index = indexOf(key);
        if (index == - 1 || data[index] == null)
            return false;
        data[index] = null;
        size--;
        return true;
    }

    @Override
    public V getValue(K key) {
        int index = indexOf(key);
        if (index == -1 || data[index]==null)
            return null;
        return data[index].value;
    }

    protected int indexOf(K key) {
        int index = hashIndex(key);
        int roundCounter=0;
        int stepSize = getStepSize(key);
        while (data[index] != null) {
            if (roundCounter == data.length)
                return WRONG_INDEX;
            if (data[index].key.equals(key))
                break;
            index+=stepSize;
            roundCounter++;
            if (index == data.length)
                index %= data.length;
        }
        return index;
    }

    protected int getStepSize(K key) {
        return 1;
    }

    @Override
    public void display() {   //работает
        System.out.println("---------------");
        for (int i = 0; i <data.length ; i++) {
            System.out.println(data[i]);
        }
        System.out.println("---------------");
    }

    @Override
    public int size() {
        return size;
    }



}
