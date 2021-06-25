import philippov.LionsArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortingTest {

    volatile LionsArrayList<Integer> testList;
    volatile ArrayList<Integer> sortedList;
    Comparator<Integer> comparator=Integer::compareTo;

    @BeforeEach
    void createList() {
        Random random = new Random();
        Integer randValue;
        testList = new LionsArrayList<>();
        sortedList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            randValue=random.nextInt(100000);
            testList.add(randValue);
            sortedList.add(randValue);
        }
        sortedList.sort(comparator);
    }

    @Test
    void bubbleSortingTest() {
        System.out.println("-----Начало тестирования-----");
        Long startTime = System.currentTimeMillis();
        testList.bubbleSort(comparator);
        Long finisTime = System.currentTimeMillis();
        System.out.printf("Время сортировки пузырьком: %d миллисекунд\n", (finisTime-startTime));
        for (int i = 0; i < testList.size(); i++) {
            Assertions.assertEquals(testList.get(i), sortedList.get(i));
        }
    }

    @Test
    void insertSortingTest() {
        System.out.println("-----Начало тестирования-----");
        Long startTime = System.currentTimeMillis();
        testList.insertSort(comparator);
        Long finisTime = System.currentTimeMillis();
        System.out.printf("Время сортировки вставкой: %d миллисекунд\n", (finisTime-startTime));

        for (int i = 0; i < testList.size(); i++) {
            Assertions.assertEquals(testList.get(i), sortedList.get(i));
        }

    }

    @Test
    void selectSortingTest() {
        System.out.println("-----Начало тестирования-----");
        Long startTime = System.currentTimeMillis();
        testList.selectSort(comparator);
        Long finisTime = System.currentTimeMillis();
        System.out.printf("Время сортировки выборкой: %d миллисекунд\n", (finisTime-startTime));

        for (int i = 0; i < testList.size(); i++) {
            Assertions.assertEquals(testList.get(i), sortedList.get(i));
        }

    }
}
