package jin.stck;

/**
 * FixCapacityStackDemo：Item 的应用
 */
public class FixCapacityStackDemo {
    public static void main(String[] args) {
        FixCapacityStack<Double> stack = new FixCapacityStack<Double>(10);
        stack.push(2.0);
        System.out.println(stack.pop());

        FixCapacityStack<Boolean> stack2 = new FixCapacityStack<>(10);
        stack2.push(true);
        System.out.println(stack2.pop());

        // 容量测试
        for (int i = 0; i < 11; i++) {
            stack2.push(true);
        }
        stack2.inStack();
        // 在 push() 中加上一行程序后就不再报错了
    }
}
