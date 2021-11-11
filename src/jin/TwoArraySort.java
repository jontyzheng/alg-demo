package jin;

import java.util.Arrays;

/**
 * 最小 min 交换法
 */
public class TwoArraySort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[cnt++];
        }
        sort(nums1);
    }

    public void sort(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] <= a[min]) {
                    min = j;
                }
            }
            // min：最小元素所站在的坐标：j 一个个让给它
            if (min != i) {
                int temp = 0;
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        TwoArraySort man = new TwoArraySort();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        man.merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}
/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * */
