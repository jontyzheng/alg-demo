package se.node;

/**
 * 链栈：栈里一条链
 * */
public class ChainStack<Item> {
    private Node first; // 栈顶元素，最近添加的元素
    private int N;  // 数量
    private class Node {
        Item item;
        Node next;
    }
    // 内部定义的数据结构
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
    // push 往链尾增加一个结点(入队的地方)

    public Item pop() {
        Item popped = first.item;    // 链头保存
        first = first.next;
        N--;    // 数量随之变化
        return popped;
    }
    // pop 从链首摘掉一个结点(出队的地方)

    public int size() {
        return N;
    }
}
