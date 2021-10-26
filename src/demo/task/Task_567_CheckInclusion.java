package demo.task;

import java.util.Arrays;

/**
 * Task_567_CheckInclusion：
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * https://leetcode-cn.com/problems/permutation-in-string
 * 加入 s2 从一个位置开始往后 s1 个长度，比对两者组成的字符吻合，便可以作为判断 s2 中包含 s1 排列组合的子字符串的根据
 */
public class Task_567_CheckInclusion {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        boolean res = checkInclusion(s1, s2);
        System.out.println(res);
    }

    static public boolean checkInclusion(String s1, String s2) {
        int len = s2.length();
        int subLen = s1.length();
        int end = len - subLen + 1;
        for (int i = 0; i < end; i++) {
            if (containsAll(s1, s2.substring(i, i+subLen)))  // 截取字串去和 s1 比对
                return true;
        }
        return false;
    }

    // 思路1：判断两个字符串是否由同一组字符组成：遍历 s2，每遍历一个字母便将 s1 中对应包含的字符置为' ' 直到 s1 中全置为' ' 则可以说明 s2 中有的 s1 都有
    // 思路2：排序后一致，也是证明两者一致的方法之一
    static public boolean containsAll(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);
        s1 = new String(s1Arr);
        s2 = new String(s2Arr);
        return s1.equals(s2);
    }
}
/**
 * 结果墙
 * 执行用时： 1494 ms , 在所有 Java 提交中击败了 5.01% 的用户
 * */
