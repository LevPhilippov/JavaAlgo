package lev.filippov;

import java.util.Iterator;

public class MainApp {

    public static final int WRONG_VALUE = 777;

    public static void main(String[] args) {
        LionSimpleLinkedListImpl<Integer> sslist = new LionSimpleLinkedListImpl(){
            {
                add(1);
                add(333);
                add(1);
                add(2);
                add(3);
                add(5);
                add(7);
                add(12);
            }
        };
        //show all the elements
        sslist.display();
        //delete the first
        sslist.removeFirst();
        sslist.display();
        //delete selected
        sslist.remove(333);
        sslist.display();
        //delete wrong value
        System.out.println(sslist.remove(WRONG_VALUE));
        sslist.display();

        LionDoubleSidedLinkedListImpl<Integer> dslist = new LionDoubleSidedLinkedListImpl(){
            {
                add(33);
                addLast(222);
                addLast(444);
                add(3);
                add(5);
                addLast(666);
                add(12);

            }
        };

        dslist.display();   //ура, починил!!!!
        //удаляем первый элемент
        dslist.removeFirst();
        dslist.display();
        //удаляем последний элемент
        dslist.removeLast();

        dslist.display();
        //удаляем какой-нибудь существующий элемент
        dslist.remove(444);
        dslist.display();

        LionSimpleLinkedListImpl<Integer> forEachTst = new LionSimpleLinkedListImpl<Integer>(){{
           add(1);
           add(2);
           add(3);
           add(4);
           add(5);
        }};



        Iterator<Integer> listIter = forEachTst.iterator();
        printListThroughForEach(forEachTst);
        System.out.println(listIter.next());
        printListThroughForEach(forEachTst);
        System.out.println(listIter.next());
        listIter.remove();
        printListThroughForEach(forEachTst);

        Iterator<Integer> listIter2 = new LionSimpleLinkedListImpl<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }}.iterator();

        while (listIter2.hasNext()) {
            System.out.print(listIter2.next());
        }

    }

    private static  <E> void printListThroughForEach(LionSimpleLinkedListImpl<E> list ) {
        System.out.println("----------------------");
        for (E o: list){
            System.out.print(o);
        }
        System.out.println("\n----------------------");
    }
}
