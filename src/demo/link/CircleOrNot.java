package demo.link;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 环形链表
 * 看图+标记法
 * */
public class CircleOrNot {

    public boolean hasCycle(Node head) {
        if (head.next == null)
            return false;
        Node tmp = head;
        while (tmp.next != null) {
            // 看下一个节点的值是不是 10^6 是则说明走过了
            if (tmp.next.val == 1000000) {
                return true;
            } else {
                // 标记走过的点
                tmp.val = 1000000;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        //
        Node tmp = head;
        tmp.next = new Node(3);
        tmp.next.next = new Node(2);
        tmp.next.next.next = new Node(0);
        tmp.next.next.next.next = new Node(-4);
        tmp.next.next.next.next.next = new Node(tmp.next.next);
        CircleOrNot kid = new CircleOrNot();
        boolean res = kid.hasCycle(tmp);
        System.out.println(res);
    }
}
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
