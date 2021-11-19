package se.node;

/**
 * 链表就像一个个引用
 * */
public class NodeChain {
    public static void main(String[] args) {
        Node head = new Node("to");
        Node second = new Node("be");
        head.next = second;
        Node third = new Node("or");
        second.next = third;    // 只用 second 拼接下一个域

        // 结果：head 输出了整条链
        while (head != null) {
            System.out.println(head.item);
            head = head.next;
        }


    }
}
