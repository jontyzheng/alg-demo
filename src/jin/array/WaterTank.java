package jin.array;

// 一组高度向中间走, 更矮的每次往中间走, 并计算每走一步两者中间的空间面积, 并更新面积使得最大面积得到保存, 那么当两个相遇时, 最后总能得到整组高度所能得到的最大空间【高脚理论】
public class WaterTank {
    public int maxArea(int[] height) {
        // min(height[i], height[j]) * (j-i)
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = h * (j - i) > res ? h * (j - i) : res;
            if (height[i] < height[j])
                i++;
            else
                j--;
            // (高度更矮的往里走, 高度更高的往里走只会越走越窄)
        }
        return res;
    }

    public static void main(String[] args) {
        WaterTank jo = new WaterTank();
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = jo.maxArea(a);
        System.out.println("结果：" + i);


    }
}
// https://leetcode-cn.com/problems/container-with-most-water/
