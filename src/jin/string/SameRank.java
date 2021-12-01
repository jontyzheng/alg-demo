package jin.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个字符串数组和一个字符排列的规律是否相同
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * https://leetcode-cn.com/problems/word-pattern/
 * */
public class SameRank {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length)
            return false;
        boolean sameFlag = true;
        Map<Character, String> map = new HashMap<>();
        /**
         * 如果有存在key则从map中取出值与当前比对 不对应的说明不对应
         * 如果没存在key说明之前没有存过, 存入当前key和值
         * */
        for (int i = 0; i < strings.length; i++) {
            char currentChar = pattern.charAt(i);
            String currentString = strings[i];
            if (map.get(currentChar) != null) {
                String had = map.get(currentChar);
                if (!had.equals(currentString)) {
                    sameFlag = false;
                    break;
                }
            } else {
                boolean alreadyHad = map.containsValue(currentString);
                if (alreadyHad) {
                    sameFlag = false;
                    break;
                }
                map.put(currentChar, currentString);
            }
        }
        return sameFlag;
    }
    /**
     * 情形二：abba dog dog dog dog
     * 此时，虽然竖着看一一对应，但是与词型不服 abba 和 AAAA 型。
     * 如果时原来值存在的，从原来的 map 里验证一番，只有没有字符匹配过的字符串才重新存
     * 参考：https://leetcode-cn.com/problems/word-pattern/comments/131804
     * */

    public static void main(String[] args) {
        SameRank focus = new SameRank();
        String pattern = "abba";
        String s = "dog dog dog dog";
        boolean res = focus.wordPattern(pattern, s);
        System.out.println(pattern + "和" + s + " 是不是同规律排列：" + res);


    }
}
/**
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 90.23% 的用户
 * */
