package filippov.lev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


public class LionsListTest {
    public static final int SIZE = 1000;
    LionsLinkedList<Integer> testlist;
    public final static int WRONG = 777;
    Integer randomValue;

    @BeforeEach
    @Test
    public void addAndIteratorTest() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        testlist = new LionsLinkedList();
        for (int i = 0; i < SIZE; i++) {
            int value = random.nextInt(1000000);
            testlist.add(value);
            list.add(value);
            if (i==SIZE/3)
                randomValue=value;
        }
        Assertions.assertEquals(SIZE, testlist.getSize());

        int index=list.size()-1;
        for (Integer integer : testlist) {
            Assertions.assertEquals(list.get(index), integer);
            index--;
        }

    }

        @Test
        public void removeRandomTest() {
            Assertions.assertNotNull(testlist.find(randomValue));
            testlist.remove(randomValue);
            Assertions.assertNull(testlist.find(randomValue));
        }

        @Test
        public void removeHeadTest() {
            Integer i = testlist.getFirst();
            Assertions.assertEquals(i, testlist.removeFirst());
            Assertions.assertNull(testlist.find(i));
        }

        @Test
        public void removeFromEmptyList() {
            LionsLinkedList<Integer> testlist = new LionsLinkedList<>();
            Assertions.assertNull(testlist.remove(1));
        }

    @Test
    public void removeAllFromList() {
        while (testlist.size != 0) {
            testlist.removeFirst();
        }
        Assertions.assertNull(testlist.getFirst());
    }

    @Test
    void doubleRemoveIteratorTest() {
        LionsLinkedList<Integer> testlist= new LionsLinkedList<>();
              testlist.add(1);
              testlist.add(2);
              testlist.add(3);

        Assertions.assertEquals(3, testlist.getSize());
        Iterator<Integer> iterator = testlist.iterator();
        Assertions.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assertions.assertThrows(IllegalStateException.class, () -> iterator.remove());

        Assertions.assertEquals(2, testlist.getSize());
    }


    }
