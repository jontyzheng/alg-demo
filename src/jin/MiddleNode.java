package jin;

import jin.node.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * MiddleNode：
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        // 0 or 0 1
        if (head.next == null | head.next.next == null)
            return head;
        List<ListNode> list = new ArrayList<>();
        ListNode tmpHead = head;
        while (tmpHead!= null) {
            list.add(tmpHead);
            tmpHead = tmpHead.next;
        }
        int len = list.size();
        // 0 1 2
        // 0 1 3 4
        // 无论单数双数，取的 len/2 都是结果想要的位置
        // if (len % 2 != 0)
            return list.get(len / 2);
        // else
            // return list.get(len / 2 + 1);
    }
}
/**
 * 结果墙：
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 *
 * */
