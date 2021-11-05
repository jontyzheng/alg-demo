package jin;

/**
 * SearchInsert：搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/submissions/
 */
public class SearchInsert {
    static public int searchInsert(int[] nums, int target) {
        // [2, 3, 4] 1
        if (nums[0] >= target)
            return 0;
        // [1,3,5,6] 7
        if (nums[nums.length-1] < target)
            return nums.length-1+1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < target)
                continue;
            else if (nums[i] == target)
                return i;
            else
                return i;
            // 遇到更大的数字不是往后退，当前位置正是插入的正确位置
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6};
        int res = searchInsert(a, 7);
        System.out.println(res);

    }
}
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */