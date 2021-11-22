package jin;

import demo.link.Node;

public class ChainReverse {

    public Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node reHead = new Node(0);  // 构造反链的开始结点

        reHead = head;    // 反链
        int reHeadVal = reHead.val;
        Node tmpReHead = reHead;   // tmp反链
        int tmpReHeadVal = tmpReHead.val;
        Node tmpHead = head;       // tmp原链
        int tmpHeadVal = tmpHead.val;   // tmp原链

        /**
         * cur：当前结点，每次都是一个新的引用，指向 tmpHead.next
         * tmpHead：指向原结点 初始值：原head.next
         * tmpReHead：指向反链 初始值：反链的.next
         * */
        // tmpHead = tmpHead.next;
        // 以tmpHead.next 为对象
        while (tmpHead != null) {
            // (在反链的表头增加一个头结点)
            /**
             * newHead：
             * */
            Node cur = tmpHead.next;              // 当前对象
            int curVal = cur.val;            // 当前结点
            int tmpHeadVal1 = tmpHead.val;   // 反链的头
            cur.next = tmpHead;              // 接

            tmpReHead = cur;
            int tmpHeadVal2 = tmpReHead.val;   // 反链新头
            int reHeadNextV = tmpReHead.next.val;    // 反链新头的下一位

            tmpHead = tmpHead.next;          // 当前结点移动
            int tmpHeadVal3 = tmpHead.next.val;   // 当前结点

            Node newTmpHead = tmpReHead;
            tmpReHead = newTmpHead;
            cur = cur.next;
            int curVal3= cur.val;
            // tmpReHead = tmpReHead.next;      // 反链新头的移动
            int tmpReHeadVal3 = tmpReHead.val;
            int tmpReHeadVal2 = tmpHead.next.val;   // 当前结点
            int tmpReHeadVal4 = tmpHead.next.val;   // 当前结点

        }
        return reHead;
    }

    public Node reverseListReference(Node head) {
        Node prev = null;   // 前指针结点 ▲ (null <- 1 <- 2 <- 3 <- 4)

        while (head != null) {
            Node nextTmp = head.next; // “构造新结点” (这里即当前结点)
            head.next = prev; // 将原链接到新结点后面 ? 
            // (反过来 之前接头结点修改的是新结点.next； 现在的修改对象是原链的.next
            prev  = head;  // 前指针后移 ? (每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移)
            head = nextTmp; // 当前指针后移 ? (往后靠 此时 head.next 指着的还是往前方向的前面那个)
        }
        return prev;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        ChainReverse kid = new ChainReverse();
        Node prev = kid.reverseListReference(head);

        System.out.println("原链条：");
        // 结果：head 输出了整条链
        Node tmpHead = prev;
        while (tmpHead != null) {
            System.out.println(tmpHead.val);
            tmpHead = tmpHead.next;
        }

    }
}
