package jin.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角第几行
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * */
public class YangTriangleList {
    public List<Integer> getRow(int rowIndex) {
        // 前面不用构造行
        List<Integer> list = new ArrayList<>();

        List<List<Integer>> rowList = new ArrayList<>();   // 二维三角阵

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        rowList.add(row1);   // 完善三角阵

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        rowList.add(row2);    // 完善三角阵

        if (rowIndex < 2) {
            return rowList.get(rowIndex); // 如果是两行以内，到此即可返回
        }

        // 已加满前面两行 打下基础

        // 开始追加第 3 行的元素
        for (int i = 2; i < rowIndex+1; i++) {    // i: 表示行号：当前行号：2 rowIndex 表第几行 实际上的循环终点往后加一才对

            List<Integer> curRow = new ArrayList<>();
            // 新建待构造行

            curRow.add(1);
            // 第一个总是 1

            for (int col = 1; col < i; col++) {       // 从 2 个开始，倒数第二个结束 原长度刚好是行号

                int leftUp = rowList.get(i - 1).get(col - 1);   // 从三角阵里取
                int rightUp = rowList.get(i - 1).get(col);      // 从三角阵里取
                int sum = leftUp + rightUp;
                // 按照"晶"的结构，从下面第二个日开始，上一行左边的应该还是第一个
                // 每次取的坐标号都是小一(左上) 右上取的坐标才刚好是和自己相同
                curRow.add(sum);
            }

            curRow.add(1);
            // 最后一个总是 1

            list.addAll(curRow);    // 追加元素
            rowList.add(curRow);    // 完善三角阵
        }
        return rowList.get(rowIndex);
    }

    public static void main(String[] args) {
        YangTriangleList vv = new YangTriangleList();
        List<Integer> row = vv.getRow(4);
        System.out.println(row.toString());

    }
}
/**
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 30.15% 的用户
 * */
