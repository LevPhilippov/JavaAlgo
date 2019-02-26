package lev.filippov;

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
        dslist.display();
        //удаляем какой-нибудь существующий элемент
        dslist.remove(444);
        dslist.display();


    }
}
