package lev.filippov;
//
public class ReverseStringReader {
    Stack<Character> stack;

    public static String read (String msg){
        int msgLength = msg.length();
        Stack<Character> stack = new Stack<>(msgLength);

        for (char o: msg.toCharArray()) {
            stack.push(o);
        }
        StringBuilder sb = new StringBuilder(msgLength);

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
