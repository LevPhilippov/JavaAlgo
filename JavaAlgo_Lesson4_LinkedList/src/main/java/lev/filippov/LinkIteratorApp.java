package lev.filippov;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkIteratorApp {
    static List<Integer> list;

    public static void main(String[] args) {

        list = new LinkedList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
                add(8);
                add(9);
                add(0);
            }
        };
        System.out.println("--------------------");
        for (Integer o:list) {
            System.out.println(o);
        }
        System.out.println("--------------------");

        ListIterator<Integer> iterator =  list.listIterator();

        //cursor 0
            System.out.println(iterator.next());//print 0 cursor 1
            System.out.println(iterator.next());//print 1 cursor 2
            System.out.println(iterator.next());//print 2 cursor 3
            iterator.add(777);                      //add on cursor 3 cursor 4
            System.out.println(iterator.next());//print 4 cursor 5
            System.out.println(iterator.previous());//print 4 cursor 3
            System.out.println(iterator.previous());//print 3 cursor 2
            iterator.set(555); //cursor 2 change value to 555
            System.out.println(iterator.next());//print 3 cursor 4
        System.out.println("IndexN " + iterator.nextIndex()); //shows cursor position in case of next()
            iterator.remove(); // removes element on last position before next or previous (element on cursor 2), now cursor pos is  3
        System.out.println("IndexN " + iterator.nextIndex());
            System.out.println(iterator.next());//print 3 cursor 4
        System.out.println("IndexN " + iterator.nextIndex());
        System.out.println("IndexP " + iterator.previousIndex()); // shows cursor pos in case of previous()
        System.out.println(iterator.previous());//print 3 cursor 2
        System.out.println("IndexP " + iterator.previousIndex()); // shows cursor pos in case of previous()
        System.out.println(iterator.previous());//print 2 cursor 1
        System.out.println("IndexP " + iterator.previousIndex());
        System.out.println(iterator.previous());//print 1 cursor 0
        System.out.println("IndexP " + iterator.previousIndex());
        System.out.println(iterator.previous());//print 0 cursor -1
    }

}
