package lev.filippov;


public class HashTableImpl implements HashTable {

    protected int maxVolume;
    protected int size;
    protected Entry[] data;



    public static class Entry {
        private Item item;
        private int price;

        public Entry(Item item, int price) {
            this.item = item;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "item=" + item +
                    ", price=" + price +
                    '}';
        }

        public Item getItem() {
            return item;
        }

        public int getPrice() {
            return price;
        }
    }

    public HashTableImpl(){
    }

    public HashTableImpl(int maxVolume) {
        this.maxVolume = maxVolume;
        data = new Entry[this.maxVolume *2];
    }

    @Override
    public int hash(Item item) {   //работает
        return item.hashCode() % data.length;
    }

    @Override
    public boolean put(Item item, int price) {  //работает
        int index = indexOf(item);
        if(index == -1)
            return false;
        data[index] = new Entry(item, price);
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1 || data[index]==null)
            return false;
        data[index] = null;
        size--;
        return true;
    }


    @Override
    public int getValue(Item item) {
        int index = indexOf(item);
        if (index == -1 || data[index]==null)
            return -1;
        return data[index].price;
    }

    private int indexOf(Item item) {
        int index = hash(item);
        int roundCounter=0;
        while (data[index] != null) {
            if (roundCounter==data.length)
                return -1;
            if (data[index].item.equals(item))
                break;
            index++;
            index %= data.length;
            roundCounter++;
        }
        return index;
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

    public void printValue(Item item) {
        System.out.println(String.format("Стоимость %s равна %d", item.getName(), getValue(item)));
    }
}
