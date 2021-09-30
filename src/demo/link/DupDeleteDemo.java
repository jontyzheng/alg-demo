package demo.link;

import java.util.List;

/**
 * DupDeleteDemo：
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现的数字。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DupDeleteDemo {
    static public ListNode deleteDuplicates(ListNode head) {
        if (head.next == null)
            return head;
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.next.val == cur.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;   // 去重
                }
            } else {
                cur = cur.next; // 正常
            }
        }
        return dummy.next;  // 坐收渔翁之利
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // 
        ListNode tmp = head;
        tmp.next = new ListNode(2);
        tmp.next.next = new ListNode(3);
        tmp.next.next.next = new ListNode(3);
        tmp.next.next.next.next = new ListNode(3);
        tmp.next.next.next.next.next = new ListNode(4);
        tmp.next.next.next.next.next.next = new ListNode(5);
        head = tmp;
        tmp = head;
        // [1,2,3,3,4,4,5]
        while (tmp.next != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println(tmp.val);
        System.out.println("==============");
        deleteDuplicates(head);
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
/**
 * 效果墙：官方题解 一次遍历
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
