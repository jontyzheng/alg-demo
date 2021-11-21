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
        head = head.next;
        System.out.println("看看链条去除头节点之后：");
        Node tmpHead3 = head;
        while (tmpHead3 != null) {
            System.out.println(tmpHead3.item);
            tmpHead3 = tmpHead3.next;
        }

        /**
         * 在链的尾部接上一个结点
         * (首先需要获取链的最后一个结点的引用，然后将它指向一个新结点)
         * */
        System.out.println("----------");
        // 待拼接的新节点
        Node newLast = new Node("this");
        // 获取最后一个结点的引用
        // 拿一个假的开始结点过去获取
        Node tmpHead5 = head;
        while (tmpHead5.next != null) {
            tmpHead5 = tmpHead5.next;
        }
        tmpHead5.next = newLast;
        // 将新的结点接上链尾
        System.out.println("给链条的链尾接上一个新结点之后：");
        Node tmpHead6 = head;   // 原 head 不变(提前让一个临时开始结点去获取链尾的好处)
        while (tmpHead6 != null) {
            System.out.println(tmpHead6.item);
            tmpHead6 = tmpHead6.next;
        }
        // 由于遍历链获取引用是通过不断修改链头的引用而实现的，所以在获取链尾的引用时要保证不修改原来 head 的引用
        // (head的引用需要一直指着原链首，以用于输出)
    }
}
