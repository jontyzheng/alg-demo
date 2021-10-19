package demo.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leet_438_AllSortSubstring：给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指字母相同，但排列不同的字符串。
 * 输入: s = "cbaebabacd", p = "abc" 输出: [0,6]
 * 输入: s = "abab", p = "ab" 输出: [0,1,2]
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */
public class Leet_438_AllSortSubstring {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> anaList = findAnagrams(s, p);
        System.out.println(anaList.toString());
    }

    /**
     * 1、列出一个 p 所有字符的可能性的集合，然后每到一位比较是否含有（列出所有未知长度的排序序列不好列）
     * 2、每到一位，两边都排序一次再一起比较，排序后相同就匹配（每到一位都调用一次排序方法，超时）
     */
    static public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexList = new ArrayList<>();
        int pLen = p.length();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, i + pLen);
            if (sameContain(sub, p)) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    // contains same chars(排序比较)
    // 子方法，每次在 s 中 p 位数的字符串与 p 比对调用，保证每次长度都是一样的
    static public boolean sameContain(String s, String p) {
        boolean yesOrNot = true;
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        // 只有顺序不一样
        Arrays.sort(sChar);
        Arrays.sort(pChar);
        // 重组
        String newC = new String(sChar);
        String newP = new String(pChar);
        // 比对
        return newC.equals(newP);
    }
    // 性能：每到一位都要排序一次，比较耗时

    static public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> indexList = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] pAlpha = new int[26];
        int[] sAlpha = new int[26];
        // 遍历 p 字符串：在 p 的长度内，利用遍历将两个字符串这段长度内字母的情况都描出来
        for (int i = 0; i < pLen; i++) {
            // 记录在 pLen 位数内两个字符串包含字母的次数，记录在 26 个字母的数组上，字母头上是 2 说明这个字母出现了 2 次
            ++pAlpha[p.charAt(i) - 'a'];
            ++sAlpha[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(pAlpha, sAlpha)) {
            indexList.add(0);
        }
        // 往后面找
        for (int i = pLen; i < sLen; i++) {
            ++sAlpha[s.charAt(i) - 'a'];    // 描后面部分出现的字母
            --sAlpha[s.charAt(i - pLen) - 'a'];
            if (Arrays.equals(pAlpha, sAlpha))
                indexList.add(i - pLen + 1);
        }
        return indexList;
    }

    static public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> indexList = new ArrayList<>();
        int[] charCount = new int[26];
        char[] sArr = s.toCharArray();
        char[] pChar = p.toCharArray();
        int pLen = p.length();
        int sLen = s.length();
        // 遇到一个 a 就在 0 的位置加上一个 1，遇到一个 c 就在 2 的位置加上一个 1（charAt[i] - 'a'）
        for (int i = 0; i < pLen; i++) {
            charCount[p.charAt(i) - 'a'] += 1;
        }
        int l = 0;
        int r = 0;
        // 当左边界小于等于长度差时
        while (l <= sLen - pLen) {



            l++;
        }



        return indexList;
    }
}
