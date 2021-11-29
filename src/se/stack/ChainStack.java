package se.stack;

/**
 * 链栈：栈里一条链
 |  头  |
 |  8   |
 |  8   |
 |  8   |
 |  |________(8)
 ——————
 * 出栈：摘掉链头
 * 入栈：延长链尾
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

    public Item peek() {
        return first.item;  // 访问链头
    }
    // peek 只瞄一眼链头 而不在出栈的位置摘掉节点

    public int size() {
        return N;
    }
}
