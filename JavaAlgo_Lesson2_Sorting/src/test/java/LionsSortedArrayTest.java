import lev.filippov.Array;
import lev.filippov.LionsArrayList;
import lev.filippov.LionsSortedArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class LionsSortedArrayTest {
    Array<Integer> testArray;
    ArrayList<Integer> sortedArray = new ArrayList<>();
    volatile Integer random;

    @Test
    void addTest() throws InterruptedException {
        testArray = new LionsSortedArrayList<>();

//        //1925 5235 85 1728 94
//        testArray.add(1925);
//        testArray.add(5235);
//        testArray.add(85);
//        testArray.add(1728);
//        testArray.add(94);
//
        for (int i = 0; i < 20000; i++) {
           random  = new Random().nextInt(10000);
//            System.out.print(random + " ");
            testArray.add(random);
            sortedArray.add(random);
            sortedArray.sort(Integer::compareTo);
        }
//        System.out.println("\n" + testArray);

        for (int i = 0; i < sortedArray.size(); i++) {
            Assertions.assertEquals(sortedArray.get(i), testArray.get(i));
        }
    }
}

