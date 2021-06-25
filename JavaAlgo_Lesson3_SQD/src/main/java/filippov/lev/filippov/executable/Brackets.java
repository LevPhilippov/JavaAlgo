package filippov.lev.filippov.executable;

import filippov.lev.filippov.LionsStack;
import filippov.lev.filippov.interfaces.Stack;

public class Brackets {

    Stack<Character> stack;

    public Brackets () {
    }

    public void check (String txt) {
        stack = new LionsStack(txt.length());

        for (int i = 0; i <txt.length() ; i++) {
            switch (txt.charAt(i)) {
                case '(' :
                case  '{':
                case '[':
                    stack.push(txt.charAt(i));
                    break;

                case ')':
                case '}':
                case ']':
                    if (stack.peek() == '(' && txt.charAt(i) != ')'
                        || stack.peek() == '{' && txt.charAt(i) != '}'
                            || stack.peek() == '[' && txt.charAt(i) != ']')
                        throw new RuntimeException("Wrong bracket!");
                    stack.pop();
                    break;
                    default:
                        break;

            }
        }
        if (!stack.isEmpty()) {
            throw new RuntimeException("Missing open bracket!");
        }
    }
}
