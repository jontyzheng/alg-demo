package se.queue;

/**
 * 链队(FIFO)：队里一条链
 * */
public class ChainQueue<Item> {

    private Node head;
    private Node tail;  // 有多出一个尾引用
    private int N;

    // 私有类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // +~(- -) （后面进）
    public void in(Item newItem) {
        Node node = new Node();
        node.item = newItem;

        if (isEmpty()) {
            head = node;    // 空
            tail = head;    // 空
        }
        else {
            this.tail.next = node;
        }
        N++;
    }
    // in：链尾加个结点(如果里边原来不为空的) 为空的话新结点即head/tail

    // ~(- -)-O（前面出）
    public void out() {
        head = head.next;
    }
    // out：掐头

    public int size() {
        return N;
    }

    public String toString() {
        for (Node tmpHead = head; tmpHead != null; tmpHead = tmpHead.next) {
            System.out.println(tmpHead.item + " ");
        }
        return "123";
    }




}
