package se.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * EmptyCharArr：每个字符都为空格的字符数组，最后形成的字符串长度
 * 事实：否，变化后的 s.length() 不能作为判断条件
 */
public class EmptyCharArr {
    public static void main(String[] args) {
        char[] emptyCharArr = {' ', ' ', ' '};
        System.out.println(new String(emptyCharArr).length());
        // 如何判断一个char数组是由一个只由空格组成的char数组
        String s = new String(emptyCharArr);
        // 利用 list.contains
        // 条件是将 char[] 转化为 Character[] 这样才能将 char[] 转成一个 List
        List<Character> list = new ArrayList<>();
        // Collections.addAll(list, (Character[]) emptyCharArr);

    }
}
