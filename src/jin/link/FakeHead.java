package jin.link;

import demo.link.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * reference：https://leetcode-cn.com/problems/remove-linked-list-elements/comments/4259
 * */
public class FakeHead {
    public ListNode removeElements(ListNode head, int val) {

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode tmpHead = fakeHead;
        while (tmpHead.next != null) {
            if (tmpHead.next.val == val) {
                tmpHead.next = tmpHead.next.next;
                // 每匹配一次(才)跳一次结点
            } else {
                // 正常
                tmpHead = tmpHead.next;
            }
        }
        return fakeHead.next;
    }

}
/**
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 96.31% 的用户
 * */