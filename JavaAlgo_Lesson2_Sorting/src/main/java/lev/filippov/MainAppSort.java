package lev.filippov;

import java.util.Arrays;

public class MainAppSort {

    public static void main(String[] args) {

    MyArrayFuckingList<Integer> list = new MyArrayFuckingList<Integer>(){
        {
            add(3);
            add(55);
            add(80);
            add(33);
            add(41);
            add(75);
            add(1);
            add(98);
            add(45);
            add(27);
            add(40);
        }
    };

    list.insertSort();
        System.out.println(list);

        System.out.println(list.getBynaryIndex(27));
    }


}
