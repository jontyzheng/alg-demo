package jin;

/**
 * MidSearch：
 */
public class MidSearch {

    // 在不重复升序数组中搜索目标值
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (true) {
            if (target < nums[mid]) {
                // 落在左边往右调
                right = mid - 1;
            } else if (target > nums[mid]) {
                // 落在右边往右调
                left = mid + 1;
            } else {
                return mid; // 否则就刚好匹配到最中间的
            }

            if (left > right) {
                mid = -1;
                break;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }


    public static void main(String[] args) {
        MidSearch focus = new MidSearch();
        int[] a = {1, 4};
        int searchResult = focus.search(a, 4);
        System.out.println("二分结果：" + searchResult);
    }

}
