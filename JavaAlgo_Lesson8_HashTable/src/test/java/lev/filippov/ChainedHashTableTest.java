package lev.filippov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChainedHashTableTest {
    HashTable<Item, Integer> table;

    @BeforeEach
    @Test
    void addTest() {
        table = new ChainedHashTable<>(6);
        // System.out.println("Добавим 6 элементов");
        System.out.println(table.put(new Item(17, "Banana"), 130));
        System.out.println(table.put(new Item(28, "BigBon"), 60));
        System.out.println(table.put(new Item(66, "Tomato"), 190));
        System.out.println(table.put(new Item(14, "Corn"), 65));
        System.out.println(table.put(new Item(11, "Orange"),88 ));
        System.out.println(table.put(new Item(45, "Apple"), 80));
        table.display();

        Assertions.assertEquals(6, table.size());
        Assertions.assertEquals(65, table.getValue(new Item(14, "Corn")));;
        Assertions.assertEquals(130, table.getValue(new Item(17, "Banana")));
        Assertions.assertEquals(190, table.getValue(new Item(66, "Tomato")));
        Assertions.assertNull(table.getValue(new Item(33, "COVID-19")));

    }

    @Test
    void removeTest(){
        Assertions.assertEquals(65, table.getValue(new Item(14, "Corn")));;
        Assertions.assertTrue(table.remove(new Item(14, "Corn")));
        Assertions.assertNull(table.getValue(new Item(14, "Corn")));
        Assertions.assertEquals(5, table.size());
        Assertions.assertTrue(table.remove(new Item(17, "Banana")));
        Assertions.assertTrue(table.remove(new Item(28, "BigBon")));
        Assertions.assertTrue(table.remove(new Item(66, "Tomato")));
        Assertions.assertTrue(table.remove(new Item(11, "Orange")));
        Assertions.assertTrue(table.remove(new Item(45, "Apple")));
        Assertions.assertTrue(table.isEmpty());
        Assertions.assertFalse(table.remove(new Item(45, "Apple")));
    }

}
