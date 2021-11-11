package jin.array;

/**
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] parts = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            int add1 = nums[i];
            int remain = target - add1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == remain) {
                    parts[0] = i;
                    parts[1] = j;
                    break outer;
                }
            }
        }
        return parts;
    }
}
/**
 * 执行用时： 38 ms , 在所有 Java 提交中击败了 44.45% 的用户
 * */
