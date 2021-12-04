package jin.node;

import java.util.Stack;

/**
 * 每个链表中的节点数在范围 [1, 100] 内
 * 位数为 100 位使用 int 无法满足需求
 *
 * 1.数字反序链表转字符串
 * 2.字符串相加
 * 3.字符串反序转链
 *
 * 链表的两数相加
 * 最后还是得回到字符版本的两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class TwoChainAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String numberA = chainToString(l1);   // 将链里的数字置换出来
        String numberB = chainToString(l2);

        String sum = stringSum(numberA, numberB);    // 求和

        String sumString = sum + "";
        StringBuilder builder = new StringBuilder(sumString);
        String reversedSum = builder.reverse().toString();

        ListNode sumNode = new ListNode();
        ListNode tmpHead = sumNode;

        for (int i = 0; i < reversedSum.length(); i++) {
            char currentChar = reversedSum.charAt(i);
            int currentNum = currentChar - 48;
            ListNode nextNode = new ListNode(currentNum);   // 以当前数字构造一个节点
            tmpHead.next = nextNode;    // 将新结点接到头结点尾部
            tmpHead = tmpHead.next;     // 更新尾节点
        }

        return sumNode.next;
    }

    public String chainToString(ListNode node) {

        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        StringBuilder builder = new StringBuilder();
        while (stack.size() != 0) {
            builder.append(stack.pop());
        }
        String theNumber = builder.toString();
        return theNumber;
    }

    public String stringSum(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;  // 为什么要求一个游标指着字符串的末尾呢? 模拟两数相加的书
        int currentAdd = 0;
        StringBuilder builder = new StringBuilder();

        while (indexA >= 0 || indexB >= 0 || currentAdd > 0) {
            int add1 = indexA >= 0 ? a.charAt(indexA) - 48 : 0;
            int add2 = indexB >= 0 ? b.charAt(indexB) - 48 : 0;
            int result = add1 + add2 + currentAdd;
            currentAdd = result / 10;   // 进位不清零
            result = result % 10;       // 进位取余数
            builder.append(result);
            indexA--;
            indexB--;   // 游标回退
        }


        // 个位数之和依次从左往后追加, 逆序才是对应的顺序
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        TwoChainAdd jonty = new TwoChainAdd();
        ListNode l1 = new ListNode(0);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        ListNode sumNode = jonty.addTwoNumbers(l1, l2);

        while (sumNode != null) {
            System.out.println(sumNode.val);
            sumNode = sumNode.next;
        }

    }
}
/**
 * 执行用时： 14 ms , 在所有 Java 提交中击败了 84.81% 的用户
 * */
