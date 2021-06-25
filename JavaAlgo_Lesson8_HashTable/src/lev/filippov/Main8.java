package filippov.lev.filippov;

public class Main8 {
    public static void main(String[] args) {
        //SimpleAndDoubleHashTableTest();
        ChainedHashTableTest();


    }

    private static void ChainedHashTableTest() {
        HashTable chained = new ChainedHashTable(5);
        System.out.println("Добавим 6 элементов");
        System.out.println(chained.put(new Item(17, "Banana"), 130));
        System.out.println(chained.put(new Item(28, "BigBon"), 60));
        System.out.println(chained.put(new Item(66, "Tomato"), 190));
        System.out.println(chained.put(new Item(14, "Corn"), 65));
        System.out.println(chained.put(new Item(11, "Orange"),88 ));
        System.out.println(chained.put(new Item(45, "Apple"), 80));
        System.out.println(chained.size());

        System.out.println("Найдем стоимость элемента Apple с id=45");
        ((ChainedHashTable) chained).printValue(new Item(45, "Apple"));

        chained.display();

        System.out.println("Удалим элемент Apple с id=45");
        System.out.println(chained.remove(new Item(45, "Apple")));
        chained.display();
    }

    private static void SimpleAndDoubleHashTableTest() {

        HashTable table = new DoubleHashTableImpl(10);
        System.out.println("Добавим 6 элементов");

        System.out.println(table.put(new Item(17, "Banana"), 130));
        System.out.println(table.put(new Item(28, "BigBon"), 60));
        System.out.println(table.put(new Item(66, "Tomato"), 190));
        System.out.println(table.put(new Item(14, "Corn"), 65));
        System.out.println(table.put(new Item(11, "Orange"),88 ));
        System.out.println(table.put(new Item(45, "Apple"), 80));
        System.out.println(table.size());

        table.display();
        System.out.println("Найдем стоимость элемента Apple с id=45, Tomato с id-77, BigBon c id=28");

        ((HashTableImpl) table).printValue(new Item(77, "Tomato"));
        ((HashTableImpl) table).printValue(new Item(85, "Apple"));
        System.out.println("Удалим элемент BigBon c id=28");
        System.out.println(table.remove(new Item(28, "BigBon")));
        table.display();
    }
}
