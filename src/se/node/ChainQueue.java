package se.node;

/**
 * 链队
 * */
public class ChainQueue<Item> {

    private Node head;
    private Node tail;
    private int N;

    // 私有类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // +~(- -) （从后面进去）
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

    // ~(- -)-O（从前面出来）
    public void out() {
        head = head.next;
    }

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
