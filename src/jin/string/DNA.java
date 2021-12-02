package jin.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 重复的DNA序列
 * 找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * */
public class DNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 10) {
            return list;
        }
        // 遍历字符串
        char[] array = s.toCharArray();
        // 统计数量, 需要一个哈希表
        HashMap<String, Integer> map = new HashMap<>(); // 子串-次数对
        for (int i = 0, j = i + 10; j < array.length+1; i++, j++) {  // i 对标游标, j 对标从 i 往后的 10 个字母串
            String sub = s.substring(i, j);
            // 截取子串判断并存入
            if (map.containsKey(sub) == false) {
                map.put(sub, 1);
                // 如果先前没有, 存入子串-对应次数
            } else {
                map.put(sub, map.get(sub) + 1);
                // 如果已存在, 重复出现, 更新出现次数
            }
        }
        // 得到所有连续长度为 10 的子串的子串-次数映射表
        Iterator<String> iterator = map.keySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            String next = iterator.next();
            if (map.get(next) >= 1) {
                list.add(next);
                // 从中取次数大于 1 以上的
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DNA dna = new DNA();
        String s = "AAAAAAAAAAA";
        List<String> res = dna.findRepeatedDnaSequences(s);
        System.out.println(res.toString());
    }
}
/**
 * 执行用时： 21 ms , 在所有 Java 提交中击败了 60.19% 的用户
 * */
