package jin.array;

/**
 * 二分查找二维版
 * 对每一行二分
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class BiSearchTwoDimen {

    // 方案一：对每行二分(结果：-)
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean yes = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            /**
             * 单个元素的数组
             * */
            if (row.length == 1) {
                if (target == row[0]) {
                    return true;
                } else {
                    continue;
                }
            }
            int resIndex = midFind(row, target);
            if (resIndex == -1) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public int midFind(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;   // right: 数组长度-1
        int mid = (left + right) / 2;

        while (true) {
            // 大了往左调
            int midNum = array[mid];
            if (target < midNum) {
                right = mid - 1;
            } else if (target > midNum) {
                left = mid + 1;
            } else {
                return mid;
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
        BiSearchTwoDimen focus = new BiSearchTwoDimen();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] bb = {{-5}};
        int target = 5;
        boolean b = focus.searchMatrix(matrix, target);
        System.out.println("二维矩阵中是否含有 " + target + "：" + b);

        int[] a = {1, 4};
        int i = focus.midFind(a, 4);


    }
}
/**
 * 执行用时： 6 ms , 在所有 Java 提交中击败了 38.77% 的用户
 * */
