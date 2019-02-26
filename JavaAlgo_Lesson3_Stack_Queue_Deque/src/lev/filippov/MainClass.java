package lev.filippov;

public class MainClass {
    public static void main(String[] args) {
//    Brackets br1 = new Brackets();
//    br1.check("for (int i = 0; i <txt.length() ; i++)");
        System.out.println(ReverseStringReader.read("Тестовое сообщение!"))   ;

        Deque<Integer> deq = new Deque<>(5);

        deq.insertFront(0);
        deq.insertFront(1);
        deq.insertRear(2);
        deq.insertFront(4);
        deq.insertRear(5);
        System.out.println(deq.getRear());
        deq.deleteRear();
        System.out.println(deq.getRear());
        deq.deleteRear();
        System.out.println(deq.getRear());
        deq.deleteRear();
        System.out.println(deq.getRear());
        deq.deleteRear();
        deq.deleteRear();
//        System.out.println(deq.getRear());
//        deq.deleteRear();
//        deq.deleteRear();


    }
}
