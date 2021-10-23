package jin;

import java.util.ArrayList;
import java.util.List;

/**
 * LongestUnrepeated：去年在图书馆里想到的意象，长度最长的子串，如果看作一串豆子的，不同的豆子就像是不同的吃豆人在吃豆子
 * 最后谁吃到的最多就是最后的吃豆人了
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class BeanEater {
    public static void main(String[] args) {
        String test = "pwwkew";
        int i = lengthOfLongestSubstring(test);
        System.out.println(i);
    }

    static public int lengthOfLongestSubstring(String s) {
        char[] beans = s.toCharArray();
        int len = s.length();
        if (len <= 1)
            return len;
        List<Character> fattest = new ArrayList<>();
        for (int i = 0; i < beans.length - 1; i++) {    // 遍历到倒数第二位就好，为后面 j 作准备
            // 每个点都埋点一个吃豆人
            List<Character> eater = new ArrayList<>();
            // 首先吃掉当前的豆子
            eater.add(beans[i]);
            for (int j = i + 1; j < len; j++) {
                char curBean = beans[j];
                // 继续前进，只吃没吃过的豆子。如果发现没吃过的豆子就吃掉
                if (eater.contains(curBean) == false) {
                    char newBean = curBean;
                    eater.add(newBean);
                }
                // 否则就跳出不吃了
                else {
                    break;
                }
            }
            // 每个吃完豆子的人都要和原来 longest 的肚子比一下谁的更大，大的当老大
            if (eater.size() > fattest.size()) {
                fattest = eater;
            }
            //  由于每个点都埋点了一个吃豆人，所以就不会漏下任何一种情况了
        }
        return fattest.size();
        // 最后吃不同豆子吃得最多的就是最后的结果了
    }

}
/**
 * 结果墙：
 * 987 / 987 个通过测试用例 状态：通过 执行用时: 614 ms
 *
 * */
