package se.node;

/**
 * 链表上的结点就像一个个引用
 * reference: alg4 1.3.3.2 构造链表
 * */
public class NodeChain {
    public static void main(String[] args) {
        Node head = new Node("to");
        Node second = new Node("be");
        head.next = second;
        Node third = new Node("or");
        second.next = third;    // 只用 second 拼接下一个域


        System.out.println("原链条：");
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
        // 将原来的链接上新结点后面
        head = first;
        // 此时，新节点为首的链恰好是满足的链
        System.out.println("看看链条有没有获得新的头节点：");
        Node tmpHead2 = head;
        while (tmpHead2 != null) {
            System.out.println(tmpHead2.item);
            tmpHead2 = tmpHead2.next;
        }

        /**
         * 删除链的开始节点(修改链的头节点)
         * */
        System.out.println("----------");
        System.out.println("看看链条去除头节点之后：");
        head = head.next;
        Node tmpHead3 = head;
        while (tmpHead3 != null) {
            System.out.println(tmpHead3.item);
            tmpHead3 = tmpHead3.next;
        }
    }
}
