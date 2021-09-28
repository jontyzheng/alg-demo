package demo.task;

import java.util.Arrays;

/**
 * Leet_153_RotatePaper：
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Leet_153_RotatePaper {

    public int findMin1(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    // 抓住了旋转函数的特点：原来升序且互不相同的数组，旋转后原来整齐的顺序一定会被破坏，且正好是最大元素的前面
    static public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        for (int j = 0; j < nums.length-1; j++) {
            if (nums[j] > nums[j+1]) {
                return nums[j+1];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println("旋转数组中的 min：" + min);
    }
}
/**
 * 结果墙
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
