package lev.filippov;
//
public class ReverseStringReader {
    Stack<Character> stack;

    public static String read (String msg){
        int msgLength = msg.length();
        Stack<Character> stack = new Stack<>(msgLength);
//        for (int i = 0; i < msgLength; i++) {
//            stack.push(msg.charAt(i));
//        }
        for (char o: msg.toCharArray()) {
            stack.push(o);
        }
        StringBuilder sb = new StringBuilder(msgLength);
        for (int i = 0; i <msgLength; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
