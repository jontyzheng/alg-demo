package se.node;


public class ChainTraverse {
    public static void main(String[] args) {
        Node head = new Node(1);
        //
        Node tmp = head;
        tmp.next = new Node(2);
        tmp.next.next = new Node(3);
        tmp.next.next.next = new Node(3);
        head = tmp;


        System.out.println("用for遍历的链：");
        for (Node x = head; x != null; x = x.next) {
            System.out.println(x.item + " ");
        }
        /**
         * for循环起点：临时结点 = 开始结点
         * 循环条件：当前结点不为空
         * 循环后变化：临时结点往后移动
         * */
    }
}
