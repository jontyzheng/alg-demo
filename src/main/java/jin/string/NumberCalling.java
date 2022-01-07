package jin.string;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberCalling {

    // 最少0位最多4位
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] array = digits.toCharArray();
        int len = array.length;
        if (len == 0)
            return result;
        else {
            List<String> numStrings = this.mapEnglish(digits);
            result = this.composePart(numStrings);
        }
        return result;
    }

    // charList: n个按键的字母对
    public List<String> composePart(List<String> charList) {
        List<String> list = new ArrayList<>();
        int size = charList.size();
        switch (size) {
            case 1:
                String s = charList.get(0);
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    list.add(Character.toString(c));
                }
                return list;
            case 2:
                return this.forfor(charList);
            case 3:
                return this.forforfor(charList);
            case 4:
                return this.doubleforfor(charList);
            default:
                return list;
        }
    }

    // 2个按键
    public List<String> forfor(List<String> stringList) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < stringList.get(0).length(); i++) {  // get(0)是abc的长度
            for (int j = 0; j < stringList.get(1).length(); j++) {
                StringBuilder builder = new StringBuilder();
                char c1 = stringList.get(0).charAt(i); // get(0): 第1串 get(0).charAt(0) 第1串里的第1个字母
                char c2 = stringList.get(1).charAt(j); // get(1) 第2串
                builder.append(c1);
                builder.append(c2);
                result.add(builder.toString()); // 将组合添加到容器
            }
        }
        return result;
    }

    // 3个按键
    public List<String> forforfor(List<String> stringList) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < stringList.get(0).length(); i++) {
            for (int j = 0; j < stringList.get(1).length(); j++) {
                for (int k = 0; k < stringList.get(2).length(); k++) {
                    StringBuilder builder = new StringBuilder();
                    char c1 = stringList.get(0).charAt(i);
                    char c2 = stringList.get(1).charAt(j);
                    char c3 = stringList.get(2).charAt(k);
                    builder.append(c1);
                    builder.append(c2);
                    builder.append(c3);
                    result.add(builder.toString()); // 将组合添加到容器
                }
            }
        }
        return result;
    }

    public List<String> doubleforfor(List<String> stringList) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < stringList.get(0).length(); i++) {
            for (int j = 0; j < stringList.get(1).length(); j++) {
                for (int k = 0; k < stringList.get(2).length(); k++) {
                    for (int z = 0; z < stringList.get(3).length(); z++) {
                        StringBuilder builder = new StringBuilder();
                        char c1 = stringList.get(0).charAt(i);
                        char c2 = stringList.get(1).charAt(j);
                        char c3 = stringList.get(2).charAt(k);
                        char c4 = stringList.get(3).charAt(z);
                        builder.append(c1);
                        builder.append(c2);
                        builder.append(c3);
                        builder.append(c4);
                        result.add(builder.toString()); // 将组合添加到容器
                    }
                }
            }
        }
        return result;
    }

    // 号码按键的字母
    public List<String> mapEnglish(String numStr) {
        Integer n = Integer.valueOf(numStr);
        List<Integer> numList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        // 加个栈控制顺序
        Stack<Integer> stack = new Stack<>();
        // 拆数字
        while (n > 0) {
            int digit = n % 10;
            stack.push(digit);
            n = n / 10;
        }
        // 23 - 32
        while (stack.size() > 0) {
            numList.add(stack.pop());
        }
        // 32 -23
        for (int i = 0; i < numList.size(); i++) {
            switch (numList.get(i)) {
                case 2:
                    strList.add("abc");
                    break;
                case 3:
                    strList.add("def");
                    break;
                case 4:
                    strList.add("ghi");
                    break;
                case 5:
                    strList.add("jkl");
                    break;
                case 6:
                    strList.add("mno");
                    break;
                case 7:
                    strList.add("pqrs");
                    break;
                case 8:
                    strList.add("tuv");
                    break;
                case 9:
                    strList.add("wxyz");
                    break;
                default:
                    strList.add("别加了, 号码键没了");
            }
        }
        return strList;
    }

    public static void main(String[] args) {
        NumberCalling jo = new NumberCalling();
        String s = "23";
        List<String> target = jo.letterCombinations(s);
        System.out.println(target.toString());

    }
}
// 执行用时： 1 ms , 在所有 Java 提交中击败了 59.50% 的用户
// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
// 翻译法
