package se.stack;

/**
 * 链实条栈
 * */
public class ChainStack<Item> {
    private Node first; // 栈顶元素，最近添加的元素
    private int N;  // 数量
    private class Node {
        Item item;
        Node next;
    }
    // 子类
    public boolean isEmpty() {
        return N == 0 || first == null;
    }

    public void push(Item item) {
        Node oldFirst = this.first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        // 数量随之变化
        N++;
    }
    // push 往内置链表的开始位置增加一个节点

    public Item pop() {
        Item popped = first.item;    // 链头保存
        first = first.next;
        N--;    // 数量随之变化
        return popped;
    }

    public int size() {
        return N;
    }
}
