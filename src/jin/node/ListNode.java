package jin.node;

/**
 * ListNode：
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(ListNode node) {
        ListNode tmpHead = node;
        while (tmpHead != null) {
            if (tmpHead.next != null) {
                System.out.print(tmpHead.val + "--");
            } else {
                System.out.print(tmpHead.val);
            }
            tmpHead = tmpHead.next;
        }
    }


}
