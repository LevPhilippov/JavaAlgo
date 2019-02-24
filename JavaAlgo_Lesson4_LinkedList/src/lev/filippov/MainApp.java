package lev.filippov;

public class MainApp {

    public static final int WRONG_VALUE = 777;

    public static void main(String[] args) {
        LionSimpleLinkedListImpl<Integer> list = new LionSimpleLinkedListImpl(){
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
        list.display();
        //delete the first
        list.removeFirst();
        list.display();
        //delete selected
        list.remove(333);
        list.display();
        //delete wrong value
        System.out.println(list.remove(WRONG_VALUE));
        list.display();

    }
}
