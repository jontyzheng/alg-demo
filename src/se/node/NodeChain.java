package se.node;

/**
 * 链表就像一个个引用
 * reference: alg4 1.3.3.2 构造链表
 * */
public class NodeChain {
    public static void main(String[] args) {
        Node head = new Node("to");
        Node second = new Node("be");
        head.next = second;
        Node third = new Node("or");
        second.next = third;    // 只用 second 拼接下一个域

        // 结果：head 输出了整条链
        Node tmpHead = head;
        while (tmpHead != null) {
            System.out.println(tmpHead.item);
            tmpHead = tmpHead.next;
        }

        System.out.println("----------");

        /**
         * 在头部加上一个结点
         * */
        Node oldHead = head;
        // (先将 head 保存在 oldHead 里面)
        Node first = new Node("not");
        // (构造一个新的结点 值为 not)
        first.next = oldHead;
        head = first;
        // 此时，新的头接上旧的身体，然后再提着新的头走
        System.out.println("看看链条有没有更新：");
        while (head != null) {
            System.out.println(head.item);
            head = head.next;
        }
    }
}
