package jin;

import java.util.Stack;

/**
 * 判断括号是否连续成对 {[]} ()[]{}
 * [
 * ((
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class BracketPairs {
    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;
        boolean valid = true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            switch (item) {
                case '(':
                case '{':
                case '[':
                    stack.push(item);
                    break;
                case ']':
                    if (stack.size() == 0) {
                        valid = false;
                        break;
                        // 匹配值栈里为空，说明前面没有左括号了，无从匹配，说明是当前这个只有右括号没有与之匹配的左括号前面
                    } else {
                        char popped = stack.pop();
                        if (popped != '[') {
                            valid = false;
                            break;
                        }
                        // 栈里有左括号，但是弹出来，最近的左括号和当前不匹配，说明括号不是成对挨在一起的
                    }
                    break;
                case '}':
                    if (stack.size() == 0) {
                        valid = false;
                        break;
                        // 匹配值栈里为空，说明前面没有左括号了，无从匹配，说明是当前这个只有右括号没有与之匹配的左括号前面
                    } else {
                        char popped = stack.pop();
                        if (popped != '{') {
                            valid = false;
                            break;
                        }
                        // 栈里有左括号，但是弹出来，最近的左括号和当前不匹配，说明括号不是成对挨在一起的
                    }
                    break;
                default:
                    if (stack.size() == 0) {
                        valid = false;
                        break;
                        // 匹配值栈里为空，说明前面没有左括号了，无从匹配，说明是当前这个只有右括号没有与之匹配的左括号前面
                    } else {
                        char popped = stack.pop();
                        if (popped != '(') {
                            valid = false;
                            break;
                        }
                        // 栈里有左括号，但是弹出来，最近的左括号和当前不匹配，说明括号不是成对挨在一起的
                    }
                    break;
            }
        }
        // 结束匹配后，检查括号栈，还有剩余说明左括号有多
        if (stack.size() >= 1) {
            valid = false;
        }
        return valid;
    }


    public static void main(String[] args) {
        BracketPairs kid = new BracketPairs();
        String s = "{[]}";
        System.out.println("()是不是连续成对括号");
        System.out.println(kid.isValid(s));
    }
}
/**
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.90% 的用户
 * */
