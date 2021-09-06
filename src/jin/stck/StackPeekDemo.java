package jin.stck;

import java.util.Stack;

/**
 * StackPeekDemo：无损查看
 */
public class StackPeekDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println("stack：");
        for (String s:
             stack) {
            System.out.print(s + " ");
        }
    }
}
