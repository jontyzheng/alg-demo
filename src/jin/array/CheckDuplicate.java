package jin.array;

import java.util.Arrays;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/submissions/
 */
public class CheckDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) {
                    return true;
                }
            }
            return false;
        }
    }
}
/**
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 99.39% 的用户
 * 排序后判断相邻元素
 */

