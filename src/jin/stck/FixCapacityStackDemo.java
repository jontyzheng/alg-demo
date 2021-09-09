package jin.stck;

/**
 * FixCapacityStackDemo：
 */
public class FixCapacityStackDemo {
    public static void main(String[] args) {
        FixCapacityStack<Double> stack = new FixCapacityStack<Double>(10);
        stack.push(2.0);
        System.out.println(stack.pop());
    }
}
