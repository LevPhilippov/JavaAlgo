package lev.filippov;

import lev.filippov.interfaces.Stack;

public class MainClass {
    public static void main(String[] args) {
//    Brackets br1 = new Brackets();
//    br1.check("for (int i = 0; i <txt.length() ; i++)");
//        System.out.println(ReverseStringReader.read("Тестовое сообщение!"));

//        LionsQueue<Integer> queue = new LionsQueue<Integer>(7){
//            {
//                push(1);
//                push(2);
//                push(3);
//                push(4);
//                push(5);
//                push(6);
//                push(7);
//            }
//        };
//
//        System.out.println(queue.getSize());

        Stack<Integer> stack = new LionsStack<>();
        stack.push(55);
        System.out.println(stack.getSize());
        System.out.println(stack.pop());

//        for (int i = 0; i <j ; i++) {
//            System.out.println(queue.display());
//            System.out.println(queue.pop());
//        }
    }
}
