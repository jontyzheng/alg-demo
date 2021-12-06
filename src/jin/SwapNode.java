package jin;

import jin.node.ListNode;

/**
 * 两两交换链的结点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * */
public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;

        ListNode preNode = dumpHead;
        ListNode tmpHead = preNode.next;    // a
        ListNode tmpNext = tmpHead.next;    // b
        ListNode tmpTail = null;            // c

        while (tmpHead != null && tmpNext != null) {
            tmpTail = tmpNext.next;     // 尾链
            tmpNext.next = tmpHead;     // 前后反转
            tmpHead.next = tmpTail;     // 原头接尾

            preNode.next = tmpNext;     // 原副座 换人上任
            preNode = tmpHead;          // 原一把手更新

            tmpHead = tmpHead.next;     // 新二把手开始

            if (tmpHead != null) {
                tmpNext = tmpHead.next;  // 新二把手的下一任
            }

        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        SwapNode jonty = new SwapNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode resChain = jonty.swapPairs(head);
        resChain.print(resChain);
    }
}
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * Ref：https://leetcode-cn.com/problems/swap-nodes-in-pairs/comments/1268597
 * */
