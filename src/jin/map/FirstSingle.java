package jin.map;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 找出字符串中第一个唯一的元素：map+匹配次数
 * */
public class FirstSingle {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, 1);
            } else if (map.get(c) > 0) {
                Integer oldTimes = map.get(c);
                map.put(c, ++oldTimes);
            }   // 更新值
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FirstSingle kid = new FirstSingle();
        String s = "loveleetcode";
        int res = kid.firstUniqChar(s);
        System.out.println("第一个唯一元素出现的坐标：" + res);


    }
}
/**
 * 执行用时： 36 ms , 在所有 Java 提交中击败了 8.42% 的用户
 * */
