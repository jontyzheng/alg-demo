package jin.stck;

import java.util.Scanner;

/**
 * FixCapacityStackOfStringDemo：( to  be  or  not  to  be  this  is  a  question )
 * 记录如何挨个输入一个句子，中间因为输错又是如何修改的
 */
public class FixCapacityStackOfStringDemo {
    public static void main(String[] args) {
        FixCapacityStackOfString stack = new FixCapacityStackOfString(10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("可以挨个输入一个个单词组成句子，输错的话按 - 弹出");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (!next.equals("-")) {
                stack.push(next);
                System.out.print("(");
                stack.inStack();
                System.out.println(")");
            } else if (!stack.hasEmpty()) {
                System.out.println(stack.pop());
            }
        }
    }
}
