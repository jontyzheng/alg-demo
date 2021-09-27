package demo.task;

import java.util.Arrays;

/**
 * Leet_34_SearchHeadAndTail：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 用例：头尾坐标若一致 √ 返回 [sameIndex, sameIndex]
 * 用例：数组长度为 1 且唯一的元素与目标值匹配 √ 返回 [sameIndex, sameIndex]
 */
public class Leet_34_SearchHeadAndTail {

    // nums：升序数组
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        // 长度少于 1，你礼貌吗
        if (nums.length <= 1) {
            if (nums.length == 1) {
                if (nums[0] == target) {
                    res[0] = 0;
                    res[1] = 0;
                    return res;
                }
            }
            res[0] = -1;
            res[1] = res[0];
            return res;
        }

        boolean headFound = false;
        int headIndex = -1;
        boolean tailFound = false;
        int tailIndex = -1;

        // >>
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target)
                continue;
            else if (nums[i] == target) {
                headFound = true;
                headIndex = i;
                break;
            } else
                break;
        }
        // <<
        for (int j = nums.length - 1; j >= 0; j--) {
            // j 在右 i 在左
            if (nums[j] > target)
                continue;
            else if (nums[j] == target) {
                tailFound = true;
                tailIndex = j;
                break;
            } else
                break;
        }
        boolean both = headFound & tailFound;
        if (both == true && tailIndex != -1) {
            res[0] = headIndex;
            res[1] = tailIndex;
        } else {
            res[0] = -1;
            res[1] = res[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] nums2 = {5,7,7,8,10};
        int[] nums3 = {1};
        int[] nums4 = {};
        int[] nums5 = {1,3};
        int target = 8;
        int target3 = 1;
        int target4 = 0;
        int target5 = 1;
        int[] res = searchRange(nums, target);
        int[] res2 = searchRange(nums2, target);
        int[] res3 = searchRange(nums3, target3);
        int[] res4 = searchRange(nums4, target4);
        int[] res5 = searchRange(nums5, target5);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
        System.out.println(Arrays.toString(res4));
        System.out.println(Arrays.toString(res5));
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] res = new int[2];
        // 长度少于 1，你礼貌吗
        if (nums.length <= 1) {
            res[0] = -1;
            res[1] = res[0];
            return res;
        }

        boolean headFound = false;
        int headIndex = -1;
        boolean tailFound = false;
        int tailIndex = -1;

        // >>
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target)
                continue;
            else if (nums[i] == target) {
                if (headFound) { // 已经不是第一次遇到
                    // 遇到是缘分，没有是结束
                    tailFound = true;
                    tailIndex = i;
                    res[1] = tailIndex;
                    break;
                } else {
                    headFound = true;
                    headIndex = i;
                    res[0] = headIndex;
                    continue;
                }
            }
        }
        boolean both = headFound & tailFound;
        if (both == true && tailIndex != -1) {
            res[0] = headIndex;
            res[1] = tailIndex;
        } else {
            res[0] = -1;
            res[1] = res[0];
        }
        return res;
    }
}
/**
 * 结果墙
 * 执行结果：
 * 通过
 * 执行用时：
 * 1 ms, 在所有 Java 提交中击败了 13.70% 的用户
 * */
