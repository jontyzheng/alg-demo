package jin.stck;

import java.util.Scanner;
import java.util.Stack;

//
public class ReverseCase {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        //
        System.out.println("请在控制台输入 5 个整数：");
        // 往栈里塞元素
        int i = 0;
        while (i < 5) {
            int i1 = scanner.nextInt();
            stack.push(i1);
            i++;
        }
        System.out.println(stack.size());
        System.out.println("栈依次有");
        // 输出栈里的元素
        for (int k = 0; k < 5; k++) {
            System.out.print(stack.pop() + " ");
        }
        // 注：该循环体只会执行 3 次
    }
}
