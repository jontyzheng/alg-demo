package jin.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 杨辉三角
 * 模拟和取值
 * */
public class YangTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        list.add(ls1);
        // 首先排除基础情形的
        if (numRows == 1) {
            return list;
        }

        List<Integer> ls2 = new ArrayList<>();
        ls2.add(1);
        ls2.add(1);
        list.add(ls2);
        if (numRows == 2) {
            return list;
        }
        // 第2行（因为上一行行号是从 row1 里取）
        for (int i = 2; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            // 开头位置
            rowList.add(1);
            int row = i;
            // 中间位置 遍历到当前行长度的前一个 j：被赋值移动的游标
            for (int j = 1; j < row; j++) {
                Integer leftTop = list.get(i - 1).get(j - 1);   // 退一行，退一列
                Integer rightTop = list.get(i - 1).get(j);  // 退一行，取同一列
                int sum = leftTop + rightTop;
                rowList.add(sum);   // 当前行出来取
            }
            // 结尾位置
            rowList.add(1);
            list.add(rowList);
        }
        return list;
    }

    public static void main(String[] args) {
        YangTriangle kid = new YangTriangle();
        List<List<Integer>> res = kid.generate(5);
        System.out.println(res.toString());

    }
}
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * */
