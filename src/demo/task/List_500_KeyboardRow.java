package demo.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List_500_KeyboardRow：给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。
 * 键盘如下图所示。美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 */
public class List_500_KeyboardRow {
    static public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        /**
         * 若单词元素中所有的字母可以在一条行中找齐，就视为可以由单行键盘敲成
         * */
        for (int i = 0; i < words.length; i++) {
            String theWord = words[i].toLowerCase();    // 统一转小写
            if (allIn(theWord, row1)) {
                list.add(words[i]);// 有一行成立则要求
            }
            else if (allIn(theWord, row2)) {
                list.add(words[i]);// 有一行成立则要求
            }
            else if (allIn(theWord, row3)) {
                list.add(words[i]);// 有一行成立则要求
            }
        }
        String[] res = new String[list.size()]; // list.size()
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 比对两个字符串：s1 里出现过的字符是不是都可以在 source 中找到
     * */
    static public boolean allIn(String s1, String source) {
        boolean allIn = true;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!source.contains(c+"")) {
                allIn = false;  // 若 s1 有一个字母在 source 的范围之外，则视为无法由源行敲得
                break;
            }
        }
        return allIn;
    }

    public static void main(String[] args) {
        // String s1 = "wer";
        // String source = "wde";
        // System.out.println(allIn(s1, source));

        String[] words = {"Alaska","Dad","Peace"};
        String[] words1 = findWords(words);
        System.out.println(Arrays.toString(words1));
    }
}
/**
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * */
/**
 * 执行效果：执行用时： 5 ms , 在所有 Java 提交中击败了 18.37% 的用户
 * */

