package jin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 * 二维数组重组
 * m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 如果参数不完全匹配，返回原矩阵
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] newArr = new int[r][c];
        List<Integer> list = new ArrayList<>();
        // 遍历
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int current = mat[i][j];
                list.add(current);
            }
        }
        // 组装
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                newArr[i][j] = list.get(cnt++);
            }
        }
        System.out.println(list.toString());
        return newArr;
    }

    public static void main(String[] args) {
        MatrixReshape kid = new MatrixReshape();
        int[][] mat = {{1,2},{3,4}};
        int[][] res = kid.matrixReshape(mat, 1, 4);
        System.out.println(Arrays.toString(res[0]));

    }
}
/**
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 6.37% 的用户
 * */
