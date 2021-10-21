package jin;

import java.util.Arrays;

/**
 * ReverseString：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 链接：https://leetcode-cn.com/problems/reverse-string
 */
public class ReverseString {
    static public void reverseString(char[] s) {
        String s1 = new String(s);
        String s2 = new StringBuilder(s1).reverse().toString();
        for (int i = 0; i < s2.length(); i++) {
            s[i] = s2.charAt(i);
        }
    }

    public static void main(String[] args) {
        char[] a = {'h','e','l','l','o'};
        reverseString(a);
        System.out.println(Arrays.toString(a));
    }
}
/**
 * 运算结果：
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 95.61% 的用户
 * */
