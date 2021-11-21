package jin.stck;

import java.util.Stack;

/**
 * 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 漫画法
 * 左左：左边一脸懵懵的小人
 * 右：右边看似高冷的小人
 * */
public class MyQueue {
    Stack<Integer> left;
    Stack<Integer> right;

    public MyQueue() {
        left = new Stack();
        right = new Stack();
    }

    public void push(int x) {
        while (left.isEmpty() != true) {
            right.push(left.pop()); // 左左 → 右
        }
        // 右："左左！来，先全部给我！" 左左："为什么呀？(一边这么想, 一边还是迷迷糊糊地都给了右)"
        left.push(x);
        // 右："左左！现在你去装那个新的" 左左：/不明所以，老老实实地去左边装货)
        while (right.isEmpty() != true) {
            left.push(right.pop()); // 右 ← 左左
        }
        // 右："来来来！刚才那些都给你！" 左左(懵懵的)："哦哦哦！好.."(一边装货ing...)
    }
    /**
     * 此时：
     * 左：(从上到下, 都是从新到旧的) "虽然从头到尾都是听右的，但我不是很明白它让我这么做的原因" // 一脸懵懵
     * 右：(空的) /一切尽在掌握之中
     * */

    public int pop() {
        int toPop = left.pop();         // 左左："在我这里!"(掏出最底下的)
        while (left.isEmpty() != true) {
            right.push(left.pop());     // 左左 → 右
        }
        // 右："嘿左左！现在把剩下的都给我" 左左："为什么呀？" 右："别管，让你给就给！拿来吧你！" 左左：/一脸懵懵(一边搬出方块ing...)
        while (right.isEmpty() != true) {
            left.push(right.pop());     // 左左 ← 右
        }
        // 右："都拿过来了是吧！来，现在一个不留全还你！(其实是为了让你保持队形/嘿嘿)" 左："哦哦好(一边装从右那边搬过来的方块)"
        return toPop;   // 给出左左一开始掏出的
    }
    /**
     * 此时：
     * 左左：(从上到下，依然是从新到旧的) /一脸懵懵
     * 右：(空的) /一切尽在掌握之中
     * */

    public int peek() {
        int leftPopped = left.pop();    // 右(指向左边)："别看我, 找它!"  左左：掏出
        right.push(leftPopped);         // 右："你牺牲了，不用怕，我来帮你保管一份一样的"
        int peek = leftPopped;          // 左左：损失一个
        left.push(right.pop());         // 左左(补血一个)："谢谢右，没想到，你其实很暖的嘛"
        return peek;
    }
    /**
     * 此时：
     * 左左：(从上到下，依然是从新到旧的) /一脸懵懵
     * 右：(空的) /一切尽在掌握之中
     * */

    public boolean empty() {
        return left.size() == 0;    // 右(指向左边)："看我干嘛，找它呀/一脸尽在掌握之中"
    }
}
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
