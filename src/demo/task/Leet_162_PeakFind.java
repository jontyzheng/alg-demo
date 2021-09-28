package demo.task;

/**
 * Leet_162_PeakFind：峰值：大于相邻元素的数字即视为峰值，数组外的元素可视为 -⚭（也就是说两端的数字也可以是峰值）
 * [1] 预期结果： 0
 * [2,1] 预期结果：0
 * [1,2] 预期结果：1
 * https://leetcode-cn.com/problems/find-peak-element/submissions/
 */
public class Leet_162_PeakFind {
    static public int findPeakElement(int[] nums) {
        // 个数为 1
        if (nums.length == 1)
            return 0;
        // 个数为 2
        if (nums[0] > nums[1])
            return 0;
        // 不考虑两端的数字
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        // 最后一个数字
        if (nums[nums.length-2] < nums[nums.length-1] )
            return nums.length-1;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int peakIndex = findPeakElement(nums);
        System.out.println("峰值的坐标索引：" + peakIndex);
    }
}
/**
 * 结果墙：
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
