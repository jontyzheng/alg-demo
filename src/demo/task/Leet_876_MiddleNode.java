package demo.task;

import jin.node.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Leet_876_MiddleNode：给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Leet_876_MiddleNode {

    public ListNode middleNode(ListNode head) {
        // 0 or 0 1
        if (head.next == null)
            return head;
        if (head.next.next == null)
            return head.next;
        List<ListNode> list = new ArrayList<>();
        ListNode tmpHead = head;
        while (tmpHead != null) {
            list.add(tmpHead);
            tmpHead = tmpHead.next;
        }
        int len = list.size();
        // 0 1 2
        // 0 1 3 4
        // 无论单数双数，取的 len/2 刚好都是结果想要的位置
        // if (len % 2 != 0)
        return list.get(len / 2);
        // else
        // return list.get(len / 2 + 1);
    }
}
/**
 * 结果墙：
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 */