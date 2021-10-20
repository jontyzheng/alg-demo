package jin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MoveZero：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZero {

    // list 拼接法
    static public void moveZeroes(int[] nums) {
        int zeroCnt = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        System.out.println(list.size());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                list.add(nums[i]);  // 非零 list
            else
                zeroList.add(0);    // 全 0 list
        }
        list.addAll(zeroList);  // list 合并
        Object[] finalArr = list.toArray();
        for (int i = 0; i < list.size(); i++) {
            int item = Integer.parseInt(finalArr[i].toString());
            nums[i] = item;
        }
    }

    public static void main(String[] args) {
        int[] testArr = {0,1,0,3,12};
        moveZeroes(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
/**
 * 结果墙：
 * 执行用时： 10 ms , 在所有 Java 提交中击败了 6.07% 的用户 内存消耗： 40 MB , 在所有 Java 提交中击败了 5.18% 的用户
 * */
