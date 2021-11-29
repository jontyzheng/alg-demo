package se.bag;

import se.stack.ChainStack;

import java.util.Iterator;

/**
 * 链包：包里一条链(只进不出)
 * 链栈-出
 * */
public class ChainBag<Item> implements Iterable<Item> {
    private Node first; // 栈顶元素，最近添加的元素
    private int N;  // 数量

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new SubIterator();
    }

    private class SubIterator implements Iterator<Item> {

            private Node cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                Item item = cur.item;
                cur = cur.next; // next() 执行后节点也会移动一位
                return item;
            }

            @Override
            public void remove() {

            }
    }


    public void add(Item item) {
        Node oldFirst = this.first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        // 数量随之变化
        N++;
    }
}
