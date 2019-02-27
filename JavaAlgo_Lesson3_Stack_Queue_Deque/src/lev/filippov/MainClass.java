package lev.filippov;

public class MainClass {
    public static void main(String[] args) {
//    Brackets br1 = new Brackets();
//    br1.check("for (int i = 0; i <txt.length() ; i++)");
//        System.out.println(ReverseStringReader.read("Тестовое сообщение!"));

        Queue<Integer> queue = new Queue<Integer>(7){
            {
                push(1);
                push(2);
                push(3);
                push(4);
                push(5);
                push(6);
                push(7);
            }
        };

        System.out.println(queue.getSize());

//        for (int i = 0; i <j ; i++) {
//            System.out.println(queue.display());
//            System.out.println(queue.pop());
//        }
    }
}
