package demo.task;

import java.util.Stack;

/**
 * Leet_844_BackspaceString：
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 输入：S = "ab#c", T = "ad#c" 输出：true
 * 输入：S = "ab##", T = "c#d#" 输出：true
 * 输入：S = "a##c", T = "#a#c" 输出：true
 * 输入：S = "a#c", T = "b" 输出：false
 * tips：看到解法里有一个栈，然后原来也是因为有连续两个需要被退格的字符时没办法处理
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Leet_844_BackspaceString {
    static public boolean backspaceCompare(String s, String t) {
        if (s.equals(t))
            return true;
        String s1 = doSomething2(s);
        String s2 = doSomething2(t);
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ae#c";
        System.out.println(backspaceCompare(s, t));
    }

    // 标记法：将#置和#前面一位置-，扫描并拼接非-的字符
    // 局限性：连续#的时候后一个#置-的就是前一个#
    static public String doSomething(String s) {
        int len = s.length();
        char[] a = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (a[i] == '#') {
                a[i] = '-';
                if (i - 1 > 0) {
                    a[i - 1] = '-';
                }
            }
        }
        StringBuilder sbu = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != '-') {
                sbu.append(a[i]);
            }
        }
        return sbu.toString();
    }

    static public String doSomething2(String s) {
        StringBuilder sbu = new StringBuilder();
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case '#':
                    if (stack.isEmpty()==false) {
                        stack.pop();
                    }
                    break;
                    // 遇到#且管道里不为空时，弹出一个
                default:
                    stack.push(arr[i]);
                    // 否则，遇到一个往里面塞一个
            }
        }
        while (stack.isEmpty() == false) {
            sbu.append(stack.pop());
        }
        return sbu.reverse().toString();
    }
}
/**
 * 结果墙：
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 66.42% 的用户
 * */
