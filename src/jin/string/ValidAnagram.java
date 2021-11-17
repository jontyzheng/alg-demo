package jin.string;


import java.util.Arrays;

/**
 * 判断两个字符串是不是只有顺序不同
 * https://leetcode-cn.com/problems/valid-anagram/
 * 排序后比较
 * */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr,tArr);
    }

    public static void main(String[] args) {
        ValidAnagram kid = new ValidAnagram();
        String s = "anagram", t = "nagaram";
        boolean res = kid.isAnagram(s, t);
        System.out.println("anagram 和 nagaram 是不是同位异性串："+res);
    }
}
/**
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 74.05% 的用户
 * */
