package jin.node;

import java.util.Stack;

/**
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * 可切入的求法
 * 十分直观：
 * 数字倒着写, 求和时自然需要将数组反过来 反过来自然而然, 派上栈
 * 接着将两个数字求和, 然后再倒着塞回去, 整个链回去
 *
 * 遇到的问题
 * 链里的一个位表示一个位, 链的长度又在 [0, 100] 之间, 那 Integer 显然不行
 * 64 位的内存只能存放最大 2^31-1 也才 21 亿多(2147_483648) 换算位数的话也只能表示 14 位
 * 所以自然而然, 需要用字符串版的加法(字符串可以表示任意长度的数字)
 *
 * 字符串模拟两数相加需要一点技巧 具体见程序里单独抽出来的方法
 *
 * 整理：
 * 1.数字反序链表转字符串
 * 2.字符串相加
 * 3.字符串反序转链
 *
 * 备注：
 * 链表的两数相加
 * 最后还是得回到字符版本的两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class TwoChainAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String numberA = chainToString(l1);   // 1.将链里的数字置换出来
        String numberB = chainToString(l2);

        String sum = stringSum(numberA, numberB);    // 2.字符串求和

        String sumString = sum + "";
        StringBuilder builder = new StringBuilder(sumString);
        String reversedSum = builder.reverse().toString();  // 3.字符串倒序

        ListNode sumNode = new ListNode();
        ListNode tmpHead = sumNode;

        for (int i = 0; i < reversedSum.length(); i++) {    // 4.字符串组装成链
            char currentChar = reversedSum.charAt(i);
            int currentNum = currentChar - 48;
            ListNode nextNode = new ListNode(currentNum);   // 以当前数字构造一个节点
            tmpHead.next = nextNode;    // 将新结点接到头结点尾部
            tmpHead = tmpHead.next;     // 更新尾节点
        }

        return sumNode.next;
    }

    /**
     * chainToString:
     * 链表转字符串
     * */
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

    /**
     * stringSum:
     * 对两个字面值为数字的字符串求和
     * */
    public String stringSum(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;  // 为什么要求一个游标指着字符串的末尾呢? 模拟两数相加的"竖式求法"
        int currentAdd = 0;
        StringBuilder builder = new StringBuilder();

        while (indexA >= 0 || indexB >= 0 || currentAdd > 0) {
            int add1 = indexA >= 0 ? a.charAt(indexA) - 48 : 0;
            int add2 = indexB >= 0 ? b.charAt(indexB) - 48 : 0;
            int result = add1 + add2 + currentAdd;  // 1.1.保留相加之和
            currentAdd = result / 10;   // 1.2.和里取十位数 不清零
            result = result % 10;       // 1.3.进位取末尾
            builder.append(result);     // 1.4.追加末尾的数字
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
