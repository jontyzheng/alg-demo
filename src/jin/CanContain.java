package jin;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 * A 中的字母 B 中全都要有，并且次数只能更多不能更少
 * 双枪Map
 *
 */
public class CanContain {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] aArr = ransomNote.toCharArray();
        char[] bArr = magazine.toCharArray();
        Map<Character, Integer> mapA = keyValue(aArr);
        Map<Character, Integer> mapB = keyValue(bArr);
        // mapA中所包含的字母mapB必须得有且还要不少于mapA里面的次数
        boolean flag = true;
        int size = mapA.size();
        for (Character key : mapA.keySet()) {
            if (mapB.get(key) == null || mapB.get(key) < mapA.get(key)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] aArr = ransomNote.toCharArray();
        char[] bArr = magazine.toCharArray();
        Map<Character, Integer> mapB = keyValue(bArr);
        // mapA中所包含的字母mapB必须得有且还要不少于mapA里面的次数
        boolean flag = true;
        int size = magazine.length();
        for (int i = 0; i < ransomNote.length(); i++) {
            char current = ransomNote.charAt(i);
            if (mapB.get(current) == null || mapB.get(current) < 1) {
                flag = false;
                break;  // 若A中出现的字母B中不存在或者拿不出来了。
            } else if (mapB.get(current) >= 1) {
                mapB.put(current, mapB.get(current)-1); //  每次匹配过一个就对应更新一次，不得重复
            }
        }
        return flag;
    }


    // 写一个由数组中以所有出现字符为 key，对应出现次数为 value 的 map
    public Map<Character, Integer> keyValue(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (!map.containsKey(arr[i])) {
                map.put(current, 1);
            } else {
                int times = map.get(current);
                map.put(current, ++times);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String test = "abbd";
        CanContain kid = new CanContain();
        char[] chars = test.toCharArray();
        Map<Character, Integer> resMap = kid.keyValue(chars);
        System.out.println(resMap.toString());

        String ransomNote = "aa", magazine = "aab";
        boolean res = kid.canConstruct(ransomNote, magazine);
        System.out.println("aa是否可以从bb中取材料组成：" + res);
    }
}
/**
 * 执行用时： 11 ms , 在所有 Java 提交中击败了 21.65% 的用户
 * */
