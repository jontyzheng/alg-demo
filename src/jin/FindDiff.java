package jin;

import java.util.Arrays;

/**
 * FindDiff：389. 找不同
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 输入：s = "", t = "y"
 * 输出："y"
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class FindDiff {
    static public char findTheDifference(String s, String t) {
        if (s.length() == 0)
            return t.charAt(0);
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != tt[i])
                return tt[i];
        }
        return tt[tt.length-1];
    }

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        char theDifference = findTheDifference(s, t);
        System.out.println("结果：" + theDifference);
    }

}
/**
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 47.97% 的用户
 * */
