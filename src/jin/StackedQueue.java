package jin;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * */
public class StackedQueue {
    Stack<Integer> left;
    Stack<Integer> right;

    public StackedQueue() {
        left = new Stack();
        right = new Stack();
    }

    public void push(int x) {
        while (left.isEmpty() != true) {
            right.push(left.pop());
        }
        left.push(x);
        while (right.isEmpty() != true) {
            left.push(right.pop());
        }
    }

    public int pop() {
        int toPop = left.pop();
        while (left.isEmpty() != true) {
            right.push(left.pop());
        }
        while (right.isEmpty() != true) {
            left.push(right.pop());
        }
        return toPop;
    }

    public int peek() {
        int leftPopped = left.pop();
        right.push(leftPopped);
        int peek = leftPopped;
        left.push(right.pop());     // 接受被 right 提前帮忙保管的方块
        return peek;
    }

    public boolean empty() {
        return left.size() == 0;
    }
}
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
