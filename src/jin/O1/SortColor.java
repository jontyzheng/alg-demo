package jin.O1;

import java.util.Arrays;

public class SortColor {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = 0;
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] == 0) {
                nums[k++] = 2;
                nums[j++] = 1;
                nums[i++] = 0;
            } else if (nums[x] == 1) {
                nums[k++] = 2;
                nums[j++] = 1;
            } else {
                nums[k++] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        SortColor e = new SortColor();
        e.sortColors(a);
        System.out.println(Arrays.toString(a));

    }
}
