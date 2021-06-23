package lev.filippov;
//
public class ReverseStringReader {
    LionsStack<Character> stack;

    public static String read (String msg){
        int msgLength = msg.length();
        LionsStack<Character> stack = new LionsStack<>(msgLength);

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
