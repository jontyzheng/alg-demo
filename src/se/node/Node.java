package se.node;

public class Node {

    Object item;
    Node next;

    Node(Node newNode) {
        this.next = newNode;
    }

    Node(Object val) {
        this.item = val;
    }

}
