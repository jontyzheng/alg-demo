package jin.array;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 这一道题目主要是求两个数组共同含有的元素有哪些，有重复的也是以其中出现次数更少的数字为基准
 * 比如说数组1是 {4,9,4,9} 数组2是{2,3,4,9} 结果指的应该是{4,9}
 * 比较两个数组中出现过的数字
 * 可以先将其中一个数组所有元素的值和对应出现的次数用一个键值对记录起来
 * 然后到另一个数组中去比对
 * 如果在键值对里找到值不为0的，说明数组2中的这个元素在数组1中也出现过，这个就可以记录起来当作1个
 * 但是如果数组2中出现童同一个数组的次数更多，每次添加当前记录的这个元素，实际上数组1中是没有那么多的
 * 所以也要更新数组1里面对应元素的次数，即以最小的出现次数为准
 * 用到的点：List转基本数据类型数组、哈希表添加值，改变值
 * */
public class TwoArrayContain {
    public static void main(String[] args) {
        int[] nums1 = {9, 4, 9, 8, 4};
        int[] nums2 = {4, 9, 5};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) != null) {
                int num = map.get(nums1[i]);
                num += 1;
                map.put(nums1[i], num); // 更新键值对中的那个值，如果遇到的话
            }
            else {
                map.put(nums1[i], 1);
            }
        }
        // 得到数组1里的元素-出现次数的map
        for (int i = 0; i < nums2.length; i++) {
            // 看 map 中是否包含数组2中出现的元素，有的话说明数组2中出现过数组1中的值
            if (null != map.get(nums2[i])  && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                // 假如数组2中有的元素多了，看作重合的接着继续添加怎么办？此时数组1中实际上并没有这么多
                // 更新数组1里的，假如匹配完1个，数组1(map)里的次数也相应减少一个数量
                int num = map.get(nums2[i]);
                num -= 1;
                map.put(nums2[i], num);
            }
            // 每一次在数组2中找到一个数组1中出现过的数字就记录一次，为了避免超出计算，数组1里的出现次数也更新一次
        }
        int[] target = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        System.out.println(Arrays.toString(target));

    }
}
/**
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 43.50% 的用户
 * */
