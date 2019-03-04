package lev.filippov;

import java.util.Random;
import java.util.function.Supplier;

public class MainApp {

    public static final int CAPACITY = 20000;
    public static void main(String[] args) {

        Supplier<MyArrayFuckingList<Integer>> supplier = MyArrayFuckingList::new;

        MyArrayFuckingList testList1 = supplier.get();
        MyArrayFuckingList testList2 = supplier.get();
        MyArrayFuckingList testList3 = supplier.get();

//        MyArrayFuckingList<Integer> testList1 = new MyArrayFuckingList<>(CAPACITY);
//        MyArrayFuckingList<Integer> testList2 = new MyArrayFuckingList<>(CAPACITY);
//        MyArrayFuckingList<Integer> testList3 = new MyArrayFuckingList<>(CAPACITY);

        Random rand = new Random(772);



        for (int i = 0; i < CAPACITY; i++) {
            int value = rand.nextInt(CAPACITY);
            testList1.add(value);
            testList2.add(value);
            testList3.add(value);
        }



        Function fBubble = testList1::bubbleSort;
        Function fInsert = testList2::insertSort;
        Function fSelect = testList3::selectSort;


        testing(fBubble, "Пузырек");
        testing(fInsert, "Вставка");
        testing(fSelect, "Выборка");

    }

    private static void testing(Function function, String sortType) {
        long start = System.currentTimeMillis();
        function.test();
        System.out.println("Время на сортировку  " + sortType + " " + Math.abs(start - System.currentTimeMillis()));
    }


}
